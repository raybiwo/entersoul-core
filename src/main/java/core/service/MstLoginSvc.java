package core.service;

import java.util.List;

import core.dto.LdapDto;
import core.dto.MstKaryawanDto;
import core.dto.MstLoginDto;

public interface MstLoginSvc {
	public List<MstLoginDto> getAllLengkap();
	public List<MstLoginDto> getAll();
	public MstLoginDto getOne(String kode);
	public int save(MstLoginDto isi);
	public int delete(String kode);
	public MstKaryawanDto login(MstLoginDto login);
	public LdapDto loginLdap(MstLoginDto login);
}
