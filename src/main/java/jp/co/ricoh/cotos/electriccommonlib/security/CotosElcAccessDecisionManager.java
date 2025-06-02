package jp.co.ricoh.cotos.electriccommonlib.security;

import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;

public class CotosElcAccessDecisionManager implements AuthorizationManager<RequestAuthorizationContext> {

	/** ロガー */
	private static final Log log = LogFactory.getLog(CotosElcAccessDecisionManager.class);

	protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

	List<AuthorizationManager<RequestAuthorizationContext>> decisionVoters;

	public CotosElcAccessDecisionManager(List<AuthorizationManager<RequestAuthorizationContext>> decisionVoters) {
		this.decisionVoters = decisionVoters;
	}

	@Override
	public AuthorizationDecision check(Supplier<Authentication> auth, RequestAuthorizationContext context) {
		for (AuthorizationManager<RequestAuthorizationContext> voter : decisionVoters) {
			AuthorizationResult decision = voter.authorize(auth, context);
			if (decision != null) {
				return new AuthorizationDecision(decision.isGranted());
			} else {
				continue;
			}
		}

		// 最終結果が棄権の場合
		// ToDO:#4025
		log.info("対応する投票クラスが存在しません。");
		throw new AccessDeniedException(this.messages.getMessage("AbstractAccessDecisionManager.accessDenied", "Access is denied"));
	}
}
