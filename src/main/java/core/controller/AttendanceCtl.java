package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.service.AttendanceSvc;
import core.util.CommonConstants;
import response.RestResponse;

@RestController
@RequestMapping("/attendance")
public class AttendanceCtl {
	
	@Autowired
	AttendanceSvc attendanceSvc;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(attendanceSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(value = "/searchAttendance/{nik}", method = RequestMethod.GET)
	public RestResponse search(@PathVariable("nik") String nik){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(attendanceSvc.searchUserAttendance(nik));
		
		return restResponse;
	}

}
