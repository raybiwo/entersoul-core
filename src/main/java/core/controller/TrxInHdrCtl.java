package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.TrxInHdrDto;
import core.service.TrxInHdrSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/trxinhdr")
public class TrxInHdrCtl {
	@Autowired
	TrxInHdrSvc trxInHdrSvc;
	
	@RequestMapping(value = "/getOneList/{kode}", method=RequestMethod.GET)
	public RestResponse getOneList(@PathVariable("kode") String kode){
		RestResponse restResponse = new RestResponse();	
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(trxInHdrSvc.getOneList(kode));

		return restResponse;
	}

	@RequestMapping(value="/allLengkap", method=RequestMethod.GET)
	public RestResponse getAllLengkap(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(trxInHdrSvc.getAllLengkap());
		return restResponse;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(trxInHdrSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(value="/getone/{kode}", method=RequestMethod.GET)
	public RestResponse getOne(@PathVariable("kode") String kode){
		RestResponse restResponse = new RestResponse();
		TrxInHdrDto trxInHdrDto = trxInHdrSvc.getOne(kode);
		restResponse.setContents(trxInHdrDto);
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody TrxInHdrDto trxInHdrDto) {
		RestResponse restResponse = new RestResponse();
		int i = trxInHdrSvc.save(trxInHdrDto);
		restResponse.setStatus(i);
		if (i == CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		}
		return restResponse;
	}
	
	@RequestMapping(value="/delete/{kode}", method=RequestMethod.DELETE)
	public RestResponse delData(@PathVariable("kode") String kode) {
		RestResponse restResponse = new RestResponse(); 
		int i = trxInHdrSvc.delete(kode);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Dihapus");
		} else {
			restResponse.setMessage("Data Gagal Dihapus");
		}
		return restResponse;
	}
}
