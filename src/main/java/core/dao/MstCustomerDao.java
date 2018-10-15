package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstCustomer;

public interface MstCustomerDao extends JpaRepository<MstCustomer, String>{
	@Query("select a from MstCustomer a")
	public List<Object> getAll();
	
	@Query("select a from MstCustomer a where a.idCustomer =:kodecst ")
	public MstCustomer getOne(@Param("kodecst") String kode);
	
	@Query("select a from MstCustomer a where a.idCustomer =:kodecst")
	public List<Object> getOneList(@Param("kodecst") String kodecst);
}
