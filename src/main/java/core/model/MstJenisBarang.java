package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MST_JENIS_BARANG database table.
 * 
 */
@Entity
@Table(name="MST_JENIS_BARANG")
@NamedQuery(name="MstJenisBarang.findAll", query="SELECT m FROM MstJenisBarang m")
public class MstJenisBarang implements Serializable {
	private static final long serialVersionUID = 1L;
	private String kodeJenisBarang;
	private String namaJenisBarang;

	public MstJenisBarang() {
	}


	@Id
	@Column(name="KODE_JENIS_BARANG")
	public String getKodeJenisBarang() {
		return this.kodeJenisBarang;
	}

	public void setKodeJenisBarang(String kodeJenisBarang) {
		this.kodeJenisBarang = kodeJenisBarang;
	}


	@Column(name="NAMA_JENIS_BARANG")
	public String getNamaJenisBarang() {
		return this.namaJenisBarang;
	}

	public void setNamaJenisBarang(String namaJenisBarang) {
		this.namaJenisBarang = namaJenisBarang;
	}

}