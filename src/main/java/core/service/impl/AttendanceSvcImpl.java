package core.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.AttendanceDao;
import core.dto.AttendanceDto;
import core.model.Attendance;
import core.service.AttendanceSvc;
import core.util.CommonConstants;
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
	public List<AttendanceDto> searchUserAttendance(String nik, String tanggal) {
		// TODO Auto-generated method stub
		
		List<AttendanceDto> attendanceDtos = new ArrayList<AttendanceDto>();
		List<Object> obj = attendanceDao.searchUserAttendance(nik, tanggal);
		
		attendanceDtos = mapperFacade.mapAsList(obj, AttendanceDto.class);
		
//		for (Object obj : qr) {
//			attendanceDtos = mapperFacade.mapAsList(obj, AttendanceDto.class);
//			
//			AttendanceDto attendanceDto = new AttendanceDto();
//			attendanceDto.setId((Integer) obj[0]);
//			attendanceDto.setNik((String) obj[1]);
//			attendanceDto.setAttendanceDate((String) obj[2]);
//			attendanceDto.setCheckin((String) obj[3].toString());
//			attendanceDto.setChekout((String) obj[4].toString());
//			attendanceDto.setLongitude((String) obj[5]);
//			attendanceDto.setLatitude((String) obj[6]);
//			attendanceDtos.add(attendanceDto);
//		}
		return attendanceDtos;
	}

	@Override
	public int checkin(AttendanceDto attendanceDto) {
		// TODO Auto-generated method stub
		
		List<AttendanceDto> attendance = getAttendance(attendanceDto);
		
		if (attendance != null) {
//			System.out.println("id : " +attendance.getId());
			int t = attendanceDao.updateCheckin(attendanceDto.getCheckTime(), attendanceDto.getLongitude(), attendanceDto.getLatitude(), 1);
			
			System.out.println("return value T : "+t);
			if (t == 1) {
				return CommonConstants.OK_REST_STATUS;
			} else {
				return CommonConstants.ERROR_REST_STATUS;
			}
			
		} else {
			attendanceDto.setCheckin(attendanceDto.getCheckTime().toString());
			Attendance isimdl = mapperFacade.map(attendanceDto, Attendance.class);
			attendanceDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		}		
	}

	@Override
	public int checkout(AttendanceDto attendanceDto) {
		// TODO Auto-generated method stub
		List<AttendanceDto> attendance = getAttendance(attendanceDto);
		
		if (attendance != null) {
			attendanceDao.updateCheckout(attendanceDto.getCheckTime(), 
					attendanceDto.getLongitude(), 
					attendanceDto.getLatitude(), 
					attendanceDto.getAttendanceDate(), 
					attendanceDto.getNik());
			return CommonConstants.OK_REST_STATUS;
		} else {
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int statusAttendance(AttendanceDto attendanceDto) {
		// TODO Auto-generated method stub
		Attendance attendance = new Attendance();
		
		List<AttendanceDto> attendanceDtos = getAttendance(attendanceDto);
		System.out.println("Check attendance : "+attendanceDtos);
		if (attendanceDtos.isEmpty() && attendanceDto.getIsCheckin()==true && attendanceDto.getCheckTime()!=null) {
			attendance.setAttendanceDate(attendanceDto.getAttendanceDate());
			attendance.setCheckin(attendanceDto.getCheckTime());
			attendance.setLatitude(attendanceDto.getLatitude());
			attendance.setLongitude(attendanceDto.getLongitude());
			attendance.setNik(attendanceDto.getNik());
			attendanceDao.save(attendance);
		} else if (attendanceDtos!=null && attendanceDto.getIsCheckin()==false && attendanceDto.getCheckTime()!=null) {
			attendanceDao.updateCheckout(attendanceDto.getCheckTime(), 
					attendanceDto.getLongitude(), 
					attendanceDto.getLatitude(), 
					attendanceDto.getAttendanceDate(), 
					attendanceDto.getNik());
		} else {
			return CommonConstants.OK_REST_STATUS;
		}
		
		return CommonConstants.OK_REST_STATUS;
	}
	
	
	@Override
	public List<AttendanceDto> getAttendance(AttendanceDto attendanceDto) {
		List<AttendanceDto> attendanceDtos = new ArrayList<AttendanceDto>();
		
		List<Object> obj= attendanceDao.searchId(attendanceDto.getNik(), attendanceDto.getAttendanceDate());
		attendanceDtos = mapperFacade.mapAsList(obj, AttendanceDto.class);
		return attendanceDtos;
	}
}
