package jp.co.ricoh.cotos.electriccommonlib.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * テスト用投票クラス
 */
@Component
public class AbstainTestVoter implements AccessDecisionVoter<FilterInvocation> {

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {

		boolean hasBody = Boolean.valueOf(fi.getRequest().getParameter("hasBody"));
		boolean isSuccess = Boolean.valueOf(fi.getRequest().getParameter("isSuccess"));
		if (Boolean.valueOf(fi.getRequest().getParameter("isAbstainOriginal"))) {
			return ACCESS_ABSTAIN;
		}

		if (hasBody) {
			try {
				// リクエストBODYから情報を取得
				ObjectMapper om = new ObjectMapper();
				om.readValue(fi.getHttpRequest().getInputStream(), TestEntity.class);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}

		if (isSuccess) {
			return ACCESS_GRANTED;
		} else {
			return ACCESS_DENIED;
		}
	}
}
