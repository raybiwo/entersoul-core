package core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstBarangDao;
import core.dto.MstBarangDto;
import core.model.MstBarang;
import core.service.MstBarangSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstBarangSvcImpl implements MstBarangSvc {
	@Autowired
	MstBarangDao mstBarangDao;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public List<MstBarangDto> search(String kode) {
		// TODO Auto-generated method stub
		List<MstBarangDto> mstBarangDtos = new ArrayList<MstBarangDto>();
		System.out.println("====================================service impl========================================" + kode);
		
		
		List<Object[]> qr = mstBarangDao.search(kode);
		
		for (Object[] obj : qr) {
			MstBarangDto mstBarangDto = new MstBarangDto();
			MstBarang mdl = new MstBarang();
			mdl = (MstBarang) obj[0];
			
			mstBarangDto = mapperFacade.map(mdl, MstBarangDto.class);
			mstBarangDto.setNamaSupplier((String) obj[1]);
			mstBarangDto.setNamaMerk((String) obj[2]);
			mstBarangDto.setNamaJenisBarang((String) obj[3]);
			
			mstBarangDtos.add(mstBarangDto);
		}
		return mstBarangDtos;
	}

	@Override
	public MstBarangDto findOne(String kode) {
		// TODO Auto-generated method stub
		MstBarangDto dto = mapperFacade.map(mstBarangDao.findOne(kode), MstBarangDto.class);
		return dto;
	}

	@Override
	public Map<String, Object> getAllLengkap() {
		// TODO Auto-generated method stub
		List<MstBarangDto> mstBarangDtos = new ArrayList<>();
		
		List<Object[]> qr = mstBarangDao.getAllLengkap();
		
		for (Object[] obj : qr) {
			MstBarangDto mstBarangDto = new MstBarangDto();
			MstBarang mdl = new MstBarang();
			mdl = (MstBarang) obj[0];
			
			mstBarangDto = mapperFacade.map(mdl, MstBarangDto.class);
			mstBarangDto.setNamaSupplier((String) obj[1]);
			mstBarangDto.setNamaMerk((String) obj[2]);
			mstBarangDto.setNamaJenisBarang((String) obj[3]);
			
			mstBarangDtos.add(mstBarangDto);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("content", mstBarangDtos);
		map.put("jumlah", (long) mstBarangDtos.size());
		return map;
	}


	@Override
	public List<MstBarangDto> getOneList(String kode) {
		// TODO Auto-generated method stub
		List<MstBarangDto> listBrg = new ArrayList<>();
		List<Object[]> qr = mstBarangDao.getOneList(kode);
		
		for (Object[] obj : qr) {
			MstBarangDto mstBarangDto = new MstBarangDto();
			MstBarang mdl = new MstBarang();
			mdl = (MstBarang) obj[0];
			
			mstBarangDto =  mapperFacade.map(mdl, MstBarangDto.class);
			mstBarangDto.setNamaSupplier((String) obj[1]);
			
			listBrg.add(mstBarangDto);
 		}
		/*
		MstBarangDto dto = mapperFacade.map(mstBarangDao.getOne(kode), MstBarangDto.class);
		
		listBrg.add(dto);*/
		return listBrg;
	}

	@Override
	public List<MstBarangDto> getAll() {
		// TODO Auto-generated method stub
		List<MstBarangDto> mstBarangDtos = new ArrayList<MstBarangDto>();
		List<Object> obj = mstBarangDao.getAll();
		
		mstBarangDtos = mapperFacade.mapAsList(obj, MstBarangDto.class);
		return mstBarangDtos;
	}

	@Override
	public MstBarangDto getOne(String kode) {
		// TODO Auto-generated method stub
		MstBarangDto dto = mapperFacade.map(mstBarangDao.getOne(kode), MstBarangDto.class);
		return dto;
	}

	@Override
	public int save(MstBarangDto isi) {
		// TODO Auto-generated method stub
		/*MstBarang b = mstBarangDao.getOne(isi.getKodeBarang());
		if(!(b==null)){
			return 2;
		}*/
		try {
			MstBarang isimdl = mapperFacade.map(isi, MstBarang.class);
			mstBarangDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}
	
	@Override
	public int savelist(List<MstBarangDto> listisi) {
		// TODO Auto-generated method stub
		/*MstBarang b = mstBarangDao.getOne(isi.getKodeBarang());
		if(!(b==null)){
			return 2;
		}*/
		try {
			for(MstBarangDto brg : listisi){
				MstBarang isimdl = mapperFacade.map(brg, MstBarang.class);
				mstBarangDao.save(isimdl);
			}
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		MstBarang b = mstBarangDao.getOne(kode);
		System.out.println(b);
		if(b==null){
			return 2;
		}
		else{
			try {
				mstBarangDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}
}
