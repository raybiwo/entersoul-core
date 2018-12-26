package core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="KPI_RESULT")
@NamedQuery(name="KPIResult.findAll", query="SELECT m FROM KPIResult m")
public class KPIResult implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String kodeKaryawan;
	private String kpiPeriode;
	private String kpiStatus;
	private String kpiDetails;
	
	public KPIResult() {
		super();
	}
	
	@Id
	@Column(name = "ID_KPI")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "KODE_KARYAWAN")
	public String getKodeKaryawan() {
		return kodeKaryawan;
	}
	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}
	
	@Column(name = "KPI_PERIODE")
	public String getKpiPeriode() {
		return kpiPeriode;
	}
	public void setKpiPeriode(String kpiPeriode) {
		this.kpiPeriode = kpiPeriode;
	}
	
	@Column(name = "KPI_STATUS")
	public String getKpiStatus() {
		return kpiStatus;
	}
	public void setKpiStatus(String kpiStatus) {
		this.kpiStatus = kpiStatus;
	}
	
	@Column(name = "KPI_DETAILS")
	public String getKpiDetails() {
		return kpiDetails;
	}
	public void setKpiDetails(String kpiDetails) {
		this.kpiDetails = kpiDetails;
	}
	
}
