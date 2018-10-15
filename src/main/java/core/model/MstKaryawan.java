package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MST_KARYAWAN database table.
 * 
 */
@Entity
@Table(name="MST_KARYAWAN")
@NamedQuery(name="MstKaryawan.findAll", query="SELECT m FROM MstKaryawan m")
public class MstKaryawan implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idKaryawan;
	private String alamatKaryawan;
	private String emailKaryawan;
	private String idJob;
	private String jenisKelamin;
	private String namaKaryawan;

	public MstKaryawan() {
	}


	@Id
	@Column(name="KODE_KARYAWAN")
	public String getIdKaryawan() {
		return this.idKaryawan;
	}

	public void setIdKaryawan(String idKaryawan) {
		this.idKaryawan = idKaryawan;
	}


	@Column(name="ALAMAT_KARYAWAN")
	public String getAlamatKaryawan() {
		return this.alamatKaryawan;
	}

	public void setAlamatKaryawan(String alamatKaryawan) {
		this.alamatKaryawan = alamatKaryawan;
	}


	@Column(name="EMAIL_KARYAWAN")
	public String getEmailKaryawan() {
		return this.emailKaryawan;
	}

	public void setEmailKaryawan(String emailKaryawan) {
		this.emailKaryawan = emailKaryawan;
	}


	@Column(name="ID_JOB")
	public String getIdJob() {
		return this.idJob;
	}

	public void setIdJob(String idJob) {
		this.idJob = idJob;
	}


	@Column(name="JENIS_KELAMIN")
	public String getJenisKelamin() {
		return this.jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}


	@Column(name="NAMA_KARYAWAN")
	public String getNamaKaryawan() {
		return this.namaKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}

}