package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MST_JOB database table.
 * 
 */
@Entity
@Table(name="MST_JOB")
@NamedQuery(name="MstJob.findAll", query="SELECT m FROM MstJob m")
public class MstJob implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idJob;
	private String jobKaryawan;

	public MstJob() {
	}


	@Id
	@Column(name="ID_JOB")
	public String getIdJob() {
		return this.idJob;
	}

	public void setIdJob(String idJob) {
		this.idJob = idJob;
	}


	@Column(name="JOB_KARYAWAN")
	public String getJobKaryawan() {
		return this.jobKaryawan;
	}

	public void setJobKaryawan(String jobKaryawan) {
		this.jobKaryawan = jobKaryawan;
	}

}