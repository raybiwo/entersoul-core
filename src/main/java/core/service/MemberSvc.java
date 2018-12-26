package core.service;

import java.util.List;

import core.dto.MemberDto;

public interface MemberSvc {
	
	public List<MemberDto> getAll();
	
	public int save(MemberDto isi);
	
	public int delete(int id);
	
}
