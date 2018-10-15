package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MST_MERK_BARANG database table.
 * 
 */
@Entity
@Table(name="MST_MERK_BARANG")
@NamedQuery(name="MstMerkBarang.findAll", query="SELECT m FROM MstMerkBarang m")
public class MstMerkBarang implements Serializable {
	private static final long serialVersionUID = 1L;
	private String kodeMerk;
	private String namaMerk;

	public MstMerkBarang() {
	}


	@Id
	@Column(name="KODE_MERK")
	public String getKodeMerk() {
		return this.kodeMerk;
	}

	public void setKodeMerk(String kodeMerk) {
		this.kodeMerk = kodeMerk;
	}


	@Column(name="NAMA_MERK")
	public String getNamaMerk() {
		return this.namaMerk;
	}

	public void setNamaMerk(String namaMerk) {
		this.namaMerk = namaMerk;
	}

}