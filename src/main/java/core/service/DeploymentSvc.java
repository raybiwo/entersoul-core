package core.service;

import java.util.List;

import core.dto.DeploymentDto;

public interface DeploymentSvc {
	public List<DeploymentDto> getAll();
	
	public int save(DeploymentDto isi);
	
	public int delete(int id);
}
