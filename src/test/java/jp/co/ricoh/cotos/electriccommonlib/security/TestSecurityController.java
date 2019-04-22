package jp.co.ricoh.cotos.electriccommonlib.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.ricoh.cotos.commonlib.logic.check.CheckUtil;
import lombok.Data;

/**
 *
 * テスト実施用コントローラクラス
 *
 */
@Data
@RestController
@RequestMapping("/test/api")
public class TestSecurityController {

	@Autowired
	CheckUtil checkUtil;

	private String swaggerBody = "swagger";

	@RequestMapping(method = RequestMethod.GET, path = "/test/{id}")
	@Transactional
	public String get() {
		CotosElcAuthenticationDetails userInfo = (CotosElcAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userInfo.getSingleUserId() + "," + userInfo.getMomEmployeeId() + "," + userInfo.getOrigin() + "," + userInfo.getApplicationId() + "," + userInfo.getJwt() + "," + userInfo.isSuperUser() + "," + Boolean.toString(userInfo.getMomAuthorities() != null);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/test")
	@Transactional
	public String post() {
		CotosElcAuthenticationDetails userInfo = (CotosElcAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userInfo.getSingleUserId() + "," + userInfo.getMomEmployeeId() + "," + userInfo.getOrigin() + "," + userInfo.getApplicationId() + "," + userInfo.getJwt() + "," + userInfo.isSuperUser() + "," + Boolean.toString(userInfo.getMomAuthorities() != null);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/test")
	@Transactional
	public String put() {
		CotosElcAuthenticationDetails userInfo = (CotosElcAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userInfo.getSingleUserId() + "," + userInfo.getMomEmployeeId() + "," + userInfo.getOrigin() + "," + userInfo.getApplicationId() + "," + userInfo.getJwt() + "," + userInfo.isSuperUser() + "," + Boolean.toString(userInfo.getMomAuthorities() != null);
	}

	@GetMapping(path = "/swagger-ui.html")
	public String swagger() {
		return swaggerBody;
	}
}
