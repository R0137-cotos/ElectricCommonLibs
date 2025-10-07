package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.dto.parameter.common.DtoBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationReasonInformation;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.CancellationReasonInformation.DemandDisappearsType;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.CancellationReasonInformationRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@CotosComplementTarget(entity = CancellationReasonInformation.class, repository = CancellationReasonInformationRepository.class)
public class CancellationReasonInformationDto extends DtoBase {

	/**
	 * 需要消滅種別
	 */
	@ApiModelProperty(value = "需要消滅種別", required = false, position = 3, allowableValues = "移転(\"1\"), 売却(\"2\"), 閉鎖(\"3\"), 建替え(\"4\"), 使用停止(\"5\"), 低圧⇔高圧(\"6\")", example = "1")
	private DemandDisappearsType demandDisappearsType;

	/**
	 * 他社切替-リコージャパンより削減効果が大きい
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-リコージャパンより削減効果が大きい", required = false, position = 4, allowableValues = "range[0,9]")
	private Integer switchingReductionEffectFlg;

	/**
	 * 他社切替-切替先と取引関係がある
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-切替先と取引関係がある", required = false, position = 5, allowableValues = "range[0,9]")
	private Integer switchingBuisinessRelationFlg;

	/**
	 * 他社切替-リコージャパンの対応に不満
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-リコージャパンの対応に不満", required = false, position = 6, allowableValues = "range[0,9]")
	private Integer switchingComplainFlg;

	/**
	 * 他社切替-不満（営業）
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-不満（営業）", required = false, position = 7, allowableValues = "range[0,9]")
	private Integer switchingComplainBusinessFlg;

	/**
	 * 他社切替-不満（コールセンター）
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-不満（コールセンター）", required = false, position = 8, allowableValues = "range[0,9]")
	private Integer switchingComplainCcFlg;

	/**
	 * 他社切替-不満（本部）
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-不満（本部）", required = false, position = 9, allowableValues = "range[0,9]")
	private Integer switchingComplainHeadFlg;

	/**
	 * 他社切替-その他
	 */
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "他社切替-その他", required = false, position = 10, allowableValues = "range[0,9]")
	private Integer switchingOtherFlg;

	/**
	 * 他社切替-その他記述
	 */
	@Size(max = 255)
	@ApiModelProperty(value = "他社切替-その他記述", required = false, position = 11, allowableValues = "range[0,255]")
	private String switchingOtherNote;
}
