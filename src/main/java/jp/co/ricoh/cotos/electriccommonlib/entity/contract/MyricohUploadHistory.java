package jp.co.ricoh.cotos.electriccommonlib.entity.contract;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "ID", required = true, position = 1, allowableValues = "range[0,9223372036854775807]")
	private long id;

	/**
	 * 請求実績ID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "請求実績ID", required = true, position = 2, allowableValues = "range[0,9223372036854775807]")
	private long billingHistoryId;

	/**
	 * MyRICOHユーザーID
	 */
	@Column(nullable = false)
	@ApiModelProperty(value = "MyRICOHユーザーID", required = true, position = 3, allowableValues = "range[0,255]")
	private String myricohId;
}
