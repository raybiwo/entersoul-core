package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import core.dao.KPITesterDao;
import core.dto.KPITesterDto;
import core.model.KPITester;
import core.service.KPITesterSvc;
import core.util.CommonConstants;
import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
public class KPITesterSvcImpl implements KPITesterSvc{

	@Autowired
	KPITesterDao kpitesterdao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<KPITesterDto> getAll() {
		// TODO Auto-generated method stub
		List<KPITesterDto> kpitesterDtos = new ArrayList<KPITesterDto>();
		List<Object> obj = kpitesterdao.getAll();
		
		kpitesterDtos = mapperFacade.mapAsList(obj, KPITesterDto.class);
		return kpitesterDtos;
	}

	@Override
	public int save(KPITesterDto isi) {
		// TODO Auto-generated method stub
		try {
			KPITester isimdl = mapperFacade.map(isi, KPITester.class);
			kpitesterdao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

}
