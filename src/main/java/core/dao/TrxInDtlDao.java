package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.TrxInDtl;
import core.model.TrxInDtlPK;

public interface TrxInDtlDao extends JpaRepository<TrxInDtl, TrxInDtlPK> {
	@Query("select a, b.namaBarang from TrxInDtl a, MstBarang b, TrxInHdr c "
			+ "where a.kodeBarang=b.kodeBarang and a.noInvoice=c.noInvoice")
	public List<Object[]> getAllLengkap();
	
	@Query("select a, b.namaBarang from TrxInDtl a, MstBarang b, TrxInHdr c where "
			+ "c.noInvoice=:inv and "
			+ "a.noInvoice=c.noInvoice and "
			+ "a.kodeBarang=b.kodeBarang")
	public List<Object[]> getByInv(@Param("inv") String inv);

	@Query("select a from TrxInDtl a")
	public List<Object[]> getAll();

	@Query("select a, b.namaBarang from TrxInDtl a, MstBarang b, TrxInHdr c where "
			+ "a.kodeDetailMasuk=:kodedtl "
			+ "and a.noInvoice=:kodeinv "
			+ "and a.kodeBarang=:kodebrg "
			+ "and a.kodeBarang=b.kodeBarang "
			+ "and a.noInvoice=c.noInvoice")
	public List<Object[]> getOne(@Param("kodedtl") String kodedtl,
			@Param("kodeinv") String kodeinv, @Param("kodebrg") String kodebrg);
	
	@Modifying
	@Query("delete from TrxInDtl a where a.noInvoice=:inv")
	public int delete(@Param("inv") String inv);
}
 