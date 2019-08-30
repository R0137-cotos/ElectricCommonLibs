package jp.co.ricoh.cotos.electriccommonlib.security;

import jp.co.ricoh.cotos.commonlib.entity.master.UrlAuthMaster;

public class ElcUrlAuthMaster {

	/** 後続の投票クラス用URL権限マスタ */
	private static ThreadLocal<UrlAuthMaster> ElcUrlAuthMaster = new ThreadLocal<>();

	public static UrlAuthMaster get() {
		return ElcUrlAuthMaster.get();
	}

	public static void set(UrlAuthMaster urlAuthMaster) {
		ElcUrlAuthMaster.set(urlAuthMaster);
	}

	public static void clear() {
		set(null);
	}
}
