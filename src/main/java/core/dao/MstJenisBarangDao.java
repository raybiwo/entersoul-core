package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstJenisBarang;

public interface MstJenisBarangDao extends JpaRepository<MstJenisBarang, String> {
	@Query("select a from MstJenisBarang a")
	public List<Object> getAll();
	
	@Query("select a from MstJenisBarang a where a.kodeJenisBarang = :kode")
	public MstJenisBarang getOne(@Param("kode") String kode);
	
	@Query("select a from MstJenisBarang a where a.kodeJenisBarang = :kode")
	public List<Object> getOneList(@Param("kode") String kode);
}
