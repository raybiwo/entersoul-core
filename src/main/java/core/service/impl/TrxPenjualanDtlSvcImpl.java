package core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.TrxPenjualanDtlDao;
import core.dto.TrxPenjualanDtlDto;
import core.model.TrxPenjualanDtl;
import core.service.TrxPenjualanDtlSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class TrxPenjualanDtlSvcImpl implements TrxPenjualanDtlSvc {
	@Autowired
	TrxPenjualanDtlDao trxPenjualanDtlDao;
	
	@Autowired
	MapperFacade mapperFacade;
	
	@Override
	public Map<String, Object> getByNota(String nota) {
		// TODO Auto-generated method stub
		List<TrxPenjualanDtlDto> listTrxPenjualanDtlDtos = new ArrayList<>();
		List<Object[]> qr = trxPenjualanDtlDao.getByNota(nota);
		
		for (Object[] obj : qr) {
			TrxPenjualanDtlDto trxPenjualanDtlDto = new TrxPenjualanDtlDto();
			TrxPenjualanDtl mdl = new TrxPenjualanDtl();
			mdl = (TrxPenjualanDtl) obj[0];
			
			trxPenjualanDtlDto = mapperFacade.map(mdl, TrxPenjualanDtlDto.class);
			trxPenjualanDtlDto.setNamaBarang((String) obj[1]);
			listTrxPenjualanDtlDtos.add(trxPenjualanDtlDto);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("content",	listTrxPenjualanDtlDtos);
		map.put("jumlah", (long) listTrxPenjualanDtlDtos.size());
		
		return map;
	}

	/*@Override
	public List<TrxPenjualanDtlDto> getOneByNota(String nota) {
		// TODO Auto-generated method stub
		List<TrxPenjualanDtlDto> trxPenjualanDtlDto = new ArrayList<>();
		List<TrxPenjualanDtlDto> listTrxPenjualanDtlDto = trxPenjualanDtlDao.getOneByNota(nota);
		
		for (TrxPenjualanDtlDto list : listTrxPenjualanDtlDto) {
		}
		return null;
	}*/

	@Override
	public Map<String, Object> getAllLengkap() {
		// TODO Auto-generated method stub
		List<TrxPenjualanDtlDto> trxPenjualanDtlDtos = new ArrayList<>();
		List<Object[]> qr = trxPenjualanDtlDao.getAllLengkap();
		
		for (Object[] obj : qr) {
			TrxPenjualanDtlDto trxPenjualanDtlDto = new TrxPenjualanDtlDto();
			TrxPenjualanDtl mdl = new TrxPenjualanDtl();
			mdl = (TrxPenjualanDtl) obj[0];
			
			trxPenjualanDtlDto = mapperFacade.map(mdl, TrxPenjualanDtlDto.class);
			trxPenjualanDtlDto.setNamaBarang((String) obj[1]);
			trxPenjualanDtlDto.setKodeDetail((String) obj[2]);
			trxPenjualanDtlDto.setIdDetail((String) obj[3]);
			trxPenjualanDtlDto.setNoNota((String) obj[3]);
			trxPenjualanDtlDtos.add(trxPenjualanDtlDto);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("content", trxPenjualanDtlDtos);
		map.put("jumlah", (long) trxPenjualanDtlDtos.size());
		return map;
	}

	@Override
	public List<TrxPenjualanDtlDto> getAll() {
		// TODO Auto-generated method stub
		List<TrxPenjualanDtlDto> listTrxPenjualanDtlDto = new ArrayList<TrxPenjualanDtlDto>();
		List<Object[]> obj = trxPenjualanDtlDao.getAll();
		listTrxPenjualanDtlDto = mapperFacade.mapAsList(obj, TrxPenjualanDtlDto.class);
		return listTrxPenjualanDtlDto;
	}

	@Override
	public TrxPenjualanDtlDto getOne(String id, String kode, String nota) {
		// TODO Auto-generated method stub
		TrxPenjualanDtlDto trxPenjualanDtlDto  = new TrxPenjualanDtlDto();
		List<Object[]> qr = trxPenjualanDtlDao.getOne(id, kode, nota);
		
		for (Object[] obj : qr) {
			TrxPenjualanDtl mdl = new TrxPenjualanDtl();
			mdl = (TrxPenjualanDtl) obj[0];
			trxPenjualanDtlDto = mapperFacade.map(mdl, TrxPenjualanDtlDto.class);
			trxPenjualanDtlDto.setNamaBarang((String) obj[1]);
			trxPenjualanDtlDto.setKodeDetail((String) obj[2]);
			trxPenjualanDtlDto.setIdDetail((String) obj[3]);
			trxPenjualanDtlDto.setNoNota((String) obj[3]);
		}
		return trxPenjualanDtlDto;
	}

	@Override
	public int save(TrxPenjualanDtlDto isi) {
		// TODO Auto-generated method stub
		try {
			TrxPenjualanDtl isimdl = mapperFacade.map(isi, TrxPenjualanDtl.class);
			trxPenjualanDtlDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;			
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String nota) {
		// TODO Auto-generated method stub
		int rs=1;
		try {
			trxPenjualanDtlDao.delete(nota);
			rs =0 ;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
}
