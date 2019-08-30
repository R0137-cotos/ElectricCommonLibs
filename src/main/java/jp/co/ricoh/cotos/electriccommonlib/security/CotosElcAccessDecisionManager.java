package jp.co.ricoh.cotos.electriccommonlib.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.core.Authentication;

import jp.co.ricoh.cotos.commonlib.exception.ErrorCheckException;
import jp.co.ricoh.cotos.commonlib.exception.ErrorInfo;
import jp.co.ricoh.cotos.commonlib.logic.check.CheckUtil;
import jp.co.ricoh.cotos.commonlib.logic.message.MessageUtil;

public class CotosElcAccessDecisionManager extends AbstractAccessDecisionManager {
	
	/** ロガー */
	private static final Log log = LogFactory.getLog(CotosElcAccessDecisionManager.class);
	
	@Autowired
	CheckUtil checkUtil;
	
	@Autowired
	MessageUtil messageUtil;

	public CotosElcAccessDecisionManager(List<AccessDecisionVoter<? extends Object>> decisionVoters) {
		super(decisionVoters);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException {

		for (AccessDecisionVoter voter : getDecisionVoters()) {
			int result = voter.vote(authentication, object, configAttributes);

			switch (result) {
			case AccessDecisionVoter.ACCESS_GRANTED:
				return;

			case AccessDecisionVoter.ACCESS_DENIED:
				// 一度でも拒否された場合
				throw new ErrorCheckException(checkUtil.addErrorInfo(new ArrayList<ErrorInfo>(), "AccessDeniedError"));

			default:
				continue;
			}
		}

		// 最終結果が棄権の場合
		log.info(messageUtil.createMessageInfo("AccessAbstainError"));
		throw new ErrorCheckException(checkUtil.addErrorInfo(new ArrayList<ErrorInfo>(), "AccessDeniedError"));
	}
}
