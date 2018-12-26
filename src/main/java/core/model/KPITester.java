package core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="KPI_TESTER")
@NamedQuery(name="KPITester.findAll", query="SELECT m FROM KPITester m")
public class KPITester implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String kodeKaryawan;
	private String kpiPeriode;
	private String testExec;
	private String scenDesign;
	private String rejectDefect;
	private String rit;
	private String sharingSession;
	private String testQuality;
	private String agileInvolvement;
	private String total;
	
	
	public KPITester() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "ID")
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
	
	@Column(name = "TEST_EXECUTION")
	public String getTestExec() {
		return testExec;
	}
	public void setTestExec(String testExec) {
		this.testExec = testExec;
	}
	
	@Column(name = "SCENARIO_DESIGN")
	public String getScenDesign() {
		return scenDesign;
	}
	public void setScenDesign(String scenDesign) {
		this.scenDesign = scenDesign;
	}
	
	@Column(name = "REJECTED_DEFECT")
	public String getRejectDefect() {
		return rejectDefect;
	}
	public void setRejectDefect(String rejectDefect) {
		this.rejectDefect = rejectDefect;
	}
	
	@Column(name = "RIT")
	public String getRit() {
		return rit;
	}
	public void setRit(String rit) {
		this.rit = rit;
	}
	
	@Column(name = "SHARING_SESSION")
	public String getSharingSession() {
		return sharingSession;
	}
	public void setSharingSession(String sharingSession) {
		this.sharingSession = sharingSession;
	}
	
	@Column(name = "TEST_QUALITY")
	public String getTestQuality() {
		return testQuality;
	}
	public void setTestQuality(String testQuality) {
		this.testQuality = testQuality;
	}
	
	@Column(name = "AGILE_INVOLVEMENT")
	public String getAgileInvolvement() {
		return agileInvolvement;
	}
	public void setAgileInvolvement(String agileInvolvement) {
		this.agileInvolvement = agileInvolvement;
	}
	
	@Column(name = "TOTAL")
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
	
}
