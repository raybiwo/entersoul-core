package core.service;

import java.util.List;

import core.dto.TrxPenjualanHdrDto;

public interface TrxPenjualanHdrSvc {
	public List<TrxPenjualanHdrDto> getAllLengkap();
	public List<TrxPenjualanHdrDto> getAll();
	public TrxPenjualanHdrDto getOne(String nota);
	public List<TrxPenjualanHdrDto> getOneList(String nota);
	public int save(TrxPenjualanHdrDto isi);
	public int delete(String nota);
}
