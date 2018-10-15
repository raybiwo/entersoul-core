package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstJobDao;
import core.dto.MstJobDto;
import core.model.MstJob;
import core.service.MstJobSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstJobSvcImpl implements MstJobSvc {
	@Autowired
	MstJobDao mstJobDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<MstJobDto> getOneList(String kode) {
		// TODO Auto-generated method stub
		List<MstJobDto> mstJobDtos = new ArrayList<MstJobDto>();
		List<Object> obj = mstJobDao.getOneList(kode);
		
		mstJobDtos  = mapperFacade.mapAsList(obj, MstJobDto.class);
		return mstJobDtos;
	}

	@Override
	public List<MstJobDto> getAll() {
		// TODO Auto-generated method stub
		List<MstJobDto> mstJobDtos = new ArrayList<MstJobDto>();
		List<Object> obj = mstJobDao.getAll();
		
		mstJobDtos  = mapperFacade.mapAsList(obj, MstJobDto.class);
		return mstJobDtos;
	}

	@Override
	public MstJobDto getOne(String kode) {
		// TODO Auto-generated method stub
		MstJobDto dto = mapperFacade.map(mstJobDao.getOne(kode), MstJobDto.class);
		return dto;
	}

	@Override
	public int save(MstJobDto isi) {
		// TODO Auto-generated method stub
/*		MstJob b = mstJobDao.getOne(isi.getIdJob());
		if(!(b==null)){
			return 2;
		}*/
		try {
			MstJob isimdl = mapperFacade.map(isi, MstJob.class);
			mstJobDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		MstJob b = mstJobDao.getOne(kode);
		if (b==null) {
			return 2;
		} else {
			try {
				mstJobDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}

		}
	}

}
