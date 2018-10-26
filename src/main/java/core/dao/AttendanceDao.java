package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.Attendance;

public interface AttendanceDao extends JpaRepository<Attendance, String>{
	@Query("select a from Attendance a")
	public List<Object> getAll();
	
	@Query("select a, b.name, b.email from Attendance a, Users b where b.nik=:nik and a.nik=b.nik")
	public List<Object[]> searchUserAttendance(@Param("nik") String nik);
	
//	@Query("select a, b.namaSupplier, c.namaMerk, d.namaJenisBarang from MstBarang a, MstSupplier b, MstMerkBarang c, MstJenisBarang d where "
//			+ "upper(a.kodeBarang) like %:kode% and "
//			+ "a.kodeSupplier=b.kodeSupplier and a.kodeMerk=c.kodeMerk and a.kodeJenisBarang=d.kodeJenisBarang")
//	public List<Object[]> search(@Param("kode") String kode);
}
