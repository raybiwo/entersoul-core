package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstJob;

public interface MstJobDao extends JpaRepository<MstJob, String> {
	@Query("select a from MstJob a")
	public List<Object> getAll();
	
	@Query("select a from MstJob a where a.idJob = :idJob ")
	public MstJob getOne(@Param("idJob") String kode);
	
	@Query("select a from MstJob a where a.idJob = :idJob ")
	public List<Object> getOneList(@Param("idJob") String kode);
}
