package jp.co.ricoh.cotos.electriccommonlib.dto.parameter.contract.external;

import java.util.Date;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class ContractElectricExtInputDto {
	
	/**
	 * 案件番号
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "案件番号", required = true, position = 1, allowableValues = "range[0,255]")
	private String caseNumber;
	
	/**
	 * 案件名
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "案件番号", required = true, position = 2, allowableValues = "range[0,255]")
	private String caseTitle;
	
	/**
	 * 得意先コード(契約(電力))
	 */
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "得意先コード", required = true, position = 3, allowableValues = "range[0,255]")
	private String clientCode;
	
	/**
	 * 変更希望日
	 */
	@ApiModelProperty(value = "変更希望日", required = false, position = 4)
	private Date changePreferredDate;
	
	/**
	 * 変更元契約ID(プラン変更で使用)
	 */
	@Min(0)
	@ApiModelProperty(value = "変更元契約ID", required = false, position = 5, allowableValues = "range[0,9223372036854775807]")
	private long originContractId;
	
	/**
	 * 契約(電力)
	 */
	@Valid
	@NotNull
	@OneToOne(mappedBy = "contractElectricExtCreate", optional = false)
	@ApiModelProperty(value = "契約(電力)", required = true, position = 6)
	private ContractElectricExtDto contractElectricExtDto;
	
	/**
	 * 顧客
	 */
	@Valid
	@NotNull
	@OneToOne(mappedBy = "contractElectricExtCreate", optional = false)
	@ApiModelProperty(value = "顧客", required = true, position = 7)
	private CustomerContractExtDto customerContractExtDto;
	
	/**
	 * 契約担当者メールアドレス
	 */
	@Valid
	@NotNull
	@OneToMany(mappedBy = "contractElectricExtCreate")
	@ApiModelProperty(value = "契約担当者メールアドレス", required = true, position = 8)
	private List<MailAddressInformationExtDto> mailAddressInformationExtDtoList;
	
	/**
	 * 請求先メールアドレスリスト
	 */
	@Valid
	@NotNull
	@OneToMany(mappedBy = "contractElectricExtCreate")
	@ApiModelProperty(value = "請求先メールアドレスリスト", required = true, position = 9)
	private List<BillingMailAddressInformationExtDto> billingMailAddressInformationExtDto;
	
	/**
	 * 契約担当SA社員
	 */
	@Valid
	@NotNull
	@OneToOne(mappedBy = "contractElectricExtCreate", optional = false)
	@ApiModelProperty(value = "契約担当SA社員", required = true, position = 10)
	private ContractPicSaEmpExtDto contractPicSaEmpExtDto;
	
	/**
	 * 電力専任情報
	 */
	@Valid
	@NotNull
	@OneToOne(mappedBy = "contractElectricExtCreate", optional = false)
	@ApiModelProperty(value = "電力専任情報", required = true, position = 11)
	private ElectricExpertContractExtDto electricExpertContractExtDto;
	
	/**
	 * 追加編集者
	 */
	@Valid
	@NotNull
	@OneToOne(mappedBy = "contractElectricExtCreate", optional = false)
	@ApiModelProperty(value = "追加編集者", required = true, position = 12)
	private List<ContractAddedEditorEmpExtDto> contractAddedEditorEmpExtDtoList;
	
	/**
	 * 重要項目説明者
	 */
	@Valid
	@NotNull
	@OneToOne(mappedBy = "contractElectricExtCreate", optional = false)
	@ApiModelProperty(value = "重要項目説明者", required = true, position = 13)
	private ImportantPointExplainerExtDto importantPointExplainerExtDto;
	
	/**
	 * 販売店情報
	 */
	@Valid
	@NotNull
	@OneToOne(mappedBy = "contractElectricExtCreate", optional = false)
	@ApiModelProperty(value = "販売店情報", required = true, position = 14)
	private ElectricDealerContractExtDto electricDealerContractExtDto;
	
	/**
	 * 料金シュミレーション
	 */
//	@Valid
//	@NotNull
//	@OneToOne(mappedBy = "contractElectricExtCreate", optional = false)
//	@ApiModelProperty(value = "料金シュミレーション", required = true, position = 15)
//	private FeeSimulationHeadExtDto feeSimulationHeadExtDto;

}
