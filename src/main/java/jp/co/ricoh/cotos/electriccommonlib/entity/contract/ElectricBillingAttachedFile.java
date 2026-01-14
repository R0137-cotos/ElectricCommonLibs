package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.ElectricBillingAttachedFileRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 電力請求添付ファイルを表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "electric_billing_attached_file")
@CotosComplementTarget(entity = ElectricBillingAttachedFile.class, repository = ElectricBillingAttachedFileRepository.class)
public class ElectricBillingAttachedFile extends EntityBase {

	public enum FileKind {

		請求書("1"), 日別電力量明細表PDF("2"), 日別電力量明細表Excel("3");

		private final String text;

		private FileKind(final String text) {
			this.text = text;
		}

		@Override
		@JsonValue
		public String toString() {
			return this.text;
		}

		@JsonCreator
		public static FileKind fromString(String string) {
			return Arrays.stream(values()).filter(v -> v.text.equals(string)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.valueOf(string)));
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "electric_billing_attached_file_seq")
	@SequenceGenerator(name = "electric_billing_attached_file_seq", sequenceName = "electric_billing_attached_file_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 請求実績ID
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "billing_history_id", referencedColumnName = "id")
	@Schema(description = "請求実績ID", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonIgnore
	private BillingHistory billingHistory;

	/**
	 * ファイル名
	 */
	@Column(nullable = false)
	@Schema(description = "ファイル名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@Column(nullable = false)
	@Schema(description = "ファイル種類", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "請求書(\"1\"), 日別電力量明細表PDF(\"2\"), 日別電力量明細表Excel(\"3\")", example = "1")
	private FileKind fileKind;

	/**
	 * 物理ファイル名
	 */
	@Column(nullable = false)
	@Schema(description = "物理ファイル名", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String filePhysicsName;

	/**
	 * ファイルサイズ
	 */
	@Column(nullable = false)
	@Schema(description = "ファイルサイズ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long fileSize;

	/**
	 * コンテンツタイプ
	 */
	@Column(nullable = false)
	@Schema(description = "コンテンツタイプ", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String contentType;

	/**
	 * サーバーパス
	 */
	@Column(nullable = false)
	@Schema(description = "サーバーパス", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,1000]")
	private String savedPath;
}
