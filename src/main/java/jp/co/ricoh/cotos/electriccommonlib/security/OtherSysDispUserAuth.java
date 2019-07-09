package jp.co.ricoh.cotos.electriccommonlib.security;

public class OtherSysDispUserAuth {

	/** 外部システムの画面表示用ユーザー権限 */
	private static ThreadLocal<String> otherSysDispUserAuthThreadLocal = new ThreadLocal<>();

	public static String get() {
		return otherSysDispUserAuthThreadLocal.get();
	}

	public static void set(String otherSysDispUserAuth) {
		otherSysDispUserAuthThreadLocal.set(otherSysDispUserAuth);
	}

	public static void clear() {
		set(null);
	}
}
