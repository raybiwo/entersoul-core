package core.service;

import java.util.List;
import core.dto.KPITesterDto;

public interface KPITesterSvc {
	
	public List<KPITesterDto> getAll();
	
	public int save(KPITesterDto isi);
}
