package core.service;

import java.util.List;
import java.util.Map;

import core.dto.TrxPenjualanDtlDto;

public interface TrxPenjualanDtlSvc {
	public Map<String, Object> getAllLengkap();
	public List<TrxPenjualanDtlDto> getAll();
	public TrxPenjualanDtlDto getOne(String id, String kode, String nota);
	public int save(TrxPenjualanDtlDto isi);
	public int delete(String nota);
	//public List<TrxPenjualanDtlDto> getOneByNota(String nota);
	public Map<String, Object> getByNota(String nota);
}
