package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstMerkBarangDao;
import core.dto.MstMerkBarangDto;
import core.model.MstMerkBarang;
import core.service.MstMerkBarangSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstMerkBarangSvcImpl implements MstMerkBarangSvc {
	@Autowired
	MstMerkBarangDao mstMerkBarangDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public List<MstMerkBarangDto> getOneList(String kode) {
		// TODO Auto-generated method stub
		List<MstMerkBarangDto> mstMerkBarangDtos = new ArrayList<MstMerkBarangDto>();
		List<Object> obj = mstMerkBarangDao.getOneList(kode);
		
		mstMerkBarangDtos = mapperFacade.mapAsList(obj, MstMerkBarangDto.class);
		return mstMerkBarangDtos;
	}

	@Override
	public List<MstMerkBarangDto> getAll() {
		// TODO Auto-generated method stub
		List<MstMerkBarangDto> mstMerkBarangDtos = new ArrayList<MstMerkBarangDto>();
		List<Object> obj = mstMerkBarangDao.getAll();
		
		mstMerkBarangDtos = mapperFacade.mapAsList(obj, MstMerkBarangDto.class);
		return mstMerkBarangDtos;
	}

	@Override
	public MstMerkBarangDto getOne(String kode) {
		// TODO Auto-generated method stub
		MstMerkBarangDto dto = mapperFacade.map(mstMerkBarangDao.getOne(kode), MstMerkBarangDto.class);
		return dto;
	}

	@Override
	public int save(MstMerkBarangDto isi) {
		// TODO Auto-generated method stub
		/*MstMerkBarang b = mstMerkBarangDao.getOne(isi.getKodeMerk());
		if (!(b==null)) {
			return 2;
		}*/
		try {
			MstMerkBarang isimdl = mapperFacade.map(isi, MstMerkBarang.class);
			mstMerkBarangDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		MstMerkBarang b = mstMerkBarangDao.getOne(kode);
		if (b==null) {
			return 2;
		} else {
			try {
				mstMerkBarangDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}
}
