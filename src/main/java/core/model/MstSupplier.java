package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MST_SUPPLIER database table.
 * 
 */
@Entity
@Table(name="MST_SUPPLIER")
@NamedQuery(name="MstSupplier.findAll", query="SELECT m FROM MstSupplier m")
public class MstSupplier implements Serializable {
	private static final long serialVersionUID = 1L;
	private String kodeSupplier;
	private String alamatSupplier;
	private String namaSupplier;
	private String notlpSuppler;

	public MstSupplier() {
	}


	@Id
	@Column(name="KODE_SUPPLIER")
	public String getKodeSupplier() {
		return this.kodeSupplier;
	}

	public void setKodeSupplier(String kodeSupplier) {
		this.kodeSupplier = kodeSupplier;
	}


	@Column(name="ALAMAT_SUPPLIER")
	public String getAlamatSupplier() {
		return this.alamatSupplier;
	}

	public void setAlamatSupplier(String alamatSupplier) {
		this.alamatSupplier = alamatSupplier;
	}


	@Column(name="NAMA_SUPPLIER")
	public String getNamaSupplier() {
		return this.namaSupplier;
	}

	public void setNamaSupplier(String namaSupplier) {
		this.namaSupplier = namaSupplier;
	}


	@Column(name="NOTLP_SUPPLER")
	public String getNotlpSuppler() {
		return this.notlpSuppler;
	}

	public void setNotlpSuppler(String notlpSuppler) {
		this.notlpSuppler = notlpSuppler;
	}

}