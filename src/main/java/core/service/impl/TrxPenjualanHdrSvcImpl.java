package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstBarangDao;
import core.dao.TrxPenjualanDtlDao;
import core.dao.TrxPenjualanHdrDao;
import core.dto.TrxPenjualanHdrDto;
import core.model.MstBarang;
import core.model.TrxPenjualanDtl;
import core.model.TrxPenjualanHdr;
import core.service.TrxPenjualanHdrSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class TrxPenjualanHdrSvcImpl implements TrxPenjualanHdrSvc {
	@Autowired
	TrxPenjualanHdrDao trxPenjualanHdrDao;
	
	@Autowired
	TrxPenjualanDtlDao trxPenjualanDtlDao;
	
	@Autowired
	MstBarangDao mstBarangDao;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public List<TrxPenjualanHdrDto> getOneList(String nota) {
		// TODO Auto-generated method stub
		List<TrxPenjualanHdrDto> trxPenjualanHdrDtos = new ArrayList<TrxPenjualanHdrDto>();
		List<Object> obj = trxPenjualanHdrDao.getOneList(nota);
		
		trxPenjualanHdrDtos = mapperFacade.mapAsList(obj, TrxPenjualanHdrDto.class);
		return trxPenjualanHdrDtos;
	}

	@Override
	public List<TrxPenjualanHdrDto> getAllLengkap() {
		// TODO Auto-generated method stub
		List<TrxPenjualanHdrDto> trxPenjualanHdrDtos = new ArrayList<>();
		
		List<Object[]> qr = trxPenjualanHdrDao.getAllLengkap();
		
		for (Object[] obj : qr) {
			TrxPenjualanHdrDto trxPenjualanHdrDto = new TrxPenjualanHdrDto();
			TrxPenjualanHdr mdl = new TrxPenjualanHdr();
			mdl = (TrxPenjualanHdr) obj[0];
			
			trxPenjualanHdrDto = mapperFacade.map(mdl, TrxPenjualanHdrDto.class);
			trxPenjualanHdrDto.setNamaKaryawan((String) obj[1]);
			
			trxPenjualanHdrDtos.add(trxPenjualanHdrDto);
		}
		return trxPenjualanHdrDtos;
	}

	@Override
	public List<TrxPenjualanHdrDto> getAll() {
		// TODO Auto-generated method stub
		List<TrxPenjualanHdrDto> trxPenjualanHdrDtos = new ArrayList<TrxPenjualanHdrDto>();
		List<Object> obj = trxPenjualanHdrDao.getAll();
		
		trxPenjualanHdrDtos = mapperFacade.mapAsList(obj, TrxPenjualanHdrDto.class);
		return trxPenjualanHdrDtos;
	}

	@Override
	public TrxPenjualanHdrDto getOne(String nota) {
		// TODO Auto-generated method stub
		TrxPenjualanHdrDto dto = mapperFacade.map(trxPenjualanHdrDao.getOne(nota), TrxPenjualanHdrDto.class);
		return dto;
	}

	@Override
	public int save(TrxPenjualanHdrDto isi) {
		// TODO Auto-generated method stub
		try {
			TrxPenjualanHdr isiMdlHdr = mapperFacade.map(isi, TrxPenjualanHdr.class);
			List<TrxPenjualanDtl> isiMdlDtl = mapperFacade.mapAsList(isi.getDetail(), TrxPenjualanDtl.class);
			List<MstBarang> isiMdlBrg = mapperFacade.mapAsList(isi.getBarang(), MstBarang.class);
			
			trxPenjualanHdrDao.save(isiMdlHdr);
			trxPenjualanDtlDao.save(isiMdlDtl);
			mstBarangDao.save(isiMdlBrg);
			
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String nota) {
		// TODO Auto-generated method stub
		TrxPenjualanHdr hdr = trxPenjualanHdrDao.getOne(nota);
		System.out.println(hdr);
		if(hdr==null){
			return 2;
		}
		else{
			try {
				trxPenjualanHdrDao.delete(nota);
				trxPenjualanDtlDao.delete(nota);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}
}
