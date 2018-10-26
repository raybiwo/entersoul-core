package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import core.model.Deployment;

public interface DeploymentDao extends JpaRepository<Deployment, Integer>{
	@Query("select a from Deployment a")
	public List<Object> getAll();
	
	@Query("select a from Deployment a where a.id =:id")
	public Deployment getOne(@Param("id") int id);
}
