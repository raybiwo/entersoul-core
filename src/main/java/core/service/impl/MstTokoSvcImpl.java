package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstTokoDao;
import core.dto.MstTokoDto;
import core.model.MstToko;
import core.service.MstTokoSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstTokoSvcImpl implements MstTokoSvc {
	@Autowired
	MstTokoDao mstTokoDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<MstTokoDto> getOneList(String kode) {
		// TODO Auto-generated method stub
		List<MstTokoDto> mstTokoDtos = new ArrayList<MstTokoDto>();
		List<Object> obj = mstTokoDao.getOneList(kode);
		
		mstTokoDtos = mapperFacade.mapAsList(obj, MstTokoDto.class);
		return mstTokoDtos;
	}

	@Override
	public List<MstTokoDto> getAll() {
		// TODO Auto-generated method stub
		List<MstTokoDto> mstTokoDtos = new ArrayList<MstTokoDto>();
		List<Object> obj = mstTokoDao.getAll();
		
		mstTokoDtos = mapperFacade.mapAsList(obj, MstTokoDto.class);
		return mstTokoDtos;
	}

	@Override
	public MstTokoDto getOne(String kode) {
		// TODO Auto-generated method stub
		MstTokoDto dto = mapperFacade.map(mstTokoDao.getOne(kode), MstTokoDto.class);
		return dto;
	}

	@Override
	public int save(MstTokoDto isi) {
		// TODO Auto-generated method stub
		/*MstToko b = mstTokoDao.getOne(isi.getKodeToko());
		if (!(b==null)) {
			return 2;
		}*/try {
			MstToko isimdl = mapperFacade.map(isi, MstToko.class);
			mstTokoDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		MstToko b = mstTokoDao.getOne(kode);
		if (b==null) {
			return 2;
		} else {
			try {
				mstTokoDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}

}
