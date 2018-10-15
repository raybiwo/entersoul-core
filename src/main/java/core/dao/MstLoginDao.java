package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstKaryawan;
import core.model.MstLogin;

public interface MstLoginDao extends JpaRepository<MstLogin, String> {
	@Query("select a, b.namaKaryawan from MstLogin a, MstKaryawan b where "
			+ "a.idKaryawan=b.idKaryawan")
	public List<Object[]> getAllLengkap();
	
	@Query("select a from MstLogin a")
	public List<Object> getAll();
	
	@Query("select a, b.namaKaryawan from MstLogin a, MstKaryawan b where "
			+ "a.idKaryawan = :kode and a.idKaryawan=b.idKaryawan")
	public MstLogin getOne(@Param("kode") String kode);
	
	@Query("select a from MstKaryawan a, MstLogin b where b.username=:user and b.password=:pass and a.idKaryawan=b.idKaryawan")
	public MstKaryawan login(@Param("user") String user, @Param("pass") String pass);
}
