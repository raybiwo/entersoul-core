package core.service;

import java.util.List;

import core.dto.AttendanceDto;

public interface AttendanceSvc {
	public List<AttendanceDto> getAll();
	
	public List<AttendanceDto> searchUserAttendance(String nik);
}
