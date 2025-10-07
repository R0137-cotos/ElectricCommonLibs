package jp.co.ricoh.cotos.electriccommonlib.security;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.ActionDiv;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.AuthDiv;
import jp.co.ricoh.cotos.commonlib.logic.message.MessageUtil;
import jp.co.ricoh.cotos.commonlib.repository.master.DummyUserMasterRepository;
import jp.co.ricoh.cotos.commonlib.repository.master.SuperUserMasterRepository;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService.AuthLevel;
import jp.co.ricoh.cotos.commonlib.util.ClaimsProperties;
import jp.co.ricoh.cotos.commonlib.util.JwtProperties;
import jp.co.ricoh.cotos.electriccommonlib.security.mom.ElcMomAuthorityService;
import jp.co.ricoh.cotos.electriccommonlib.util.StandardProperties;

@Component
public class CotosElcUserDetailsService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

	/** ロガー */
	private static final Log log = LogFactory.getLog(CotosElcUserDetailsService.class);

	public static final String DUMMY_MOM_AUTH = "NO_AUTHORITIES";

	@Autowired
	JwtProperties jwtProperties;

	@Autowired
	ClaimsProperties claimsProperties;

	@Autowired
	StandardProperties standardProperties;

	@Autowired
	ElcMomAuthorityService elcMomAuthorityService;

	@Autowired
	MessageUtil messageUtil;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	SuperUserMasterRepository superUserMasterRepository;

	@Autowired
	DummyUserMasterRepository dummyUserMasterRepository;

	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {

		// 認証用ヘッダーを取得
		String authenticationHeader = token.getPrincipal().toString();
		CotosElcAuthenticationDetails cotosElcAuthenticationDetails = null;

		try {
			cotosElcAuthenticationDetails = this.decodeAuthentication(authenticationHeader);
			if (cotosElcAuthenticationDetails == null || StringUtils.isAnyBlank(cotosElcAuthenticationDetails.getMomEmployeeId(), cotosElcAuthenticationDetails.getSingleUserId(), cotosElcAuthenticationDetails.getOrigin(), cotosElcAuthenticationDetails.getApplicationId())) {
				throw new UsernameNotFoundException("user not found");
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("failure verification", e);
		}

		// リクエスト元のOriginと、JWTのオリジンを比較
		String requestOrigin = token.getCredentials().toString();

		if (!StringUtils.isBlank(requestOrigin) && !requestOrigin.equals(cotosElcAuthenticationDetails.getOrigin())) {
			throw new UsernameNotFoundException("Origin Not Allowed");
		}

		return cotosElcAuthenticationDetails;
	}

	private CotosElcAuthenticationDetails decodeAuthentication(String authenticationHeader) throws Exception {

		// Bearer属性を取得
		if (authenticationHeader.startsWith("Bearer ")) {

			String jwtString = authenticationHeader.substring("Bearer ".length());

			Algorithm algorithm = Algorithm.HMAC256(jwtProperties.getSecretKey());
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(jwtString);

			// スーパーユーザーか判定
			boolean isSuperUser = superUserMasterRepository.existsByUserId(jwt.getClaim(claimsProperties.getMomEmpId()).asString());
			// ダミーユーザーか判定
			boolean isDummyUser = dummyUserMasterRepository.existsByUserId(jwt.getClaim(claimsProperties.getMomEmpId()).asString());

			Map<ActionDiv, Map<AuthDiv, AuthLevel>> momAuthorities = null;
			// 認証ドメインでMoM権限が取得できた場合(取得できないとJWTからmomAuthの項目が削除される)
			if (StringUtils.isNotEmpty(jwt.getClaim(claimsProperties.getMomAuth()).asString()) && !jwt.getClaim(claimsProperties.getMomAuth()).asString().equals(DUMMY_MOM_AUTH)) {
				// JWTにある権限情報を取得
				momAuthorities = objectMapper.readValue(jwt.getClaim(claimsProperties.getMomAuth()).asString(), new TypeReference<Map<ActionDiv, Map<AuthDiv, AuthLevel>>>() {
				});
			} else if (StringUtils.isEmpty(jwt.getClaim(claimsProperties.getMomAuth()).asString())) {
				// シングルユーザーIDに紐づく権限情報を取得
				momAuthorities = elcMomAuthorityService.searchAllMomAuthorities(jwt.getClaim(claimsProperties.getSingleUserId()).asString());
			}

			// 一般ユーザーで、MoM権限ユーザーが取得できない場合はエラー
			if (!isSuperUser && momAuthorities == null) {
				log.error(messageUtil.createMessageInfo("NoMomAuthoritiesError", Arrays.asList(jwt.getClaim(claimsProperties.getSingleUserId()).asString()).toArray(new String[0])).getMsg());
				throw new Exception();
			}

			return new CotosElcAuthenticationDetails(jwt.getClaim(claimsProperties.getMomEmpId()).asString(), jwt.getClaim(claimsProperties.getSingleUserId()).asString(), jwt.getClaim(claimsProperties.getOrigin()).asString(), jwt.getClaim(claimsProperties.getApplicationId()).asString(), jwtString, isSuperUser, isDummyUser, momAuthorities);
		}

		return null;
	}
}