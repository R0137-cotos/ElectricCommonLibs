package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 契約(電力用)
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "contract_electric_id", referencedColumnName = "id")
	@Schema(description = "契約(電力用)", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private ContractElectric contractElectric;

	/**
	 * ファイル名
	 */
	@Column(nullable = true)
	@Schema(description = "ファイル名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@Column(nullable = true)
	@Schema(description = "ファイル種類", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String fileKind;

	/**
	 * 添付ファイルID
	 */
	@Schema(description = "添付ファイルID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private Long attachedFileId;

	/**
	 * コメント
	 */
	@Column(nullable = true)
	@Schema(description = "コメント", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,1000]")
	private String attachedComment;

	/**
	 * 添付者MoM社員ID
	 */
	@Column(nullable = true)
	@Schema(description = "添付者MoM社員ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String attachedEmpId;

	/**
	 * 添付者氏名
	 */
	@Column(nullable = true)
	@Schema(description = "添付者氏名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String attachedEmpName;

	/**
	 * 添付者組織名
	 */
	@Column(nullable = true)
	@Schema(description = "添付者組織名", requiredMode = Schema.RequiredMode.NOT_REQUIRED, allowableValues = "range[0,255]")
	private String attachedOrgName;

	/**
	 * 添付日時
	 */
	@Column(nullable = true)
	@Schema(description = "添付日時", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@Temporal(TemporalType.TIMESTAMP)
	private Date attachedAt;

	/**
	 * 電力用ファイル種別
	 */
	@Column(nullable = false)
	@Schema(description = "電力用ファイル種別", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "新規(\"1\"), 変更(\"2\"), 解約(\"3\"),その他(\"99\")", example = "1")
	private ElectricDispFileType electricFileType;

	/**
	 * 添付必須フラグ
	 */
	@Column(nullable = false)
	@Max(9)
	@Min(0)
	@Schema(description = "添付必須フラグ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int targetRequiredFlg;

	/**
	 * アクティブflg
	 */
	@Column(nullable = false)
	@Max(9)
	@Min(0)
	@Schema(description = "アクティブflg", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int activeFlg;

	/**
	 * 書類名称
	 */
	@Column(nullable = false)
	@Schema(description = "書類名称", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String documentName;

	/**
	 * マスタープリセットフラグ
	 */
	@Column(nullable = false)
	@Max(9)
	@Min(0)
	@Schema(description = "マスタープリセットフラグ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9]")
	private int masterPresetFlg;

}
