package core.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="DEPLOYMENT")
@NamedQuery(name="Deployment.findAll", query="SELECT m FROM Deployment m")
public class Deployment implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String depName;
	private String devName;
	private String projectName;
	private Date deployDate;
	private String status;
	private String pushFixing;
	private String issue;
	
	
	/**
	 * Author Raybiwo
	 */
	public Deployment() {
	}
	
	@Id
	@Column(name="ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="DEP_NAME")
	public String getDepName() {
		return depName;
	}
	
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	@Column(name="DEV_NAME")
	public String getDevName() {
		return devName;
	}
	
	public void setDevName(String devName) {
		this.devName = devName;
	}
	
	@Column(name="PROJECT_NAME")
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Column(name="DEPLOY_DATE")
	public Date getDeployDate() {
		return deployDate;
	}
	
	public void setDeployDate(Date deployDate) {
		this.deployDate = deployDate;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="PUSH_FIXING")
	public String getPushFixing() {
		return pushFixing;
	}
	
	public void setPushFixing(String pushFixing) {
		this.pushFixing = pushFixing;
	}
	
	@Column(name="ISSUE")
	public String getIssue() {
		return issue;
	}
	
	public void setIssue(String issue) {
		this.issue = issue;
	}
}
