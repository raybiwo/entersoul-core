package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.dao.MstCustomerDao;
import core.dto.MstCustomerDto;
import core.model.MstCustomer;
import core.service.MstCustomerSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstCustomerSvcImpl implements MstCustomerSvc {
	@Autowired
	MstCustomerDao mstCustomerDao;
	
	@Autowired
	MapperFacade mapperFacade;

	@Override
	public List<MstCustomerDto> getOneList(String kodecst) {
		// TODO Auto-generated method stub
		List<MstCustomerDto> mstCustomerDtos = new ArrayList<MstCustomerDto>();
		List<Object> obj = mstCustomerDao.getOneList(kodecst);
		
		mstCustomerDtos = mapperFacade.mapAsList(obj, MstCustomerDto.class);
		return mstCustomerDtos;
	}

	@Override
	public List<MstCustomerDto> getAll() {
		// TODO Auto-generated method stub
		List<MstCustomerDto> mstCustomerDtos = new ArrayList<MstCustomerDto>();
		List<Object> obj = mstCustomerDao.getAll();
		
		mstCustomerDtos = mapperFacade.mapAsList(obj, MstCustomerDto.class);
		return mstCustomerDtos;
	}

	@Override
	public MstCustomerDto getOne(String kode) {
		// TODO Auto-generated method stub
		MstCustomerDto dto = mapperFacade.map(mstCustomerDao.getOne(kode), MstCustomerDto.class);
		return dto;
	}

	@Override
	public int save(MstCustomerDto isi) {
		// TODO Auto-generated method stub
		/*MstCustomer b = mstCustomerDao.getOne(isi.getIdCustomer());
		if(!(b==null)){
			return 2;
		}*/
		try {
			MstCustomer isimdl = mapperFacade.map(isi, MstCustomer.class);
			mstCustomerDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		MstCustomer b = mstCustomerDao.getOne(id);
		if (b==null) {
			return 2;
		} else {
			try {
				mstCustomerDao.delete(id);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		} 
	}

}
