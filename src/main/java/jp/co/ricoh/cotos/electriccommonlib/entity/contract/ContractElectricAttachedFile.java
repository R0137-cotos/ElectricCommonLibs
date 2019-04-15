package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.common.ElectricAttachedFile;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約(電力)添付ファイルを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "contract_electric_attached_file")
public class ContractElectricAttachedFile extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_electric_attached_file_seq")
	@SequenceGenerator(name = "contract_electric_attached_file_seq", sequenceName = "contract_electric_attached_file_seq", allocationSize = 1)
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@ApiModelProperty(value = "契約(電力用)", required = true, position = 2)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * ファイル名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "ファイル名", required = true, position = 3, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ファイル種類", required = false, position = 4, allowableValues = "range[0,255]")
	private String fileKind;

	/**
	 * 添付ファイル
	 */
	@OneToOne
	@JoinColumn(name = "electric_attached_file_id", referencedColumnName = "id")
	@ApiModelProperty(value = "添付ファイル", required = false, position = 5)
	@JsonIgnore
	private ElectricAttachedFile electricAttachedFile;

	/**
	 * コメント
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "コメント", required = false, position = 6, allowableValues = "range[0,1000]")
	private String attachedComment;

	/**
	 * 添付者MoM社員ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "添付者MoM社員ID", required = true, position = 7, allowableValues = "range[0,255]")
	private String attachedEmpId;

	/**
	 * 添付者氏名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "添付者氏名", required = true, position = 8, allowableValues = "range[0,255]")
	private String attachedEmpName;

	/**
	 * 添付者組織名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "添付者組織名", required = false, position = 9, allowableValues = "range[0,255]")
	private String attachedOrgName;

	/**
	 * 添付日時
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "添付日時", required = true, position = 10)
	@Temporal(TemporalType.TIMESTAMP)
	private Date attachedAt;

	/**
	 * ファイル情報
	 */
	@Transient
	@ApiModelProperty(hidden = true)
	private MultipartFile multipartFile;

	@PrePersist
	public void prePersist() {
		super.prePersist();
		this.attachedAt = super.getCreatedAt();
	}
}
