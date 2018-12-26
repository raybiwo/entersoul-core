package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import core.dto.KPITesterDto;
import core.service.KPITesterSvc;
import core.util.CommonConstants;
import response.RestResponse;

@RestController
@RequestMapping("/tester")
public class KPITesterCtl {
	@Autowired
	KPITesterSvc kpiTesterSvc;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(kpiTesterSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	public RestResponse addData(@RequestBody KPITesterDto kpiTesterDto){
		RestResponse restResponse = new RestResponse();
		int i = kpiTesterSvc.save(kpiTesterDto);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		} 
		return restResponse;
	}
}
