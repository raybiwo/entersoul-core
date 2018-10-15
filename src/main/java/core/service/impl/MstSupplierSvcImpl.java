package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstSupplierDao;
import core.dto.MstSupplierDto;
import core.model.MstSupplier;
import core.service.MstSupplierSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstSupplierSvcImpl implements MstSupplierSvc {
	@Autowired
	MstSupplierDao mstSupplierDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<MstSupplierDto> getOneList(String kode) {
		// TODO Auto-generated method stub
		List<MstSupplierDto> mstSupplierDtos = new ArrayList<MstSupplierDto>();
		List<Object> obj = mstSupplierDao.getOneList(kode);
		
		mstSupplierDtos = mapperFacade.mapAsList(obj, MstSupplierDto.class);
		return mstSupplierDtos;
	}

	@Override
	public List<MstSupplierDto> getAll() {
		// TODO Auto-generated method stub
		List<MstSupplierDto> mstSupplierDtos = new ArrayList<MstSupplierDto>();
		List<Object> obj = mstSupplierDao.getAll();
		
		mstSupplierDtos = mapperFacade.mapAsList(obj, MstSupplierDto.class);
		return mstSupplierDtos;
	}

	@Override
	public MstSupplierDto getOne(String kode) {
		// TODO Auto-generated method stub
		MstSupplierDto dto = mapperFacade.map(mstSupplierDao.getOne(kode), MstSupplierDto.class);
		return dto;
	}

	@Override
	public int save(MstSupplierDto isi) {
		// TODO Auto-generated method stub
		/*MstSupplier b = mstSupplierDao.getOne(isi.getKodeSupplier());
		if (!(b==null)) {
			return 2;
		}*/try {
			MstSupplier isimdl = mapperFacade.map(isi, MstSupplier.class);
			mstSupplierDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		MstSupplier b = mstSupplierDao.getOne(kode);
		if (b==null) {
			return 2;
		} else {
			try {
				mstSupplierDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}

}
