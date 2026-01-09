package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class RegisterArrangementResultContractElectricExtDto {

	/**
	 * RAIDEN外部キー情報
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "RAIDEN外部キー情報", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * NISHIKI契約番号
	 */
	@Size(max = 255)
	@Schema(description = "NISHIKI契約番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * RAIDEN外部キー情報
	 */
	@Size(max = 255)
	@Schema(description = "需要家番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String cstmrBn;

	/**
	 * ご契約者名（法人名）
	 */
	@Size(max = 255)
	@Schema(description = "ご契約者名（法人名）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名（カナ）
	 */
	@Size(max = 255)
	@Schema(description = "ご契約者名（カナ）", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 使用場所 郵便番号
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　郵便番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 使用場所 都道府県
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　都道府県", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 使用場所 市区町村
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　市区町村", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 使用場所 番地
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　番地", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 使用場所 建物名
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　建物名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 使用場所 電話番号
	 */
	@Size(max = 255)
	@Schema(description = "使用場所　電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 申込日
	 */
	@Size(max = 255)
	@Schema(description = "申込日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String entryDate;

	/**
	 * 需給（供給）開始日
	 */
	@NotNull
	@Size(max = 255)
	@Schema(description = "需給（供給）開始日", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String supplyStartScheduledDate;

	/**
	 * 契約容量(従量電灯)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約容量(従量電灯)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約電流", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電力(動力)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@Schema(description = "契約電力(動力)", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 電気主任技術者 - 氏名
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者 - 氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 - 電話番号
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者 - 電話番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 - 所属名
	 */
	@Size(max = 255)
	@Schema(description = "電気主任技術者 - 所属名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String licensedEngineerDep;
}
