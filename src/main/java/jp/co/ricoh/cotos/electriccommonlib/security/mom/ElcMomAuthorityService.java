package jp.co.ricoh.cotos.electriccommonlib.security.mom;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import jp.co.ricoh.cotos.commonlib.dto.parameter.common.AuthorityJudgeParameter;
import jp.co.ricoh.cotos.commonlib.entity.master.MvEmployeeMaster;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.AccessType;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.ActionDiv;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.AuthDiv;
import jp.co.ricoh.cotos.commonlib.logic.message.MessageUtil;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService;
import jp.co.ricoh.cotos.electriccommonlib.security.CotosElcAuthenticationDetails;

@Component
public class ElcMomAuthorityService extends MomAuthorityService {

	/** ロガー */
	private static final Log log = LogFactory.getLog(ElcMomAuthorityService.class);

	@Autowired
	MessageUtil messageUtil;

	/**
	 * 権限判定用パラメーターから対象のアクションを実施する権限があるか判定する
	 */
	@Override
	public boolean hasAuthority(AuthorityJudgeParameter authParam, ActionDiv actionDiv, AuthDiv authDiv, AccessType accessType) throws Exception {

		// 権限レベルを取得
		AuthLevel authLevel = ((CotosElcAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getMomAuthorities().get(actionDiv).get(authDiv);

		// 認可判定処理開始
		log.info(messageUtil.createMessageInfo("AuthorizeProcessJudgeStartInfo", Arrays.asList(accessType.name(), authLevel.name()).toArray(new String[0])).getMsg());

		// 参照・編集処理、承認処理により認可処理を分岐
		if (AccessType.参照.equals(accessType) || AccessType.編集.equals(accessType)) {

			if (AccessType.参照.equals(accessType)) {
				// 承認者に含まれる場合、参照権限を付与
				if (!ObjectUtils.isEmpty(authParam.getApproverMvEmployeeMasterList()) && authParam.getApproverMvEmployeeMasterList().stream().filter(approver -> approver.getMomEmployeeId().equals(authParam.getActorMvEmployeeMaster().getMomEmployeeId())).count() > 0) {
					return true;
				}
			}

			if (AccessType.編集.equals(accessType)) {
				// 次回承認者または次回代理承認者の場合、編集権限を付与
				if (!ObjectUtils.isEmpty(authParam.getNextApproverMvEmployeeMaster()) && authParam.getNextApproverMvEmployeeMaster().getMomEmployeeId().equals(authParam.getActorMvEmployeeMaster().getMomEmployeeId())) {
					return true;
				} else if (!ObjectUtils.isEmpty(authParam.getNextSubApproverMvEmployeeMaster()) && authParam.getNextSubApproverMvEmployeeMaster().getMomEmployeeId().equals(authParam.getActorMvEmployeeMaster().getMomEmployeeId())) {
					return true;
				}

				// 前回承認者または前回代理承認者の場合、編集権限を付与
				if (!ObjectUtils.isEmpty(authParam.getPrevApproverMvEmployeeMaster()) && authParam.getPrevApproverMvEmployeeMaster().getMomEmployeeId().equals(authParam.getActorMvEmployeeMaster().getMomEmployeeId())) {
					return true;
				} else if (!ObjectUtils.isEmpty(authParam.getPrevSubApproverMvEmployeeMaster()) && authParam.getPrevSubApproverMvEmployeeMaster().getMomEmployeeId().equals(authParam.getActorMvEmployeeMaster().getMomEmployeeId())) {
					return true;
				}
			}

			// 参照・編集処理用の認可処理を実施
			return this.hasEditAuthority(authLevel, authParam.getActorMvEmployeeMaster(), authParam.getMvEmployeeMasterList());
		} else if (AccessType.承認.equals(accessType)) {

			// 直接指定された承認者であれば、権限あり
			if (authParam.isManualApprover()) {
				return true;
			}

			// 代理承認者であれば、権限あり
			if (!ObjectUtils.isEmpty(authParam.getNextSubApproverMvEmployeeMaster()) && authParam.getActorMvEmployeeMaster().getMomEmployeeId().equals(authParam.getNextSubApproverMvEmployeeMaster().getMomEmployeeId())) {
				return true;
			}

			// 承認処理用の認可処理を実施
			return this.hasApproveAuthority(authLevel, authParam.getActorMvEmployeeMaster(), authParam.getRequesterMvEmployeeMaster());
		} else {
			return false;
		}
	}

	/**
	 * 参照・編集権限が存在するか判定する
	 */
	private boolean hasEditAuthority(AuthLevel authLevel, MvEmployeeMaster editor, List<MvEmployeeMaster> targetEmployeeMasterList) {

		// 権限レベルによる認可処理を実施
		switch (authLevel) {
		case 不可:
			return false;
		case 自顧客:
			// 担当SA、追加編集者、担当CE、担当SEであるかを確認
			return targetEmployeeMasterList.stream().anyMatch(targetEmployeeMaster -> editor.getMomEmployeeId().equals(targetEmployeeMaster.getMomEmployeeId()));
		case 配下:
			// 担当SA、追加編集者、担当CE、担当SEの所属組織が配下であるか確認
			return targetEmployeeMasterList.stream().anyMatch(targetEmployeeMaster -> this.isLowerOrg(targetEmployeeMaster.getMomOrgId(), editor.getMomOrgId()));
		case 自社:
		case 地域:
		case 東西:
		case すべて:
			return true;
		default:
			return false;
		}
	}
}