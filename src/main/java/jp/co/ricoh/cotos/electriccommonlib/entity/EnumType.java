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

}
