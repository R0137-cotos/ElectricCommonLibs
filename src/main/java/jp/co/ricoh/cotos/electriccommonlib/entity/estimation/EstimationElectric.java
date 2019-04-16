package jp.co.ricoh.cotos.electriccommonlib.entity.estimation;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import jp.co.ricoh.cotos.commonlib.entity.EntityBase;
import jp.co.ricoh.cotos.commonlib.entity.estimation.Estimation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 見積(電力用)
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "estimation_electric")
public class EstimationElectric extends EntityBase {

/**
 * ID
 */
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estimation_electric_seq")
@SequenceGenerator(name = "estimation_electric_seq", sequenceName = "estimation_electric_seq", allocationSize = 1)
@ApiModelProperty(value = "ID", required = true, position = 1)
private long id;

/**
 * 見積ID
 */
@OneToOne(optional = false)
@JoinColumn(name = "estimationId", referencedColumnName = "id")
@JsonIgnore
private Estimation estimation;

/**
 * 電力エリア
 */
@Column(nullable = false)
@ApiModelProperty(value = "電力エリア", required = false, position = 2, allowableValues = "range[0,255]")
private String electricArea;

/**
 * 電力会社
 */
@Column(nullable = false)
@ApiModelProperty(value = "電力会社", required = false, position = 3, allowableValues = "range[0,255]")
private String electricCompany;

/**
 * 電力区分
 */
@Column(nullable = false)
@ApiModelProperty(value = "電力区分", required = true, position = 4, allowableValues = "range[0,255]")
private String voltageCategory;

/**
 * 電力メニュー
 */
@Column(nullable = false)
@ApiModelProperty(value = "電力メニュー", required = false, position = 5, allowableValues = "range[0,255]")
private String electricMenu;

/**
 * 契約電力
 */
@Column(nullable = false)
@ApiModelProperty(value = "契約電力", required = false, position = 6, allowableValues = "range[0,255]")
private String contractPower;

/**
 * 規模
 */
@Column(nullable = false)
@ApiModelProperty(value = "規模", required = false, position = 7, allowableValues = "range[0,255]")
private String scale;

/**
 * 力率
 */
@Column(nullable = false)
@ApiModelProperty(value = "力率", required = false, position = 8, allowableValues = "range[0,255]")
private String powerRate;

/**
 * 負荷率
 */
@Column(nullable = false)
@ApiModelProperty(value = "負荷率", required = false, position = 9, allowableValues = "range[0,255]")
private String loadFactor;

/**
 * 供給開始予定日
 */
@Column(nullable = false)
@ApiModelProperty(value = "供給開始予定日", required = false, position = 10)
private Date supplyStartScheduledDate;

/**
 * 備考
 */
@Column(nullable = false)
@ApiModelProperty(value = "備考", required = false, position = 11, allowableValues = "range[0,255]")
private String notes;

@OneToMany(mappedBy = "estimationElectric")
@ApiModelProperty(value = "テスト", required = false, position = 12)
private List<ElectricExpertEstimation> electricExpertEstimationList;

@OneToMany(mappedBy = "estimationElectric")
@ApiModelProperty(value = "テスト", required = false, position = 13)
private List<ElectricDealerEstimation> electricDealerEstimationList;

@OneToMany(mappedBy = "estimationElectric")
@ApiModelProperty(value = "テスト", required = false, position = 14)
private List<FeeSimulationSales> feeSimulationSalesList;

@OneToMany(mappedBy = "estimationElectric")
@ApiModelProperty(value = "テスト", required = false, position = 15)
private List<FeeSimulationHead> feeSimulationHeadList;

}


