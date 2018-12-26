package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import core.model.KPITester;

public interface KPITesterDao extends JpaRepository<KPITester, Integer>{

	@Query("select a from KPITester a")
	public List<Object> getAll();
	
}
