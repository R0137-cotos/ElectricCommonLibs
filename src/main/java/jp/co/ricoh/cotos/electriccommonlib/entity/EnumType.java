package jp.co.ricoh.cotos.electriccommonlib.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 共通区分定義
 */
public class EnumType {

	public enum UnitPriceType {

		単価("1"), 仕切価格_営業("2"), 仕切価格_RJ("3");

		private final String text;

		private UnitPriceType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static UnitPriceType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum ElectricCommercialFlowDiv {

		直売("1"), 代売("2"), 社内("3");

		private final String text;

		private ElectricCommercialFlowDiv(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static ElectricCommercialFlowDiv fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum VoltageCategory {

		高圧("1"), 低圧("2");

		private final String text;

		private VoltageCategory(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static VoltageCategory fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum SendInvoiceDiv {

		// メール+MyRICOH
		メール_MyRICOH("1"), メール("2"), 紙請求("3");

		private final String text;

		private SendInvoiceDiv(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static SendInvoiceDiv fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum DealerFlowType {

		媒介("1"), 代理("2");

		private final String text;

		private DealerFlowType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static DealerFlowType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum PaymentMethod {

		定額("1"), 定率("2");

		private final String text;

		private PaymentMethod(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static PaymentMethod fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum Scale {

		規模_500kw未満("1"), 規模_500kw以上("2");

		private final String text;

		private Scale(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static Scale fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum ExternalFormType {

		電力供給に関する申込内容変更申出書_高圧("1"), 電力供給に関する申込内容変更申出書_低圧("2"), 電気需給契約名義変更申込書_低圧("3");

		private final String text;

		private ExternalFormType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static ExternalFormType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum BeforeDebitContact {

		未送信("0"), 送信済("1"), 送信対象外("9");

		private final String text;

		private BeforeDebitContact(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static BeforeDebitContact fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum SendMyRicoh {

		未送信("0"), 送信済("1"), 送信対象外("9");

		private final String text;

		private SendMyRicoh(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static SendMyRicoh fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	public enum ElectricArea {

		北日本("1"), 首都圏("2"), 中部("3"), 関西("4"), 西日本("5");

		private final String text;

		private ElectricArea(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static ElectricArea fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}
	public enum BildInfo {
		
		北海道("01"), 青森県("02"), 岩手県("03"), 宮城県("04"), 秋田県("05"), 山形県("06"), 福島県("07"), 茨城県("08"), 栃木県("09"), 群馬県("10"), 埼玉県("11"), 千葉県("12"), 東京都("13"), 神奈川県("14"), 新潟県("15"), 富山県("16"), 石川県("17"), 福井県("18"), 山梨県("19"), 長野県("20"), 岐阜県("21"), 静岡県("22"), 愛知県("23"), 三重県("24"), 滋賀県("25"), 京都府("26"), 大阪府("27"), 兵庫県("28"), 奈良県("29"), 和歌山県("30"), 鳥取県("31"), 島根県("32"), 岡山県("33"), 広島県("34"), 山口県("35"), 徳島県("36"), 香川県("37"), 愛媛県("38"), 高知県("39"), 福岡県("40"), 佐賀県("41"), 長崎県("42"), 熊本県("43"), 大分県("44"), 宮崎県("45"), 鹿児島県("46"), 沖縄県("47");
		
		private final String text;
		
		private BildInfo(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}
		
		@JsonCreator
		public static BildInfo fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}
}
