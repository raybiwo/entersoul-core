package core.service;

import java.util.List;

import core.dto.MstMerkBarangDto;

public interface MstMerkBarangSvc {
	public List<MstMerkBarangDto> getAll();
	public MstMerkBarangDto getOne(String kode);
	public int save(MstMerkBarangDto isi);
	public int delete(String kode);
	public List<MstMerkBarangDto> getOneList(String kode);
}
