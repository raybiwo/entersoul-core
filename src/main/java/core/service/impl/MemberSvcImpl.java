package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MemberDao;
import core.dto.MemberDto;
import core.model.Member;
import core.service.MemberSvc;
import core.util.CommonConstants;
import ma.glasnost.orika.MapperFacade;


@Service
@Transactional
public class MemberSvcImpl implements MemberSvc {

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<MemberDto> getAll() {
		// TODO Auto-generated method stub
		List<MemberDto> memberDtos = new ArrayList<MemberDto>();
		List<Object> obj = memberDao.getAll();
		
		memberDtos = mapperFacade.mapAsList(obj, MemberDto.class);
		return memberDtos;
	}

	@Override
	public int save(MemberDto isi) {
		// TODO Auto-generated method stub
		try {
			Member isimdl = mapperFacade.map(isi, Member.class);
			memberDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		try {
			memberDao.delete(id);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
				// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}
	
}
