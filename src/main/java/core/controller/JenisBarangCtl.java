package core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.MstJenisBarangDto;
import core.service.MstJenisBarangSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/jenisbarang")
public class JenisBarangCtl {
	@Autowired
	MstJenisBarangSvc mstJenisBarangSvc;
	
	@RequestMapping(value="/getOneList/{kode}", method=RequestMethod.GET)
	public RestResponse getAll(@PathVariable ("kode") String kode){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstJenisBarangSvc.getOneList(kode));
		
		return restResponse;
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public RestResponse getAll(){
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(mstJenisBarangSvc.getAll());
		
		return restResponse;
	}
	
	@RequestMapping(value = "/getone/{kode}", method=RequestMethod.GET)
	public RestResponse getData(@PathVariable ("kode") String kode){
		RestResponse restResponse = new RestResponse();
		MstJenisBarangDto mstJenisBarangDto = mstJenisBarangSvc.getOne(kode);
		restResponse.setContents(mstJenisBarangDto);
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		return restResponse;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public RestResponse addData(@RequestBody MstJenisBarangDto mstJenisBarangDto){
		RestResponse restResponse = new RestResponse();
		int i = mstJenisBarangSvc.save(mstJenisBarangDto);
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
	public RestResponse delData(@PathVariable("kode") String kode){
		RestResponse restResponse = new RestResponse();
		int i = mstJenisBarangSvc.delete(kode);
		restResponse.setStatus(i);
		if (i==CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Dihapus");
		} else if(i==2){
			restResponse.setMessage("Data tidak ada");
		} else {
			restResponse.setMessage("Data Gagal dihapus");
		}
		return restResponse;
	}
}
