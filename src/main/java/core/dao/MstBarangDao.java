package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.MstBarang;

public interface MstBarangDao extends JpaRepository<MstBarang, String>{
	@Query("select a, b.namaSupplier, c.namaMerk, d.namaJenisBarang from MstBarang a, MstSupplier b, MstMerkBarang c, MstJenisBarang d where "
			+ "a.kodeSupplier = b.kodeSupplier and a.kodeMerk=c.kodeMerk and a.kodeJenisBarang=d.kodeJenisBarang")
	public List<Object[]> getAllLengkap();
	
	@Query("select a from MstBarang a")
	public List<Object> getAll();
	
	@Query("select a, b.namaSupplier, c.namaMerk, d.namaJenisBarang from MstBarang a, MstSupplier b, MstMerkBarang c, MstJenisBarang d where "
			+ "upper(a.kodeBarang) like %:kode% and "
			+ "a.kodeSupplier=b.kodeSupplier and a.kodeMerk=c.kodeMerk and a.kodeJenisBarang=d.kodeJenisBarang")
	public List<Object[]> search(@Param("kode") String kode);
	
	@Query("select a, b.namaSupplier from MstBarang a, MstSupplier b where a.kodeBarang =:kodebrg and a.kodeSupplier = b.kodeSupplier")
	public List<Object[]> getOneList(@Param("kodebrg") String kode);
	
	@Query("select a, b.namaSupplier from MstBarang a, MstSupplier b where a.kodeBarang =:kodebrg and a.kodeSupplier = b.kodeSupplier")
	public MstBarang getOne(@Param("kodebrg") String kode);
}
