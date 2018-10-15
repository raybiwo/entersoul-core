package core.service;

import java.util.List;

import core.dto.MstSupplierDto;

public interface MstSupplierSvc {
	public List<MstSupplierDto> getAll();
	public MstSupplierDto getOne(String kode);
	public int save(MstSupplierDto isi);
	public int delete(String kode);
	public List<MstSupplierDto> getOneList(String kode);
}
