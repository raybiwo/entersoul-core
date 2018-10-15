package core.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.TrxInDtlDto;
import core.service.TrxInDtlSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/trxindtl")
public class TrxInDtlCtl {
	@Autowired
	TrxInDtlSvc trxInDtlSvc;
	
	@RequestMapping(value = "/getByInv/{inv}", method = RequestMethod.GET)
	public RestResponse getByNota(@PathVariable("inv") String inv) {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.ERROR_REST_STATUS);
		Map<String, Object> map = trxInDtlSvc.getByInv(inv);
		restResponse.setTotalRecords((long) map.get("jumlah"));
		restResponse.setContents(map.get("content"));
		return restResponse;
	}
	
	@RequestMapping(value="/allLengkap", method=RequestMethod.GET)
	public RestResponse getAllLengkap(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		Map<String, Object> map = trxInDtlSvc.getAllLengkap();
		restResponse.setTotalRecords((long) map.get("jumlah"));
		restResponse.setContents(map.get("content"));
		return restResponse;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(trxInDtlSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(value="/getone/{kodedtl}/{kodeinv}/{kodebrg}", method=RequestMethod.GET)
	public RestResponse getOne(@PathVariable("kodedtl") String kodedtl, @PathVariable("kodeinv") String kodeinv, @PathVariable("kodebrg") String kodebrg){
		RestResponse restResponse = new RestResponse();
		restResponse.setContents(trxInDtlSvc.getOne(kodedtl, kodeinv, kodebrg));
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody TrxInDtlDto trxInDtlDto) {
		RestResponse restResponse = new RestResponse();
		int i = trxInDtlSvc.save(trxInDtlDto);
		restResponse.setStatus(i);
		if (i == CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		}
		return restResponse;
	}
	
	@RequestMapping(value="/delete/{inv}", method=RequestMethod.DELETE)
	public RestResponse delData(@PathVariable("inv") String inv) {
		RestResponse restResponse = new RestResponse(); 
		int i = trxInDtlSvc.delete(inv);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Dihapus");
		} else {
			restResponse.setMessage("Data Gagal Dihapus");
		}
		return restResponse;
	}
}
