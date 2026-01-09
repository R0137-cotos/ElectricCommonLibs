package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.CommissionMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 媒介手数料マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "commission_master")
@CotosComplementTarget(entity = CommissionMaster.class, repository = CommissionMasterRepository.class)
public class CommissionMaster extends EntityBaseMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commission_master_seq")
	@SequenceGenerator(name = "commission_master_seq", sequenceName = "commission_master_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 電力区分
	 */
	@Column(nullable = false)
	@Schema(description = "電力区分", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("電力区分")
	private String dnrykKbn;

	/**
	 * 管轄地域電力会社コード
	 */
	@Column(nullable = false)
	@Schema(description = "管轄地域電力会社コード", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("管轄地域電力会社コード")
	private String knkttikDnrykkishCd;

	/**
	 * 想定年間電力料金(From)
	 */
	@Column(nullable = false)
	@Schema(description = "想定年間電力料金(From)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,99999999999]")
	@JsonProperty("想定年間電力料金(From)")
	private Long sutiNnknDnrykRyuknFrom;

	/**
	 * 想定年間電力料金(To)
	 */
	@Column(nullable = false)
	@Schema(description = "想定年間電力料金(To)", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,99999999999]")
	@JsonProperty("想定年間電力料金(To)")
	private Long sutiNnknDnrykRyuknTo;

	/**
	 * 媒介手数料額
	 */
	@Column(nullable = true)
	@Schema(description = "媒介手数料額", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,99999999999]")
	@JsonProperty("媒介手数料額")
	private Long bikiTsuryuGk;

	/**
	 * 適用開始年月日
	 */
	@Column(nullable = true)
	@Schema(description = "適用開始年月日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("適用開始年月日")
	private String tkyuKishYmd;

	/**
	 * 適用終了年月日
	 */
	@Column(nullable = true)
	@Schema(description = "適用終了年月日", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	@JsonProperty("適用終了年月日")
	private String tkyuShuryuYmd;

}
