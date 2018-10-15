package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstToko;

public interface MstTokoDao extends JpaRepository<MstToko, String> {
	@Query("select a from MstToko a")
	public List<Object> getAll();
	
	@Query("select a from MstToko a where a.kodeToko = :kode")
	public MstToko getOne(@Param("kode") String kode);
	
	@Query("select a from MstToko a where a.kodeToko = :kode")
	public List<Object> getOneList(@Param("kode") String kode);
}
