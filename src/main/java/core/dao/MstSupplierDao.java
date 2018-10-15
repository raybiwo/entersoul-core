package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstSupplier;

public interface MstSupplierDao extends JpaRepository<MstSupplier, String> {
	@Query("select a from MstSupplier a")
	public List<Object> getAll();
	
	@Query("select a from MstSupplier a where a.kodeSupplier = :kode")
	public MstSupplier getOne(@Param("kode") String kode);
	
	@Query("select a from MstSupplier a where a.kodeSupplier = :kode")
	public List<Object> getOneList(@Param("kode") String kode);
}
