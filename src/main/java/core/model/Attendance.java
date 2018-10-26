package core.model;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ATTENDANCE")
@NamedQuery(name="Attendance.findAll", query="SELECT m FROM Attendance m")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String nik;
	private String attendanceDate;
	private Time checkin;
	private Time chekout;
	private String longitude;
	private String latitude;
		
	public Attendance() {
	}

	@Id
	@Column(name="ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name="NIK")
	public String getNik() {
		return nik;
	}
	
	public void setNik(String nik) {
		this.nik = nik;
	}
	
	@Column(name="ATTENDANCE_DATE")
	public String getAttendanceDate() {
		return attendanceDate;
	}
	
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	
	@Column(name="CHECKIN")
	public Time getCheckin() {
		return checkin;
	}
	
	public void setCheckin(Time checkin) {
		this.checkin = checkin;
	}
	
	@Column(name="CHEKOUT")
	public Time getChekout() {
		return chekout;
	}
	
	public void setChekout(Time chekout) {
		this.chekout = chekout;
	}
	
	@Column(name="LONGITUDE")
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	@Column(name="LATITUDE")
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}
