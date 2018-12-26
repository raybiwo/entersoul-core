package core.dao;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.Attendance;

public interface AttendanceDao extends JpaRepository<Attendance, String>{
	@Query("select a from Attendance a")
	public List<Object> getAll();
	
	@Query("select a, b.name, b.mailAddress from Attendance a, Member b where a.nik=b.username")
	public List<Object[]> getAllWithMember();
	
	@Query("select a, b.name, b.mailAddress from Attendance a, Member b where a.nik=:nik and a.nik=b.username")
	public List<Object[]> getWithName(@Param("nik") String nik);
	
	@Query("select a "
			+ "from Attendance a where a.nik=:nik and a.attendanceDate LIKE '%'||:tanggal||'%'")
	public List<Object> searchUserAttendance(@Param("nik") String nik, @Param("tanggal") String tanggal);
	
	@Query("SELECT a FROM Attendance a WHERE a.nik=:nik and a.attendanceDate =:attendance")
	public List<Object> searchId(@Param("nik") String nik, @Param("attendance") String attendance);
	
	@Modifying
	@Query("UPDATE Attendance a SET a.checkin=:checkin,  a.longitude=:longitude,  a.latitude=:latitude WHERE a.id=:id")
	public Integer updateCheckin(@Param("checkin") Time checkin, 
			@Param("longitude") String longitude, 
			@Param("latitude") String latitude, 
			@Param("id") Integer id);
	
	@Modifying
	@Query("UPDATE Attendance a SET a.chekout=:checkin, a.longitude=:longitude, a.latitude=:latitude WHERE a.attendanceDate=:attendance and a.nik=:nik")
	public Integer updateCheckout(@Param("checkin") Time checkin, 
			@Param("longitude") String longitude, 
			@Param("latitude") String latitude, 
			@Param("attendance") String attendance,
			@Param("nik") String nik);
	
	@Modifying
	@Query("UPDATE Attendance a SET a.hours=:hours, a.activity=:activity WHERE a.attendanceDate=:attendance and a.nik=:nik")
	public Integer updateTimesheet(@Param("hours") String hours, 
			@Param("activity") String activity,
			@Param("attendance") String attendance,
			@Param("nik") String nik);
	
//	@Query("select a, b.namaSupplier, c.namaMerk, d.namaJenisBarang from MstBarang a, MstSupplier b, MstMerkBarang c, MstJenisBarang d where "
//			+ "upper(a.kodeBarang) like %:kode% and "
//			+ "a.kodeSupplier=b.kodeSupplier and a.kodeMerk=c.kodeMerk and a.kodeJenisBarang=d.kodeJenisBarang")
//	public List<Object[]> search(@Param("kode") String kode);
}
