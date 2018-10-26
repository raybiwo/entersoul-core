package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.AttendanceDao;
import core.dto.AttendanceDto;
import core.model.Attendance;
import core.service.AttendanceSvc;
import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
public class AttendanceSvcImpl implements AttendanceSvc {
	@Autowired
	AttendanceDao attendanceDao;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public List<AttendanceDto> getAll() {
		// TODO Auto-generated method stub
		List<AttendanceDto> attendanceDtos = new ArrayList<AttendanceDto>();
		List<Object> obj = attendanceDao.getAll();
		
		attendanceDtos = mapperFacade.mapAsList(obj, AttendanceDto.class);
		return attendanceDtos;
	}

	@Override
	public List<AttendanceDto> searchUserAttendance(String nik) {
		// TODO Auto-generated method stub
		List<AttendanceDto> attendanceDtos = new ArrayList<AttendanceDto>();
		List<Object[]> qr = attendanceDao.searchUserAttendance(nik);
		
		for (Object[] obj : qr) {
			AttendanceDto attendanceDto = new AttendanceDto();
			Attendance mdl = new Attendance();
			mdl = (Attendance) obj[0];
			
			attendanceDto = mapperFacade.map(mdl, AttendanceDto.class);
			attendanceDto.setName((String) obj[1]);
			attendanceDto.setEmail((String) obj[2]);
			
			attendanceDtos.add(attendanceDto);
		}
		
		return attendanceDtos;
	}

}
