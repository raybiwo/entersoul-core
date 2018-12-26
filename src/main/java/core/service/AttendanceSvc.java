package core.service;

import java.util.List;

import core.dto.AttendanceDto;

public interface AttendanceSvc {
	public List<AttendanceDto> getAll();
	
	public List<AttendanceDto> searchUserAttendance(String nik, String tanggal);
	
	public int checkin(AttendanceDto attendanceDto);
	
	public int checkout(AttendanceDto attendanceDto);
	
	public int statusAttendance(AttendanceDto attendanceDto);
	
	public List<AttendanceDto> getAttendance(AttendanceDto attendanceDto);
	
	public List<AttendanceDto> getAllWithMember();
	
	public List<AttendanceDto> getWithName(String nik);
	
	public int save(AttendanceDto isi);
}
