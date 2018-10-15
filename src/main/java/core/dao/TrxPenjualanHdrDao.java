package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.TrxPenjualanHdr;

public interface TrxPenjualanHdrDao extends JpaRepository<TrxPenjualanHdr, String> {
	@Query("select a, b.namaKaryawan from TrxPenjualanHdr a, MstKaryawan b where "
			+ "a.idKaryawan=b.idKaryawan")
	public List<Object[]> getAllLengkap();
	
	@Query("select a from TrxPenjualanHdr a")
	public List<Object> getAll();
	
	@Query("select a from TrxPenjualanHdr a Where a.notaPenjualan=:nota")
	public List<Object> getOneList(@Param("nota") String nota);

	@Query("select a from TrxPenjualanHdr a Where a.notaPenjualan=:nota")
	public TrxPenjualanHdr getOne(@Param("nota") String nota);
}
