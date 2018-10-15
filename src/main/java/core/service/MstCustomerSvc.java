package core.service;

import java.util.List;

import core.dto.MstCustomerDto;

public interface MstCustomerSvc {
	public List<MstCustomerDto> getAll();
	public MstCustomerDto getOne(String id);
	public int save(MstCustomerDto isi);
	public int delete(String id);
	public List<MstCustomerDto> getOneList(String kodecst);
}
