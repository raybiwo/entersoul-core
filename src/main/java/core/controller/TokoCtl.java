package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.MstTokoDto;
import core.service.MstTokoSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/toko")
public class TokoCtl {
	@Autowired
	MstTokoSvc mstTokoSvc;
	
	@RequestMapping(value="getOneList/{kode}", method=RequestMethod.GET)
	public RestResponse getAll(@PathVariable("kode") String kode){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstTokoSvc.getOneList(kode));
		restResponse.setMessage("OK");
		
		return restResponse;
	}
	
	@RequestMapping(value="all", method=RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstTokoSvc.getAll());
		restResponse.setMessage("OK");
		
		return restResponse;
	}
	
	@RequestMapping(value="getone/{kode}", method=RequestMethod.GET)
	public RestResponse getData(@PathVariable("kode") String kode) {
		RestResponse restResponse = new RestResponse();
		MstTokoDto mstTokoDto = mstTokoSvc.getOne(kode);
		restResponse.setContents(mstTokoDto);
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody MstTokoDto mstTokoDto) {
		RestResponse restResponse = new RestResponse();
		int i = mstTokoSvc.save(mstTokoDto);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		}
		return restResponse;
	}
	
	@RequestMapping(value="/delete/{kode}", method=RequestMethod.DELETE)
	public RestResponse delData(@PathVariable("kode") String kode) {
		RestResponse restResponse = new RestResponse();
		int i = mstTokoSvc.delete(kode);
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
