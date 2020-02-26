package jp.co.ricoh.cotos.electriccommonlib;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.ActionDiv;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.AuthDiv;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService.AuthLevel;
import jp.co.ricoh.cotos.electriccommonlib.security.CotosElcAuthenticationDetails;

public class WithMockCustomUserSecurityContextFactory implements WithSecurityContextFactory<WithMockCustomUser> {
	@Override
	public SecurityContext createSecurityContext(WithMockCustomUser customUser) {
		SecurityContext context = SecurityContextHolder.createEmptyContext();

		CotosElcAuthenticationDetails principal = null;
		if (customUser.actionDiv() == ActionDiv.なし) {
		    principal = new CotosElcAuthenticationDetails(customUser.momEmployeeId(), customUser.singleUserId(), customUser.origin(), customUser.applicationId(), customUser.jwt(), customUser.isSuperUser(), customUser.isDummyUser(), createMomAuthorities());
		} else {
			principal = new CotosElcAuthenticationDetails(customUser.momEmployeeId(), customUser.singleUserId(), customUser.origin(), customUser.applicationId(), customUser.jwt(), customUser.isSuperUser(), customUser.isDummyUser(), createMomAuthorities(customUser));
		}
		Authentication auth = new PreAuthenticatedAuthenticationToken(principal, "password", principal.getAuthorities());
		context.setAuthentication(auth);
		return context;
	}

	private Map<ActionDiv, Map<AuthDiv, AuthLevel>> createMomAuthorities() {

		Map<ActionDiv, Map<AuthDiv, AuthLevel>> userMomAuthorities = new HashMap<>();

		Arrays.asList(ActionDiv.values()).stream().filter(actionDiv -> actionDiv != ActionDiv.なし).forEach(actionDiv -> {
			Map<AuthDiv, AuthLevel> authorities = Arrays.asList(AuthDiv.values()).stream().filter(authDiv -> authDiv != AuthDiv.なし).collect(Collectors.toMap(authDiv -> authDiv, authDiv -> {
				return AuthLevel.すべて;
			}));

			userMomAuthorities.put(actionDiv, authorities);
		});

		return userMomAuthorities;
	}
	
	private Map<ActionDiv, Map<AuthDiv, AuthLevel>> createMomAuthorities(WithMockCustomUser customUser) {
		
		Map<AuthDiv, AuthLevel> authorities = Collections.singletonMap(customUser.authDiv(), customUser.authLevel());

		return Collections.singletonMap(customUser.actionDiv(), authorities);
	}
}