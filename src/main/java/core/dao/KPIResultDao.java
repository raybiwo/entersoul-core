package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import core.model.KPIResult;

public interface KPIResultDao extends JpaRepository<KPIResult, Integer>{

	@Query("select a from KPIResult a")
	public List<Object> getAll();
}
