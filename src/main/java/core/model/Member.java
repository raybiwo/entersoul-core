package core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String name;
	private String mailAddress;
	private String management;
	private String project;
	
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "MAIL_ADDRESS")
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	@Column(name = "MANAGEMENT")
	public String getManagement() {
		return management;
	}
	public void setManagement(String management) {
		this.management = management;
	}
	
	@Column(name = "PROJECT")
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
}
