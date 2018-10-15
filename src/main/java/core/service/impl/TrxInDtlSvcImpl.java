package core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.TrxInDtlDao;
import core.dto.TrxInDtlDto;
import core.model.TrxInDtl;
import core.service.TrxInDtlSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class TrxInDtlSvcImpl implements TrxInDtlSvc {
	@Autowired
	TrxInDtlDao trxInDtlDao;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public Map<String, Object> getByInv(String inv) {
		// TODO Auto-generated method stub
		List<TrxInDtlDto> listInDtlDtos = new ArrayList<>();
		List<Object[]> qr = trxInDtlDao.getByInv(inv);
		
		for (Object[] obj : qr) {
			TrxInDtlDto trxInDtlDto = new TrxInDtlDto();
			TrxInDtl mdl = new TrxInDtl();
			mdl = (TrxInDtl) obj[0];
			
			trxInDtlDto = mapperFacade.map(mdl, TrxInDtlDto.class);
			trxInDtlDto.setNamaBarang((String) obj[1]);
			
			listInDtlDtos.add(trxInDtlDto);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("content", listInDtlDtos);
		map.put("jumlah", (long) listInDtlDtos.size());
		return map;
	}

	@Override
	public Map<String, Object> getAllLengkap() {
		// TODO Auto-generated method stub
		List<TrxInDtlDto> trxInDtlDtos = new ArrayList<>();
		List<Object[]> qr = trxInDtlDao.getAllLengkap();
		for (Object[] obj : qr) {
			TrxInDtlDto trxInDtlDto = new TrxInDtlDto();
			TrxInDtl mdl = new TrxInDtl();
			mdl = (TrxInDtl) obj[0];
			
			trxInDtlDto = mapperFacade.map(mdl, TrxInDtlDto.class);
			trxInDtlDto.setNamaBarang((String) obj[1]);
			trxInDtlDtos.add(trxInDtlDto);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("content", trxInDtlDtos);
		map.put("jumlah", (long) trxInDtlDtos.size());
		return map;
	}

	@Override
	public List<TrxInDtlDto> getAll() {
		// TODO Auto-generated method stub
		List<TrxInDtlDto> listTrxInDtlDto = new ArrayList<TrxInDtlDto>();
		List<Object[]> obj = trxInDtlDao.getAll();
		listTrxInDtlDto = mapperFacade.mapAsList(obj, TrxInDtlDto.class);
		return listTrxInDtlDto;
	}

	@Override
	public TrxInDtlDto getOne(String kodedtl, String kodeinv, String kodebrg) {
		// TODO Auto-generated method stub
		TrxInDtlDto trxInDtlDto = new TrxInDtlDto();
		List<Object[]> qr = trxInDtlDao.getOne(kodedtl, kodeinv, kodebrg);
		
		for (Object[] obj : qr) {
			TrxInDtl mdl = new TrxInDtl();
			mdl = (TrxInDtl) obj[0];
			trxInDtlDto = mapperFacade.map(mdl, TrxInDtlDto.class);
			trxInDtlDto.setNamaBarang((String) obj[1]);
		}
		
		return trxInDtlDto;
	}

	@Override
	public int save(TrxInDtlDto isi) {
		// TODO Auto-generated method stub
		try {
			TrxInDtl isimdl = mapperFacade.map(isi, TrxInDtl.class);
			trxInDtlDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String inv) {
		// TODO Auto-generated method stub
		int rs=1;
		try {
			trxInDtlDao.delete(inv);
			rs =0 ;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

}
