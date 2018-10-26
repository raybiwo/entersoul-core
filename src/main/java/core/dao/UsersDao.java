package core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import core.dto.UsersDto;
import core.model.Users;

public interface UsersDao extends JpaRepository<Users, String>{
	@Query("select a from Users a")
	public List<Object> getAll();
}
