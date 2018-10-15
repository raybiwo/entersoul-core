package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstMerkBarang;

public interface MstMerkBarangDao extends JpaRepository<MstMerkBarang, String> {
	@Query("select a from MstMerkBarang a")
	public List<Object> getAll();
	
	@Query("select a from MstMerkBarang a where a.kodeMerk = :kode")
	public MstMerkBarang getOne(@Param("kode") String kode);
	
	@Query("select a from MstMerkBarang a where a.kodeMerk = :kode")
	public List<Object> getOneList(@Param("kode") String kode);
}
