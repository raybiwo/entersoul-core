package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MST_CUSTOMER database table.
 * 
 */
@Entity
@Table(name="MST_CUSTOMER")
@NamedQuery(name="MstCustomer.findAll", query="SELECT m FROM MstCustomer m")
public class MstCustomer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idCustomer;
	private String alamat;
	private String namaCustomer;
	private String telp;

	public MstCustomer() {
	}


	@Id
	@Column(name="ID_CUSTOMER")
	public String getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}


	public String getAlamat() {
		return this.alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}


	@Column(name="NAMA_CUSTOMER")
	public String getNamaCustomer() {
		return this.namaCustomer;
	}

	public void setNamaCustomer(String namaCustomer) {
		this.namaCustomer = namaCustomer;
	}


	public String getTelp() {
		return this.telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}

}