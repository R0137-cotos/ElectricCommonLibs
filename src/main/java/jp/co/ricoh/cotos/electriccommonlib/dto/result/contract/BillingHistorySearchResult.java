package jp.co.ricoh.cotos.electriccommonlib.dto.result.contract;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 契約（電力）に紐づく請求実績をリスト取得するためのDtoです。<br/>
 * このクラスを使用してDBへの保存を行うことは出来ません。
 */
@Data
public class BillingHistorySearchResult {

	/**
	 * No.
	 */
	@ApiModelProperty(value = "No.", required = false, position = 1)
	private long no;

	/**
	 * 請求No.
	 */
	@ApiModelProperty(value = "請求No.", required = false, position = 2)
	private String claimNumber;

	/**
	 * 請求年月
	 */
	@ApiModelProperty(value = "請求年月", required = false, position = 3)
	private String billingYearMonth;

	/**
	 * 売上年月日
	 */
	@ApiModelProperty(value = "売上年月日", required = false, position = 4)
	private String salesDate;

	/**
	 * 請求先 上流顧客コード
	 */
	@ApiModelProperty(value = "請求先 上流顧客コード", required = false, position = 5)
	private String clientCode;

	/**
	 * 請求金額(税抜)
	 */
	@ApiModelProperty(value = "請求金額(税抜)", required = false, position = 6)
	private BigDecimal claimAmountOutTax;

	/**
	 * 消費税額
	 */
	@ApiModelProperty(value = "消費税額", required = false, position = 7)
	private BigDecimal claimTax;

	/**
	 * 請求金額(税込)
	 */
	@ApiModelProperty(value = "請求金額(税込)", required = false, position = 8)
	private BigDecimal claimAmountInTax;

	/**
	 * 請求書PDF
	 */
	@ApiModelProperty(value = "請求書PDF", required = false, position = 9)
	private Long fileBillId;

	/**
	 * 請求書PDF
	 */
	@ApiModelProperty(value = "請求書PDF", required = false, position = 10)
	private String fileBillPhysicsName;

	/**
	 * 日別電力量 明細表PDF
	 */
	@ApiModelProperty(value = "日別電力量 明細表PDF", required = false, position = 11)
	private Long filePdfId;

	/**
	 * 日別電力量 明細表PDF
	 */
	@ApiModelProperty(value = "日別電力量 明細表PDF", required = false, position = 12)
	private String filePdfPhysicsName;

	/**
	 * 日別電力量 明細表Excel
	 */
	@ApiModelProperty(value = "日別電力量 明細表Excel", required = false, position = 13)
	private Long fileExcelId;

	/**
	 * 日別電力量 明細表Excel
	 */
	@ApiModelProperty(value = "日別電力量 明細表Excel", required = false, position = 14)
	private String fileExcelPhysicsName;

	/**
	 * 未回収フラグ
	 */
	@ApiModelProperty(value = "未回収フラグ", required = false, position = 15)
	private Integer accruedFlg;

	/**
	 * 未回収分回収日
	 */
	@ApiModelProperty(value = "未回収分回収日", required = false, position = 16)
	private Date accruedCollectionDate;
}
