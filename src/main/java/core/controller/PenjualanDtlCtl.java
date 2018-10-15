package core.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import response.RestResponse;
import core.dto.TrxPenjualanDtlDto;
import core.service.MstBarangSvc;
import core.service.TrxPenjualanDtlSvc;
import core.service.TrxPenjualanHdrSvc;
import core.util.CommonConstants;

@RestController
@RequestMapping("/penjualandtl")
public class PenjualanDtlCtl {
	@Autowired
	TrxPenjualanDtlSvc trxPenjualanDtlSvc;

	@Autowired
	TrxPenjualanHdrSvc trxPenjualanHdrSvc;

	@Autowired
	MstBarangSvc mstBarangSvc;

	@RequestMapping(value = "/getByNota/{nota}", method = RequestMethod.GET)
	public RestResponse getByNota(@PathVariable("nota") String nota) {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.ERROR_REST_STATUS);
		Map<String, Object> map = trxPenjualanDtlSvc.getByNota(nota);
		restResponse.setTotalRecords((long) map.get("jumlah"));
		restResponse.setContents(map.get("content"));
		return restResponse;
	}

	@RequestMapping(value = "/allLengkap", method = RequestMethod.GET)
	public RestResponse getAllLengkap() {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		Map<String, Object> map = trxPenjualanDtlSvc.getAllLengkap();
		restResponse.setTotalRecords((long) map.get("jumlah"));
		restResponse.setContents(map.get("content"));
		return restResponse;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public RestResponse getAll() {
		RestResponse restResponse = new RestResponse();
		restResponse.setStatus(CommonConstants.OK_REST_STATUS);
		restResponse.setContents(trxPenjualanDtlSvc.getAll());

		return restResponse;
	}

	@RequestMapping(value = "/getone/{id}/{kode}/{nota}", method = RequestMethod.GET)
	public RestResponse getOne(@PathVariable("id") String id,
			@PathVariable("kode") String kode, @PathVariable("nota") String nota) {
		RestResponse restResponse = new RestResponse();
		restResponse.setContents(trxPenjualanDtlSvc.getOne(id, kode, nota));
		restResponse.setStatus(0);
		restResponse.setMessage("Data");
		return restResponse;
	}

	@RequestMapping(method = RequestMethod.POST)
	public RestResponse addData(
			@RequestBody TrxPenjualanDtlDto trxPenjualanDtlDto) {
		RestResponse restResponse = new RestResponse();
		int i = trxPenjualanDtlSvc.save(trxPenjualanDtlDto);
		restResponse.setStatus(i);
		if (i == CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Masuk");
		} else {
			restResponse.setMessage("Data Gagal Disimpan");
		}
		return restResponse;
	}

	@RequestMapping(value = "/delete/{nota}", method = RequestMethod.DELETE)
	public RestResponse delData(@PathVariable("nota") String nota) {
		RestResponse restResponse = new RestResponse();
		int i = trxPenjualanDtlSvc.delete(nota);
		restResponse.setStatus(i);
		if (i == CommonConstants.OK_REST_STATUS) {
			restResponse.setMessage("Data Sudah Dihapus");
		} else {
			restResponse.setMessage("Data Gagal Dihapus");
		}
		return restResponse;
	}
}
