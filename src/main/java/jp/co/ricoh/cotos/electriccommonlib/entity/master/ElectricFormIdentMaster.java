package jp.co.ricoh.cotos.electriccommonlib.entity.master;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBaseMaster;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.master.ElectricFormIdentMasterRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力帳票識別マスタを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_form_ident_master")
@CotosComplementTarget(entity = ElectricFormIdentMaster.class, repository = ElectricFormIdentMasterRepository.class)
public class ElectricFormIdentMaster extends EntityBaseMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_form_ident_master_seq")
	@SequenceGenerator(name = "electric_form_ident_master_seq", sequenceName = "electric_form_ident_master_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 帳票コード
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "帳票コード", required = true, position = 2, allowableValues = "range[0,255]")
	private String formCode;

	/**
	 * 添付対象帳票名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "添付対象帳票名", required = true, position = 3, allowableValues = "range[0,255]")
	private String targetFormName;

	/**
	 * 帳票出力テンプレート
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "帳票出力テンプレート", required = true, position = 4, allowableValues = "range[0,255]")
	private String templeteFromName;
	
	/**
	 * 添付必須フラグ
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "添付必須フラグ", required = true, position = 5, allowableValues = "range[0,9]")
	private int targetRequiredFlg;

	/**
	 * 説明
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "説明", required = false, position = 6, allowableValues = "range[0,255]")
	private String description;

	@ManyToMany(mappedBy = "electricFormIdentMasterList")
	@ApiModelProperty(value = "電力帳票マスタ", required = true, position = 6)
	private List<ElectricFormMaster> electricFormMasterList;

}