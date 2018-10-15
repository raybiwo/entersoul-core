package core.service;

import java.util.List;

import core.dto.MstJenisBarangDto;

public interface MstJenisBarangSvc {
	public List<MstJenisBarangDto> getAll();
	public MstJenisBarangDto getOne(String kode);
	public int save(MstJenisBarangDto isi);
	public int delete(String kode);
	public List<MstJenisBarangDto> getOneList(String kode);
}
