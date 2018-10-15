package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstJenisBarangDao;
import core.dto.MstJenisBarangDto;
import core.model.MstJenisBarang;
import core.service.MstJenisBarangSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstJenisBarangSvcImpl implements MstJenisBarangSvc {
	@Autowired
	MstJenisBarangDao mstJenisBarangDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<MstJenisBarangDto> getOneList(String kode) {
		// TODO Auto-generated method stub
		List<MstJenisBarangDto> mstJenisBarangDtos = new ArrayList<MstJenisBarangDto>();
		List<Object> obj = mstJenisBarangDao.getOneList(kode);
		
		mstJenisBarangDtos = mapperFacade.mapAsList(obj, MstJenisBarangDto.class);
		return mstJenisBarangDtos;
	}

	@Override
	public List<MstJenisBarangDto> getAll() {
		// TODO Auto-generated method stub
		List<MstJenisBarangDto> mstJenisBarangDtos = new ArrayList<MstJenisBarangDto>();
		List<Object> obj = mstJenisBarangDao.getAll();
		
		mstJenisBarangDtos = mapperFacade.mapAsList(obj, MstJenisBarangDto.class);
		return mstJenisBarangDtos;
	}

	@Override
	public MstJenisBarangDto getOne(String kode) {
		// TODO Auto-generated method stub
		MstJenisBarangDto dto = mapperFacade.map(mstJenisBarangDao.getOne(kode), MstJenisBarangDto.class);
		return dto;
	}

	@Override
	public int save(MstJenisBarangDto isi) {
		// TODO Auto-generated method stub
		MstJenisBarang b = mstJenisBarangDao.getOne(isi.getKodeJenisBarang());
		if (!(b==null)) {
			return 2;
		}
		try {
			MstJenisBarang isimdl = mapperFacade.map(isi, MstJenisBarang.class);
			mstJenisBarangDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		MstJenisBarang b = mstJenisBarangDao.getOne(kode);
		if (b==null) {
			return 2;
		} else {
			try {
				mstJenisBarangDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}
}
