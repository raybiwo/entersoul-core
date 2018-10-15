package core.service;

import java.util.List;

import core.dto.MstKaryawanDto;

public interface MstKaryawanSvc {
	public List<MstKaryawanDto> getAll();
	public MstKaryawanDto getOne(String kode);
	public int save(MstKaryawanDto isi);
	public int delete(String kode);
	public List<MstKaryawanDto> getOneList(String kode);
}
