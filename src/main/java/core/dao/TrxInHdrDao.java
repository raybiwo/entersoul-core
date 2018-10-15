package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.TrxInHdr;

public interface TrxInHdrDao extends JpaRepository<TrxInHdr, String> {
	@Query("select a, b.namaSupplier from TrxInHdr a, MstSupplier b where "
			+ "a.kodeSupplier=b.kodeSupplier")
	public List<Object[]> getAlllengkap();
	
	@Query("select a from TrxInHdr a")
	public List<Object> getAll();
	
	@Query("select a from TrxInHdr a where a.noInvoice=:kode ")
	public TrxInHdr getOne(@Param("kode") String kodeinv);
	
	@Query("select a, b.namaSupplier from TrxInHdr a, MstSupplier b Where a.noInvoice=:kode and a.kodeSupplier=b.kodeSupplier")
	public List<Object[]> getOneList(@Param("kode") String kode);
}
