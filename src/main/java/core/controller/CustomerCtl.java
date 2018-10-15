package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.MstCustomerDto;
import core.service.MstCustomerSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/customer")
public class CustomerCtl {
	@Autowired
	MstCustomerSvc mstCustomerSvc;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstCustomerSvc.getAll());
		
		return restResponse; 
	}
	
	@RequestMapping(value = "/getOneList/{kodecst}", method = RequestMethod.GET)
	public RestResponse getAll(@PathVariable ("kodecst") String kodecst){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstCustomerSvc.getOneList(kodecst));		
		return restResponse; 
	}
	
	@RequestMapping(value = "/getone/{kode}", method = RequestMethod.GET)
	public RestResponse getData(@PathVariable ("kode") String kode){
		RestResponse restResponse = new RestResponse();
		MstCustomerDto mstCustomerDto = mstCustomerSvc.getOne(kode);
		restResponse.setContents(mstCustomerDto);
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody MstCustomerDto mstCustomerDto) {
		RestResponse restResponse = new RestResponse();
		int i = mstCustomerSvc.save(mstCustomerDto);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		}
		return restResponse;
	}
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.DELETE)
	public RestResponse delData(@PathVariable("id") String id) {
		RestResponse restResponse = new RestResponse();
		int i = mstCustomerSvc.delete(id);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Dihapus");
		} else if (i==2) {
			restResponse.setMessage("Data tidak ada");
		} else {
			restResponse.setMessage("Data Gagal dihapus");
		}
		return restResponse;
	}
}
