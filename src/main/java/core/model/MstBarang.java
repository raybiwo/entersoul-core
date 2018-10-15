package core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MST_BARANG database table.
 * 
 */
@Entity
@Table(name="MST_BARANG")
@NamedQuery(name="MstBarang.findAll", query="SELECT m FROM MstBarang m")
public class MstBarang implements Serializable {
	private static final long serialVersionUID = 1L;
	private String kodeBarang;
	private String kodeJenisBarang;
	private String kodeMerk;
	private String kodeSupplier;
	private String namaBarang;
	private BigDecimal stokBarang;

	public MstBarang() {
	}


	@Id
	@Column(name="KODE_BARANG")
	public String getKodeBarang() {
		return this.kodeBarang;
	}

	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}


	@Column(name="KODE_JENIS_BARANG")
	public String getKodeJenisBarang() {
		return this.kodeJenisBarang;
	}

	public void setKodeJenisBarang(String kodeJenisBarang) {
		this.kodeJenisBarang = kodeJenisBarang;
	}


	@Column(name="KODE_MERK")
	public String getKodeMerk() {
		return this.kodeMerk;
	}

	public void setKodeMerk(String kodeMerk) {
		this.kodeMerk = kodeMerk;
	}


	@Column(name="KODE_SUPPLIER")
	public String getKodeSupplier() {
		return this.kodeSupplier;
	}

	public void setKodeSupplier(String kodeSupplier) {
		this.kodeSupplier = kodeSupplier;
	}


	@Column(name="NAMA_BARANG")
	public String getNamaBarang() {
		return this.namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}


	@Column(name="STOK_BARANG")
	public BigDecimal getStokBarang() {
		return this.stokBarang;
	}

	public void setStokBarang(BigDecimal stokBarang) {
		this.stokBarang = stokBarang;
	}

}