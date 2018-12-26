package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import core.dto.MemberDto;
import core.service.MemberSvc;
import core.util.CommonConstants;
import response.RestResponse;

@RestController
@RequestMapping("/member")
public class MemberCtl {
	
	@Autowired
	MemberSvc memberSvc;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(memberSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody MemberDto memberDto){
		RestResponse restResponse = new RestResponse();
		int i = memberSvc.save(memberDto);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		} 
		return restResponse;
	}
	
	@RequestMapping(value = "/delete/{kode}", method = RequestMethod.DELETE)
	public RestResponse detData(@PathVariable("kode") int kode){
		RestResponse restResponse = new RestResponse(); 
		int i = memberSvc.delete(kode);
		System.out.println(i);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Dihapus");
		} else if (i==2){
			restResponse.setMessage("Data tidak ada");
		} else {
			restResponse.setMessage("Data Gagal Dihapus");
		}
		return restResponse;
	}
}
