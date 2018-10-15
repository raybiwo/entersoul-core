package core.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.MstBarangDto;
import core.service.MstBarangSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/barang")
public class BarangCtl {

		@Autowired
		MstBarangSvc mstBarangSvc;
		
		@RequestMapping(value = "/search/{kode}", method = RequestMethod.GET)
		public RestResponse search(@PathVariable("kode") String kode){
			RestResponse restResponse = new RestResponse();
			restResponse.setStatus(CommonConstants.OK_REST_STATUS);
			restResponse.setContents(mstBarangSvc.search(kode));
			
			return restResponse;
		}
		
		@RequestMapping(value = "/findOne/{kode}", method=RequestMethod.GET)
		public RestResponse getOneNamBar(@PathVariable("kode") String kode){
			RestResponse restResponse = new RestResponse();
			MstBarangDto mstBarangDto = mstBarangSvc.findOne(kode);
			restResponse.setContents(mstBarangDto);
			restResponse.setStatus(0);
			restResponse.setMessage("Data");
			return restResponse;
		}
		
		@RequestMapping(value = "/allLengkap", method=RequestMethod.GET)
		public RestResponse getAllBarang(){
			RestResponse restResponse = new RestResponse();
			restResponse.setStatus(CommonConstants.OK_REST_STATUS);
			Map<String, Object> map = mstBarangSvc.getAllLengkap();
			restResponse.setTotalRecords((long) map.get("jumlah"));
			restResponse.setContents(map.get("content"));
			
			return restResponse;
		}
		
		@RequestMapping(value = "/all", method = RequestMethod.GET)
		public RestResponse getAll(){
			RestResponse restResponse = new RestResponse();
			restResponse.setStatus(CommonConstants.OK_REST_STATUS);
			restResponse.setContents(mstBarangSvc.getAll());
			
			return restResponse;
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public RestResponse addData(@RequestBody MstBarangDto mstBarangDto){
			RestResponse restResponse = new RestResponse();
			int i = mstBarangSvc.save(mstBarangDto);
			restResponse.setStatus(i);
			if (i==CommonConstants.OK_REST_STATUS) {
				restResponse.setMessage("Data Sudah Masuk");
			} else {
				restResponse.setMessage("Data Gagal Disimpan");
			} 
			return restResponse;
		}
		
		@RequestMapping(value = "/delete/{kode}", method = RequestMethod.DELETE)
		public RestResponse detData(@PathVariable("kode") String kode){
			RestResponse restResponse = new RestResponse(); 
			int i = mstBarangSvc.delete(kode);
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
		
		@RequestMapping(value = "/getone/{kode}", method = RequestMethod.GET)
		public RestResponse getData(@PathVariable("kode") String kode){
			RestResponse restResponse= new RestResponse();
			MstBarangDto mstBarangDto = mstBarangSvc.getOne(kode);
			restResponse.setContents(mstBarangDto);
			restResponse.setStatus(0);
			restResponse.setMessage("Data");
			return restResponse;
		}
		
		@RequestMapping(value = "/saveList", method=RequestMethod.POST)
		public RestResponse addData(@RequestBody List<MstBarangDto> isiList){
			RestResponse restResponse = new RestResponse();
			int i = mstBarangSvc.savelist(isiList);
			restResponse.setStatus(i);
			if (i==CommonConstants.OK_REST_STATUS) {
				restResponse.setMessage("Data Sudah Masuk");
			} else {
				restResponse.setMessage("Data Gagal Disimpan");
			} 
			return restResponse;
		}
		
		@RequestMapping(value = "/getOneList/{kode}", method=RequestMethod.GET)
		public RestResponse getOne(@PathVariable("kode") String kode){
			RestResponse restResponse = new RestResponse();			
			restResponse.setContents(mstBarangSvc.getOneList(kode));

			return restResponse;
		}
}
