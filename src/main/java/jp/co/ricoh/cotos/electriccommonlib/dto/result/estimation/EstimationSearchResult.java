package jp.co.ricoh.cotos.electriccommonlib.dto.result.estimation;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation.EstimationType;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation.LifecycleStatus;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation.WorkflowStatus;
import lombok.Data;

/**
 * 見積（電力）をリスト取得するためのDtoです。<br/>
 * 一覧を取得するためには、こちらのクラスを使ってください。 <br/>
 * このクラスを使用してDBへの保存を行うことは出来ません。
 */
@Entity
@Data
public class EstimationSearchResult {

	@Id
	@ApiModelProperty(value = "見積ID", required = true, position = 1)
	private long id;

	/**
	 * 見積番号
	 */
	@ApiModelProperty(value = "見積番号", required = true, position = 2, allowableValues = "range[0,18]")
	private String estimationNumber;

	/**
	 * 見積番号枝番
	 */
	@ApiModelProperty(value = "見積番号枝番", required = true, position = 3, allowableValues = "range[0,9]")
	private String estimationBranchNumber;

	/**
	 * 見積件名
	 */
	@ApiModelProperty(value = "見積件名", required = false, position = 4, allowableValues = "range[0,255]")
	private String estimationTitle;

	/**
	 * 企業名
	 */
	@ApiModelProperty(value = "企業名", required = false, position = 5, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * 事業所名
	 */
	@ApiModelProperty(value = "事業所名", required = false, position = 6, allowableValues = "range[0,255]")
	private String officeName;

	/**
	 * 部門名
	 */
	@ApiModelProperty(value = "部門名", required = false, position = 7, allowableValues = "range[0,255]")
	private String departmentName;

	/**
	 * 担当支社名
	 */
	@ApiModelProperty(value = "担当支社名", required = false, position = 8, allowableValues = "range[0,255]")
	private String picAffiliateName;

	/**
	 * 担当営業
	 */
	@ApiModelProperty(value = "担当営業", required = false, position = 9, allowableValues = "range[0,8]")
	private String picEmptxName;

	/**
	 * 見積種別
	 */
	@ApiModelProperty(value = "見積種別", required = false, position = 10, allowableValues = "新規(\"1\"), 契約変更(\"2\")")
	private EstimationType estimationType;

	/**
	 * 見積ステータス
	 */
	@ApiModelProperty(value = "見積ステータス", required = false, position = 11, allowableValues = "作成中(\"1\"), 業務依頼中(\"2\"), 業務処理完了(\"3\"), 承認依頼中(\"4\"), 承認済(\"5\"), 顧客提示済(\"6\")")
	private WorkflowStatus status;

	/**
	 * 見積状態
	 */
	@ApiModelProperty(value = "見積状態", required = false, position = 12, allowableValues = "作成中(\"1\"), 作成完了(\"2\"), 受注(\"3\"), 失注(\"4\"), 破棄(\"5\")")
	private LifecycleStatus lifecycleStatus;

	/**
	 * 案件番号
	 */
	@ApiModelProperty(value = "案件番号", required = false, position = 13, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 掲示日
	 */
	@ApiModelProperty(value = "掲示日", required = false, position = 14)
	@Temporal(TemporalType.TIMESTAMP)
	private Date coverPresentationDate;

	/**
	 * SIM番号
	 */
	@ApiModelProperty(value = "SIM番号", required = false, position = 15, allowableValues = "range[0,255]")
	private String simNumber;

	/**
	 * 基本料金_売価
	 */
	@ApiModelProperty(value = "基本料金_売価", required = false, position = 16, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateSellingPrice;

	/**
	 * 従量料金_夏季_売価
	 */
	@ApiModelProperty(value = "従量料金_夏季_売価", required = false, position = 17, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金_その他季_売価
	 */
	@ApiModelProperty(value = "従量料金_その他季_売価", required = false, position = 18, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * オプション_予備線_売価
	 */
	@ApiModelProperty(value = "オプション_予備線_売価", required = false, position = 19, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLineSellingPrice;

	/**
	 * オプション_予備電源_売価
	 */
	@ApiModelProperty(value = "オプション_予備電源_売価", required = false, position = 20, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerSellingPrice;

	/**
	 * オプション_アンシラリー_売価
	 */
	@ApiModelProperty(value = "オプション_アンシラリー_売価", required = false, position = 21, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillarySellingPrice;

	@PrePersist
	public void prePersist() {
		throw new IllegalAccessError();
	}
}