package core.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
@NamedQuery(name="Users.findAll", query="SELECT m FROM Users m")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String uniqueId;
	private String name;
	private String email;
	private String encryptedPassword;
	private String salt;
	private Date createdAt;
	private Date updatedAt;
	private String nik;
	
	public Users() {
		
	}
	
	@Id
	@Column(name="ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="UNIQUE_ID")
	public String getUniqueId() {
		return uniqueId;
	}
	
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="ENCRYPTED_PASSWORD")
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	
	@Column(name="SALT")
	public String getSalt() {
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Column(name="CREATED_AT")
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column(name="UPDATED_AT")
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Column(name="NIK")
	public String getNik() {
		return nik;
	}
	
	public void setNik(String nik) {
		this.nik = nik;
	}
}
