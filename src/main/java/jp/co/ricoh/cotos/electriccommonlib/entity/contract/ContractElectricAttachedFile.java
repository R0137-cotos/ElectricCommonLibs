package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ContractElectricAttachedFileRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 契約(電力)添付ファイルを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "contract_electric_attached_file")
@CotosComplementTarget(entity = ContractElectricAttachedFile.class, repository = ContractElectricAttachedFileRepository.class)
public class ContractElectricAttachedFile extends EntityBase {

	public enum ElectricDispFileType {

		新規("1"), 変更("2"), 解約("3"), その他("99");

		private final String text;

		private ElectricDispFileType(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static ElectricDispFileType fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

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
	@Column(nullable = true)
	@ApiModelProperty(value = "ファイル名", required = false, position = 3, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "ファイル種類", required = false, position = 4, allowableValues = "range[0,255]")
	private String fileKind;

	/**
	 * 添付ファイルID
	 */
	@ApiModelProperty(value = "添付ファイルID", required = false, position = 5, allowableValues = "range[0,9223372036854775807]")
	private Long attachedFileId;

	/**
	 * コメント
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "コメント", required = false, position = 6, allowableValues = "range[0,1000]")
	private String attachedComment;

	/**
	 * 添付者MoM社員ID
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "添付者MoM社員ID", required = false, position = 7, allowableValues = "range[0,255]")
	private String attachedEmpId;

	/**
	 * 添付者氏名
	 */
	@Column(nullable = true)
	@ApiModelProperty(value = "添付者氏名", required = false, position = 8, allowableValues = "range[0,255]")
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
	@Column(nullable = true)
	@ApiModelProperty(value = "添付日時", required = false, position = 10)
	@Temporal(TemporalType.TIMESTAMP)
	private Date attachedAt;

	/**
	 * 電力用ファイル種別
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "電力用ファイル種別", required = true, position = 11, allowableValues = "新規(\"1\"), 変更(\"2\"), 解約(\"3\"),その他(\"99\")", example = "1")
	private ElectricDispFileType electricFileType;

	/**
	 * 添付必須フラグ
	 */
	@Column(nullable = false)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "添付必須フラグ", required = true, position = 12, allowableValues = "range[0,9]")
	private int targetRequiredFlg;

	/**
	 * アクティブflg
	 */
	@Column(nullable = false)
	@Max(9)
	@Min(0)
	@ApiModelProperty(value = "アクティブflg", required = true, position = 13, allowableValues = "range[0,9]")
	private int activeFlg;

	/**
	 * 書類名称
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "書類名称", required = true, position = 14, allowableValues = "range[0,255]")
	private String documentName;
}
