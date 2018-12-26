package core.service;

import java.util.List;

import core.dto.KPIResultDto;

public interface KPIResultSvc {

	public List<KPIResultDto> getAll();
	
	public int save(KPIResultDto isi);
}
