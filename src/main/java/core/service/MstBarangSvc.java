package core.service;

import java.util.List;
import java.util.Map;


import core.dto.MstBarangDto;

public interface MstBarangSvc {
	public Map<String, Object> getAllLengkap();
	public List<MstBarangDto> getAll();

	public MstBarangDto getOne(String kode);
	public List<MstBarangDto> getOneList(String kode);
	
	public List<MstBarangDto> search(String kode);

	public int save(MstBarangDto isi);

	public int delete(String kode);

	public MstBarangDto findOne(String kode);

	public int savelist(List<MstBarangDto> listBrg);
}
