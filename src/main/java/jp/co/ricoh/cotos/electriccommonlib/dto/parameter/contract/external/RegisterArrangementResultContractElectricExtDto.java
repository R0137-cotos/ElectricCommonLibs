package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "RAIDEN外部キー情報", required = true, position = 1, allowableValues = "range[0,255]")
	private String oppSysKeyBn;

	/**
	 * NISHIKI契約番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "NISHIKI契約番号", required = false, position = 2, allowableValues = "range[0,255]")
	private String nishikiContractNumber;

	/**
	 * RAIDEN外部キー情報
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "需要家番号", required = false, position = 3, allowableValues = "range[0,255]")
	private String cstmrBn;

	/**
	 * ご契約者名（法人名）
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名（法人名）", required = true, position = 4, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * ご契約者名（カナ）
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "ご契約者名（カナ）", required = true, position = 6, allowableValues = "range[0,255]")
	private String customerNameKana;

	/**
	 * 使用場所 郵便番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　郵便番号", required = true, position = 7, allowableValues = "range[0,255]")
	private String zipCode;

	/**
	 * 使用場所 都道府県
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　都道府県", required = true, position = 8, allowableValues = "range[0,255]")
	private String bildInfo;

	/**
	 * 使用場所 市区町村
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　市区町村", required = true, position = 9, allowableValues = "range[0,255]")
	private String city;

	/**
	 * 使用場所 番地
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　番地", required = true, position = 10, allowableValues = "range[0,255]")
	private String address;

	/**
	 * 使用場所 建物名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　建物名", required = true, position = 11, allowableValues = "range[0,255]")
	private String buildingName;

	/**
	 * 使用場所 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "使用場所　電話番号", required = true, position = 12, allowableValues = "range[0,255]")
	private String phoneNumber;

	/**
	 * 申込日
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "申込日", required = true, position = 16, allowableValues = "range[0,255]")
	private String entryDate;

	/**
	 * 需給（供給）開始日
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "需給（供給）開始日", required = true, position = 42, allowableValues = "range[0,255]")
	private String supplyStartScheduledDate;

	/**
	 * 契約容量(従量電灯)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約容量(従量電灯)", required = true, position = 30, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractCapacityUsage;

	/**
	 * 契約電流
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電流", required = true, position = 31, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricCurrent;

	/**
	 * 契約電力(動力)
	 */
	@DecimalMin("0.00")
	@Digits(integer = 8, fraction = 2)
	@ApiModelProperty(value = "契約電力(動力)", required = true, position = 32, allowableValues = "range[0.00,99999999.99]")
	private BigDecimal contractElectricPower;

	/**
	 * 電気主任技術者 - 氏名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 氏名", required = true, position = 38, allowableValues = "range[0,255]")
	private String licensedEngineerName;

	/**
	 * 電気主任技術者 - 電話番号
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 電話番号", required = true, position = 39, allowableValues = "range[0,255]")
	private String licensedEngineerTel;

	/**
	 * 電気主任技術者 - 所属名
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "電気主任技術者 - 所属名", required = true, position = 40, allowableValues = "range[0,255]")
	private String licensedEngineerDep;
}
