package core.dto;



public class KPIResultDto {
	private int idKPI;
	private String kodeKaryawan;
	private String kpiPeriode;
	private String kpiStatus;
	private String kpiDetails;


	public int getId() {
		return idKPI;
	}
	public void setId(int id) {
		this.idKPI = id;
	}
	public String getKodeKaryawan() {
		return kodeKaryawan;
	}
	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}
	public String getKpiPeriode() {
		return kpiPeriode;
	}
	public void setKpiPeriode(String kpiPeriode) {
		this.kpiPeriode = kpiPeriode;
	}
	public String getKpiStatus() {
		return kpiStatus;
	}
	public void setKpiStatus(String kpiStatus) {
		this.kpiStatus = kpiStatus;
	}
	public String getKpiDetails() {
		return kpiDetails;
	}
	public void setKpiDetails(String kpiDetails) {
		this.kpiDetails = kpiDetails;
	}
}