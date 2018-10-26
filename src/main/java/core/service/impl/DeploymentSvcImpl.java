package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.DeploymentDao;
import core.dto.DeploymentDto;
import core.model.Deployment;
import core.model.MstBarang;
import core.service.DeploymentSvc;
import core.util.CommonConstants;
import ma.glasnost.orika.MapperFacade;

@Service
@Transactional
public class DeploymentSvcImpl implements DeploymentSvc{

	@Autowired
	DeploymentDao deploymentDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<DeploymentDto> getAll() {
		// TODO Auto-generated method stub
		List<DeploymentDto> deploymentDtos = new ArrayList<DeploymentDto>();
		List<Object> obj = deploymentDao.getAll();
		
		deploymentDtos = mapperFacade.mapAsList(obj, DeploymentDto.class);
		return deploymentDtos;
	}

	@Override
	public int save(DeploymentDto isi) {
		// TODO Auto-generated method stub
		try {
			Deployment isimdl = mapperFacade.map(isi, Deployment.class);
			deploymentDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
//		Deployment b = deploymentDao.getOne(id);
//		System.out.println(b);
//		if(b==null){
//			return 2;
//		}
		try {
			deploymentDao.delete(id);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
				// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

}
