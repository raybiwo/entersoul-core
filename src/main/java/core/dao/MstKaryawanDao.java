package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstKaryawan;

public interface MstKaryawanDao extends JpaRepository<MstKaryawan, String> {
	@Query("select a from MstKaryawan a")
	public List<Object> getAll();
	
	@Query("select a from MstKaryawan a where a.idKaryawan= :id")
	public MstKaryawan getOne(@Param("id") String kode);
	
	@Query("select a from MstKaryawan a where a.idKaryawan= :id")
	public List<Object> getOneList(@Param("id") String kode);
}
