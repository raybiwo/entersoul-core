package core.service;

import java.util.List;
import java.util.Map;

import core.dto.TrxInDtlDto;

public interface TrxInDtlSvc {
	public Map<String, Object> getAllLengkap();
	public List<TrxInDtlDto> getAll();
	public TrxInDtlDto getOne(String kodedtl, String kodeinv, String kodebgr);
	public int save(TrxInDtlDto isi);
	public int delete(String inv);
	public Map<String, Object> getByInv(String inv);
}
