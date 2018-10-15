package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstKaryawanDao;
import core.dto.MstKaryawanDto;
import core.model.MstKaryawan;
import core.service.MstKaryawanSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstKaryawanSvcImpl implements MstKaryawanSvc {
	@Autowired
	MstKaryawanDao mstKaryawanDao;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public List<MstKaryawanDto> getOneList(String kode) {
		// TODO Auto-generated method stub
		List<MstKaryawanDto> mstKaryawanDtos = new ArrayList<MstKaryawanDto>();
		List<Object> obj = mstKaryawanDao.getOneList(kode);
		
		mstKaryawanDtos = mapperFacade.mapAsList(obj, MstKaryawanDto.class);
		return mstKaryawanDtos;
	}

	@Override
	public List<MstKaryawanDto> getAll() {
		// TODO Auto-generated method stub
		List<MstKaryawanDto> mstKaryawanDtos = new ArrayList<MstKaryawanDto>();
		List<Object> obj = mstKaryawanDao.getAll();
		
		mstKaryawanDtos = mapperFacade.mapAsList(obj, MstKaryawanDto.class);
		return mstKaryawanDtos;
	}

	@Override
	public MstKaryawanDto getOne(String kode) {
		// TODO Auto-generated method stub
		MstKaryawanDto dto = mapperFacade.map(mstKaryawanDao.getOne(kode), MstKaryawanDto.class);
		return dto;
	}

	@Override
	public int save(MstKaryawanDto isi) {
		// TODO Auto-generated method stub
		/*MstKaryawan b = mstKaryawanDao.getOne(isi.getIdKaryawan());
		if (!(b==null)) {
			return 2;
		}*/
		try {
			MstKaryawan isimdl = mapperFacade.map(isi, MstKaryawan.class);
			mstKaryawanDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
 		} catch (Exception e) {
			// TODO: handle exception
 			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		MstKaryawan b = mstKaryawanDao.getOne(kode);
		if (b==null) {
			return 2;
		} else {
			try {
				mstKaryawanDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}
}
