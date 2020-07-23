package jp.co.ricoh.cotos.electriccommonlib.security;

import java.util.Map;

import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.ActionDiv;
import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster.AuthDiv;
import jp.co.ricoh.cotos.commonlib.security.CotosAuthenticationDetails;
import jp.co.ricoh.cotos.commonlib.security.mom.MomAuthorityService.AuthLevel;

/**
 * 電力用のCOTOS認証情報を保持するDTOクラス
 */
public class CotosElcAuthenticationDetails extends CotosAuthenticationDetails {

	private static final long serialVersionUID = 1L;

	public CotosElcAuthenticationDetails(String momEmployeeId, String singleUserId, String origin, String applicationId, String jwt, boolean isSuperUser, boolean isDummyUser, Map<ActionDiv, Map<AuthDiv, AuthLevel>> momAuthorities) {
		super(momEmployeeId, singleUserId, origin, applicationId, jwt, isSuperUser, isDummyUser, momAuthorities);
	}
}