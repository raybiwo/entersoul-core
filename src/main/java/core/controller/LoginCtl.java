package core.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.MstLoginDto;
import core.service.MstLoginSvc;
import core.util.CommonConstants;
import core.util.JsonUtil;

@RestController
@RequestMapping("/login")
public class LoginCtl {
	@Autowired
	MstLoginSvc mstLoginSvc;
	
	@RequestMapping(value="/loginLdap", method=RequestMethod.POST)
	public RestResponse loginLdap(@RequestBody MstLoginDto payload) {
		RestResponse restResponse = new RestResponse();
		restResponse.setContents(mstLoginSvc.loginLdap(payload));
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		return restResponse;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public RestResponse login(@RequestBody MstLoginDto mstLoginDto) {
		RestResponse restResponse = new RestResponse();
		restResponse.setContents(mstLoginSvc.login(mstLoginDto));
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		return restResponse;
	}
	
	@RequestMapping(value = "/allLengkap", method=RequestMethod.GET)
	public RestResponse getAllLengkap(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstLoginSvc.getAllLengkap());
		
		return restResponse;
	}
	
	@RequestMapping(value="all", method=RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstLoginSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(value="getone/{kode}", method=RequestMethod.GET)
	public RestResponse getData(@PathVariable("kode") String kode) {
		RestResponse restResponse = new RestResponse();
		MstLoginDto mstLoginDto = mstLoginSvc.getOne(kode);
		restResponse.setContents(mstLoginDto);
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody MstLoginDto mstLoginDto) {
		RestResponse restResponse = new RestResponse();
		int i = mstLoginSvc.save(mstLoginDto);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else if (i==2) {
			restResponse.setMessage("Data Sudah Ada");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		}
		return restResponse;
	}
	
	@RequestMapping(value="/delete/{kode}", method=RequestMethod.DELETE)
	public RestResponse delData(@PathVariable("kode") String kode) {
		RestResponse restResponse = new RestResponse();
		int i = mstLoginSvc.delete(kode);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Dihapus");
		} else if (i==2) {
			restResponse.setMessage("Data Tidak Ada");
		} else {
			restResponse.setMessage("Data Gagal Dihapus");
		}
		return restResponse;
	}
}
