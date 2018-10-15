package core.service;

import java.util.List;

import core.dto.TrxInHdrDto;

public interface TrxInHdrSvc {
	public List<TrxInHdrDto> getAllLengkap();
	public List<TrxInHdrDto> getAll();
	public TrxInHdrDto getOne(String kode);
	public int save(TrxInHdrDto isi);
	public int delete(String kode);
	public List<TrxInHdrDto> getOneList(String kode);
}
