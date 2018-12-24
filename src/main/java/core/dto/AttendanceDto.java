package core.dto;

import java.sql.Time;

public class AttendanceDto {
	private Integer id;
	private String nik;
	private String attendanceDate;
	private String checkin;
	private String chekout;
	private Time checkTime;
	private String longitude;
	private String latitude;
	private String name;
	private String email;
	private boolean isCheckin;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNik() {
		return nik;
	}
	
	public void setNik(String nik) {
		this.nik = nik;
	}
	
	public String getAttendanceDate() {
		return attendanceDate;
	}
	
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	
	public String getCheckin() {
		return checkin;
	}
	
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	
	public String getChekout() {
		return chekout;
	}
	
	public void setChekout(String chekout) {
		this.chekout = chekout;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsCheckin() {
		return isCheckin;
	}

	public void setIsCheckin(boolean isCheckin) {
		this.isCheckin = isCheckin;
	}

	public Time getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Time checkTime) {
		this.checkTime = checkTime;
	}

}
