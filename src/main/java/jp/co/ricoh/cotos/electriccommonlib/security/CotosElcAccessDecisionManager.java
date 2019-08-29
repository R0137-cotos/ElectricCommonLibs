package jp.co.ricoh.cotos.electriccommonlib.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.core.Authentication;

public class CotosElcAccessDecisionManager extends AbstractAccessDecisionManager {

	public CotosElcAccessDecisionManager(List<AccessDecisionVoter<? extends Object>> decisionVoters) {
		super(decisionVoters);
	}

	// ~ Methods
	// ========================================================================================================

	/**
	 * This concrete implementation simply polls all configured
	 * {@link AccessDecisionVoter}s and grants access if any
	 * <code>AccessDecisionVoter</code> voted affirmatively. Denies access only if
	 * there was a deny vote AND no affirmative votes.
	 * <p>
	 * If every <code>AccessDecisionVoter</code> abstained from voting, the decision
	 * will be based on the {@link #isAllowIfAllAbstainDecisions()} property
	 * (defaults to false).
	 * </p>
	 *
	 * @param authentication
	 *            the caller invoking the method
	 * @param object
	 *            the secured object
	 * @param configAttributes
	 *            the configuration attributes associated with the method being
	 *            invoked
	 *
	 * @throws AccessDeniedException
	 *             if access is denied
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException {

		for (AccessDecisionVoter voter : getDecisionVoters()) {
			int result = voter.vote(authentication, object, configAttributes);

			switch (result) {
			case AccessDecisionVoter.ACCESS_GRANTED:
				return;

			case AccessDecisionVoter.ACCESS_DENIED:
				// 一度でも拒否された場合
				throw new AccessDeniedException(messages.getMessage("AbstractAccessDecisionManager.accessDenied", "参照が拒否されました。"));

			default:
				continue;
			}
		}

		// 最終結果が棄権の場合
		throw new AccessDeniedException(messages.getMessage("AbstractAccessDecisionManager.accessDenied", "参照が棄権されました。"));
	}
}
