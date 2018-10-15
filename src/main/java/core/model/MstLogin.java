package core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MST_LOGIN database table.
 * 
 */
@Entity
@Table(name="MST_LOGIN")
@NamedQuery(name="MstLogin.findAll", query="SELECT m FROM MstLogin m")
public class MstLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idKaryawan;
	private String password;
	private String username;

	public MstLogin() {
	}


	@Id
	@Column(name="ID_KARYAWAN")
	public String getIdKaryawan() {
		return this.idKaryawan;
	}

	public void setIdKaryawan(String idKaryawan) {
		this.idKaryawan = idKaryawan;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}