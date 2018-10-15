package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.TrxPenjualanHdrDto;
import core.service.TrxPenjualanHdrSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/penjualanhdr")
public class TrxPenjualanHdrCtl {
	@Autowired
	TrxPenjualanHdrSvc trxPenjualanHdrSvc;
	
	@RequestMapping(value = "/allLengkap", method=RequestMethod.GET)
	public RestResponse getAllBarang(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(trxPenjualanHdrSvc.getAllLengkap());
		
		return restResponse;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(trxPenjualanHdrSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody TrxPenjualanHdrDto trxPenjualanHdrDto){
		RestResponse restResponse = new RestResponse();
		int i = trxPenjualanHdrSvc.save(trxPenjualanHdrDto);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		} 
		return restResponse;
	}
	
	@RequestMapping(value = "/delete/{nota}", method = RequestMethod.DELETE)
	public RestResponse detData(@PathVariable("nota") String nota){
		RestResponse restResponse = new RestResponse(); 
		int i = trxPenjualanHdrSvc.delete(nota);
		System.out.println(i);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Dihapus");
		} else {
			restResponse.setMessage("Data Gagal Dihapus");
		}
		return restResponse;
	}
	
	@RequestMapping(value = "/getone/{nota}", method = RequestMethod.GET)
	public RestResponse getData(@PathVariable("nota") String nota){
		RestResponse restResponse= new RestResponse();
		TrxPenjualanHdrDto trxPenjualanHdrDto = trxPenjualanHdrSvc.getOne(nota);
		restResponse.setContents(trxPenjualanHdrDto);
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		return restResponse;
	}
	
	@RequestMapping(value = "/getOneList/{nota}", method=RequestMethod.GET)
	public RestResponse getOne(@PathVariable("nota") String nota){
		RestResponse restResponse = new RestResponse();			
		restResponse.setContents(trxPenjualanHdrSvc.getOneList(nota));

		return restResponse;
	}
}
