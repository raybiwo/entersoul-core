package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.MstJobDto;
import core.service.MstJobSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/job")
public class JobCtl {
	@Autowired
	MstJobSvc mstJobSvc;
	
	@RequestMapping(value="/getOneList/{kode}", method=RequestMethod.GET)
	public RestResponse getOneList(@PathVariable ("kode") String kode){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstJobSvc.getOneList(kode));
		
		return restResponse;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstJobSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(value="/getone/{kode}", method=RequestMethod.GET)
	public RestResponse getData(@PathVariable ("kode") String kode){
		RestResponse restResponse = new RestResponse();
		MstJobDto mstJobDto = mstJobSvc.getOne(kode);
		restResponse.setContents(mstJobDto);
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody MstJobDto mstJobDto){
		RestResponse restResponse = new RestResponse();
		int i = mstJobSvc.save(mstJobDto);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		}
		return restResponse;
	}
	
	@RequestMapping(value="/delete/{kode}", method=RequestMethod.DELETE)
	public RestResponse delData(@PathVariable("kode") String kode){
		RestResponse restResponse = new RestResponse();
		int i = mstJobSvc.delete(kode);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah dihapus");
		} else if (i==2) {
			restResponse.setMessage("Data tidak ada");
		} else {
			restResponse.setMessage("Data Gagal dihapus");
		}
		return restResponse;
	}
}
