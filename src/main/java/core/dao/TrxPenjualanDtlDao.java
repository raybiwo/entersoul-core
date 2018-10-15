package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.dto.TrxPenjualanDtlDto;
import core.model.TrxPenjualanDtl;
import core.model.TrxPenjualanDtlPK;

public interface TrxPenjualanDtlDao extends JpaRepository<TrxPenjualanDtl, TrxPenjualanDtlPK> {
	@Query("select a, b.namaBarang, c.kodeDetail, c.noNota from TrxPenjualanDtl a, MstBarang b, TrxOutDtl c "
			+ "where a.kodeBarang=b.kodeBarang and a.idDetail=c.kodeDetail")
	public List<Object[]> getAllLengkap();
	
	@Query("select a, b.namaBarang from TrxPenjualanDtl a, MstBarang b, TrxPenjualanHdr c where "
			+ "c.notaPenjualan=:nota and "
			+ "a.notaPenjualan=c.notaPenjualan and "
			+ "a.kodeBarang=b.kodeBarang")
	public List<Object[]> getByNota(@Param("nota") String nota);
	
	@Query("select a from TrxPenjualanDtl a where a.notaPenjualan=:nota")
	public List<TrxPenjualanDtlDto> getOneByNota(@Param("nota") String nota);

	@Query("select a from TrxPenjualanDtl a")
	public List<Object[]> getAll();

	@Query("select a, b.namaBarang, c.kodeDetail, c.noNota from TrxPenjualanDtl a, MstBarang b, TrxOutDtl c where "
			+ "a.idDetail=:id "
			+ "and a.kodeBarang=:kode "
			+ "and a.notaPenjualan=:nota "
			+ "and a.kodeBarang=b.kodeBarang "
			+ "and a.idDetail=c.kodeDetail")
	public List<Object[]> getOne(@Param("id") String id,
			@Param("kode") String kode, @Param("nota") String nota);
	
	@Modifying
	@Query("delete from TrxPenjualanDtl a where a.notaPenjualan=:nota")
	public int delete(@Param("nota") String nota);
}
