package jp.co.ricoh.cotos.electriccommonlib.dto.result.estimation;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "見積ID", requiredMode = Schema.RequiredMode.REQUIRED)
	private long id;

	/**
	 * 見積番号
	 */
	@Schema(description = "見積番号", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,18]")
	private String estimationNumber;

	/**
	 * 見積件名
	 */
	@Schema(description = "見積件名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String estimationTitle;

	/**
	 * 電力メニュー
	 */
	@Schema(description = "電力メニュー", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String electricMenu;

	/**
	 * 企業名
	 */
	@Schema(description = "企業名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String customerName;

	/**
	 * 事業所名
	 */
	@Schema(description = "事業所名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String officeName;

	/**
	 * 部門名
	 */
	@Schema(description = "部門名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String departmentName;

	/**
	 * 担当支社名
	 */
	@Schema(description = "担当支社名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String picAffiliateName;

	/**
	 * 担当営業
	 */
	@Schema(description = "担当営業", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,8]")
	private String picEmptxName;

	/**
	 * 見積種別
	 */
	@Schema(description = "見積種別", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "新規(\"1\"), 契約変更(\"2\")")
	private EstimationType estimationType;

	/**
	 * 見積ステータス
	 */
	@Schema(description = "見積ステータス", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "作成中(\"1\"), 業務依頼中(\"2\"), 業務処理完了(\"3\"), 承認依頼中(\"4\"), 承認済(\"5\"), 顧客提示済(\"6\")")
	private WorkflowStatus workflowStatus;

	/**
	 * 見積状態
	 */
	@Schema(description = "見積状態", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "作成中(\"1\"), 作成完了(\"2\"), 受注(\"3\"), 失注(\"4\"), 破棄(\"5\")")
	private LifecycleStatus lifecycleStatus;

	/**
	 * 案件番号
	 */
	@Schema(description = "案件番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String caseNumber;

	/**
	 * 掲示日
	 */
	@Schema(description = "掲示日", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "Asia/Tokyo")
	private Date coverPresentationDate;

	/**
	 * SIM番号
	 */
	@Schema(description = "SIM番号", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String simNumber;

	/**
	 * 基本料金_売価
	 */
	@Schema(description = "基本料金_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal basicRateSellingPrice;

	/**
	 * 従量料金_夏季_売価
	 */
	@Schema(description = "従量料金_夏季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeSummerSellingPrice;

	/**
	 * 従量料金_その他季_売価
	 */
	@Schema(description = "従量料金_その他季_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal usageFeeOtherSeasonSellingPrice;

	/**
	 * オプション_予備線_売価
	 */
	@Schema(description = "オプション_予備線_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal spareLineSellingPrice;

	/**
	 * オプション_予備電源_売価
	 */
	@Schema(description = "オプション_予備電源_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal sparePowerSellingPrice;

	/**
	 * オプション_アンシラリー_売価
	 */
	@Schema(description = "オプション_アンシラリー_売価", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0.00,9999999999999999999.99]")
	private BigDecimal ancillarySellingPrice;

	@PrePersist
	public void prePersist() {
		throw new IllegalAccessError();
	}
}