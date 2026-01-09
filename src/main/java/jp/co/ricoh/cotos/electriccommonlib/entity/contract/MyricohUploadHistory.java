package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.security.complement.CotosComplementTarget;
import jp.co.ricoh.cotos.electriccommonlib.repository.contract.MyricohUploadHistoryRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * MyRICOH連携実績を表すEntity
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "myricoh_upload_history")
@CotosComplementTarget(entity = MyricohUploadHistory.class, repository = MyricohUploadHistoryRepository.class)
public class MyricohUploadHistory extends EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myricoh_upload_history_seq")
	@SequenceGenerator(name = "myricoh_upload_history_seq", sequenceName = "myricoh_upload_history_seq", allocationSize = 1)
	@Schema(description = "ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 請求実績ID
	 */
	@Column(nullable = false)
	@Schema(description = "請求実績ID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,9223372036854775807]")
	private long billingHistoryId;

	/**
	 * MyRICOHユーザーID
	 */
	@Column(nullable = false)
	@Schema(description = "MyRICOHユーザーID", requiredMode = Schema.RequiredMode.REQUIRED, allowableValues = "range[0,255]")
	private String myricohId;
}
