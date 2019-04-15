package jp.co.ricoh.cotos.electriccommonlib.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.electriccommonlib.entity.contract.ContractElectricAttachedFile;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 添付ファイル情報を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_attached_file")
public class ElectricAttachedFile extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_attached_file_seq")
	@SequenceGenerator(name = "electric_attached_file_seq", sequenceName = "electric_attached_file_seq", allocationSize = 1)
	@ApiModelProperty(value = "添付ファイルID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 物理ファイル名
	 */
	@Column(nullable = false)
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "物理ファイル名", required = true, position = 2, allowableValues = "range[0,255]")
	private String filePhysicsName;

	/**
	 * ファイルサイズ
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "ファイルサイズ", required = true, position = 3, allowableValues = "range[0,9223372036854775807]")
	private long fileSize;

	/**
	 * コンテンツタイプ
	 */
	@Column(nullable = false)
	@NotNull
	@Size(max = 255)
	@ApiModelProperty(value = "コンテンツタイプ", required = true, position = 4, allowableValues = "range[0,255]")
	private String contentType;

	/**
	 * サーバーパス
	 */
	@Column(nullable = false)
	@NotNull
	@Size(max = 1000)
	@ApiModelProperty(value = "サーバーパス", required = true, position = 5, allowableValues = "range[0,1000]")
	private String savedPath;
	
	/**
	 * 添付ファイル(電力用)
	 */
	@OneToOne(mappedBy = "electricAttachedFile")
	@ApiModelProperty(value = "添付ファイル(電力用)", required = true, position = 6)
	private ContractElectricAttachedFile contractElectricAttachedFile;
}
