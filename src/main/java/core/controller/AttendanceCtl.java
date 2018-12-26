package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.dto.AttendanceDto;
import core.dto.LdapDto;
import core.dto.MstLoginDto;
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
	
	@RequestMapping(value = "/saveTimesheet", method = RequestMethod.POST)
	public RestResponse saveTimesheet(@RequestBody AttendanceDto payload){
		RestResponse restResponse = new RestResponse();
		int i = attendanceSvc.save(payload);
		if (i == 1) {
			restResponse.setMessage("success");
			restResponse.setStatus(CommonConstants.OK_REST_STATUS);
			restResponse.setContents(null);
		} else {
			restResponse.setMessage("success");
			restResponse.setStatus(CommonConstants.OK_REST_STATUS);
			restResponse.setContents(null);
		}
		;
		return restResponse;
	}
	
	@RequestMapping(value = "/allWithMember", method = RequestMethod.GET)
	public RestResponse getAllWithMember(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(attendanceSvc.getAllWithMember());
		return restResponse;
	}
	
	@RequestMapping(value = "/allWithName", method = RequestMethod.POST)
	public RestResponse getallWithName(@RequestBody AttendanceDto payload){
		System.out.println("check nik : "+payload.getNik());
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(attendanceSvc.getWithName(payload.getNik()));
		return restResponse;
	}
	
	@RequestMapping(value = "/searchAttendance/{nik}", method = RequestMethod.GET)
	public RestResponse search(@PathVariable("nik") String nik){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(attendanceSvc.searchUserAttendance(nik, "2018/10"));
		return restResponse;
	}
	
	@RequestMapping(value = "/statusAttendance", method = RequestMethod.POST)
	public RestResponse getOne(@RequestBody AttendanceDto payload){
		RestResponse restResponse = new RestResponse();
		String text = "O";
		if (payload.getLatitude().contains(text)) {
			System.out.println("satu "+payload.getLatitude());
			restResponse.setStatus(1);
			restResponse.setMessage("checkin");
			restResponse.setContents(attendanceSvc.getAttendance(payload));
		} else {
			int result = attendanceSvc.statusAttendance(payload);
			if (result==CommonConstants.OK_REST_STATUS) {
				System.out.println("dua "+payload.getLatitude());
				restResponse.setStatus(1);
				restResponse.setMessage("checkin");
				restResponse.setContents(attendanceSvc.getAttendance(payload));
			} else {
				System.out.println("tiga "+payload.getLatitude());
				restResponse.setStatus(0);
				restResponse.setMessage("checkout");
				restResponse.setContents("");
			}
		}
		
		return restResponse;
		
	}
	
	@RequestMapping(value="/setAttendance", method=RequestMethod.POST)
	public RestResponse loginLdap(@RequestBody AttendanceDto payload) {
		RestResponse restResponse = new RestResponse();
		String tanggal = payload.getAttendanceDate().substring(0, payload.getAttendanceDate().lastIndexOf("/"));
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(attendanceSvc.searchUserAttendance(payload.getNik(), tanggal));
		
//		if (payload.getIsCheckin()) {
//			int i = attendanceSvc.checkin(payload);
//			if (i == CommonConstants.OK_REST_STATUS) {
//				restResponse.setStatus(CommonConstants.OK_REST_STATUS);
//				restResponse.setContents(attendanceSvc.searchUserAttendance(payload.getNik(), tanggal));
//			} else {
//				restResponse.setStatus(CommonConstants.ERROR_REST_STATUS);
//				restResponse.setContents(null);
//			}
//		} else {
//			int i = attendanceSvc.checkout(payload);
//			if (i == CommonConstants.OK_REST_STATUS) {
//				restResponse.setStatus(CommonConstants.OK_REST_STATUS);
//				restResponse.setContents(attendanceSvc.searchUserAttendance(payload.getNik(), tanggal));
//			} else {
//				restResponse.setStatus(CommonConstants.ERROR_REST_STATUS);
//				restResponse.setContents(null);
//			}
//		}
		
		return restResponse;
	}

}
