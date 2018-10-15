package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstBarangDao;
import core.dao.TrxInDtlDao;
import core.dao.TrxInHdrDao;
import core.dto.TrxInHdrDto;
import core.model.MstBarang;
import core.model.TrxInDtl;
import core.model.TrxInHdr;
import core.service.TrxInHdrSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class TrxInHdrSvcImpl implements TrxInHdrSvc {
	@Autowired
	TrxInHdrDao trxInHdrDao;
	
	@Autowired
	TrxInDtlDao trxInDtlDao;
	
	@Autowired
	MstBarangDao mstBarangDao;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public List<TrxInHdrDto> getOneList(String kode) {
		// TODO Auto-generated method stub
		List<TrxInHdrDto> trxInHdrDtos = new ArrayList<TrxInHdrDto>();
		List<Object[]> qr = trxInHdrDao.getOneList(kode);
		
		for (Object[] obj : qr) {
			TrxInHdrDto trxInHdrDto = new TrxInHdrDto();
			TrxInHdr mdl = new TrxInHdr();
			mdl = (TrxInHdr) obj[0];
			
			trxInHdrDto = mapperFacade.map(mdl, TrxInHdrDto.class);
			trxInHdrDto.setNamaSupplier((String) obj[1]);
			
			trxInHdrDtos.add(trxInHdrDto);
		}
		return trxInHdrDtos;
	}

	@Override
	public List<TrxInHdrDto> getAllLengkap() {
		// TODO Auto-generated method stub
		List<TrxInHdrDto> trxInHdrDtos = new ArrayList<>();
		
		List<Object[]> qr = trxInHdrDao.getAlllengkap();
		
		for (Object[] obj : qr) {
			TrxInHdrDto trxInHdrDto = new TrxInHdrDto();
			TrxInHdr mdl = new TrxInHdr();
			mdl = (TrxInHdr) obj[0];
			
			trxInHdrDto = mapperFacade.map(mdl, TrxInHdrDto.class);
			trxInHdrDto.setNamaSupplier((String) obj[1]);
			
			trxInHdrDtos.add(trxInHdrDto);
		}
		return trxInHdrDtos;
	}

	@Override
	public List<TrxInHdrDto> getAll() {
		// TODO Auto-generated method stub
		List<TrxInHdrDto> trxInHdrDtos = new ArrayList<TrxInHdrDto>();
		List<Object> obj = trxInHdrDao.getAll();
		
		trxInHdrDtos = mapperFacade.mapAsList(obj, TrxInHdrDto.class);
		return trxInHdrDtos;
	}

	@Override
	public TrxInHdrDto getOne(String kode) {
		// TODO Auto-generated method stub
		TrxInHdrDto dto = mapperFacade.map(trxInHdrDao.getOne(kode), TrxInHdrDto.class);
		return dto;
	}

	@Override
	public int save(TrxInHdrDto isi) {
		// TODO Auto-generated method stub
		try {
			TrxInHdr isiHdr =  mapperFacade.map(isi, TrxInHdr.class);
			List<TrxInDtl> isiMdlDtl = mapperFacade.mapAsList(isi.getDetail(), TrxInDtl.class);
			List<MstBarang> isiBrg = mapperFacade.mapAsList(isi.getBarang(), MstBarang.class);
			
			trxInHdrDao.save(isiHdr);
			trxInDtlDao.save(isiMdlDtl);
			mstBarangDao.save(isiBrg);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		TrxInHdr hdr = trxInHdrDao.getOne(kode);
		if (hdr==null) {
			return 2;
		} else {
			try {
				trxInHdrDao.delete(kode);
				trxInDtlDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}
}
