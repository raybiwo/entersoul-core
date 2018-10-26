package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.UsersDao;
import core.dto.UsersDto;
import core.service.UsersSvc;
import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
public class UsersSvcImpl implements UsersSvc {
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public List<UsersDto> getAll() {
		// TODO Auto-generated method stub
		List<UsersDto> usersDtos = new ArrayList<UsersDto>();
		List<Object> obj = usersDao.getAll();
		
		usersDtos = mapperFacade.mapAsList(obj, UsersDto.class);
		return usersDtos;
	}
}
