package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 請求実績ID
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "billing_history_id", referencedColumnName = "id")
	@ApiModelProperty(value = "請求実績ID", required = true, position = 2)
	@JsonIgnore
	private BillingHistory billingHistory;

	/**
	 * ファイル名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "ファイル名", required = true, position = 3, allowableValues = "range[0,255]")
	private String fileName;

	/**
	 * ファイル種類
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "ファイル種類", required = true, position = 4, allowableValues = "請求書(\"1\"), 日別電力量明細表PDF(\"2\"), 日別電力量明細表Excel(\"3\")", example = "1")
	private FileKind fileKind;

	/**
	 * 物理ファイル名
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "物理ファイル名", required = true, position = 5, allowableValues = "range[0,255]")
	private String filePhysicsName;

	/**
	 * ファイルサイズ
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "ファイルサイズ", required = true, position = 6, allowableValues = "range[0,9223372036854775807]")
	private long fileSize;

	/**
	 * コンテンツタイプ
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "コンテンツタイプ", required = true, position = 7, allowableValues = "range[0,255]")
	private String contentType;

	/**
	 * サーバーパス
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "サーバーパス", required = true, position = 8, allowableValues = "range[0,1000]")
	private String savedPath;
}
