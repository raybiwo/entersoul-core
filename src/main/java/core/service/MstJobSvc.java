package core.service;

import java.util.List;

import core.dto.MstJobDto;

public interface MstJobSvc {
	public List<MstJobDto> getAll();
	public MstJobDto getOne(String kode);
	public int save(MstJobDto isi);
	public int delete(String kode);
	public List<MstJobDto> getOneList(String kode);
}
