package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import core.model.Member;

public interface MemberDao extends JpaRepository<Member, Integer>{
	
	@Query("select a from Member a")
	public List<Object> getAll();
	
}
