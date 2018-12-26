package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.KPIResultDao;
import core.dto.KPIResultDto;
import core.model.KPIResult;
import core.service.KPIResultSvc;
import core.util.CommonConstants;
import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
public class KPIResultSvcImpl implements KPIResultSvc{

	@Autowired
	KPIResultDao kpiresultdao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<KPIResultDto> getAll() {
		// TODO Auto-generated method stub
		List<KPIResultDto> kpiresultDtos = new ArrayList<KPIResultDto>();
		List<Object> obj = kpiresultdao.getAll();
		
		kpiresultDtos = mapperFacade.mapAsList(obj, KPIResultDto.class);
		return kpiresultDtos;
	}

	@Override
	public int save(KPIResultDto isi) {
		// TODO Auto-generated method stub
		try {
			KPIResult isimdl = mapperFacade.map(isi, KPIResult.class);
			kpiresultdao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

}
