package core.service;

import java.util.List;

import core.dto.MstTokoDto;

public interface MstTokoSvc {
	public List<MstTokoDto> getAll();
	public MstTokoDto getOne(String kode);
	public int save(MstTokoDto isi);
	public int delete(String kode);
	public List<MstTokoDto> getOneList(String kode);
}
