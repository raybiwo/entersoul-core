package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MST_TOKO database table.
 * 
 */
@Entity
@Table(name="MST_TOKO")
@NamedQuery(name="MstToko.findAll", query="SELECT m FROM MstToko m")
public class MstToko implements Serializable {
	private static final long serialVersionUID = 1L;
	private String kodeToko;
	private String alamatToko;
	private String namaToko;

	public MstToko() {
	}


	@Id
	@Column(name="KODE_TOKO")
	public String getKodeToko() {
		return this.kodeToko;
	}

	public void setKodeToko(String kodeToko) {
		this.kodeToko = kodeToko;
	}


	@Column(name="ALAMAT_TOKO")
	public String getAlamatToko() {
		return this.alamatToko;
	}

	public void setAlamatToko(String alamatToko) {
		this.alamatToko = alamatToko;
	}


	@Column(name="NAMA_TOKO")
	public String getNamaToko() {
		return this.namaToko;
	}

	public void setNamaToko(String namaToko) {
		this.namaToko = namaToko;
	}

}