package core.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.transaction.Transactional;

import ma.glasnost.orika.MapperFacade;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Service;

import core.dao.MstLoginDao;
import core.dto.LdapDto;
import core.dto.MstKaryawanDto;
import core.dto.MstLoginDto;
import core.model.MstKaryawan;
import core.model.MstLogin;
import core.service.MstLoginSvc;
import core.util.CommonConstants;

@Service
@Transactional
public class MstLoginSvcImpl implements MstLoginSvc {
	@Autowired
	MstLoginDao mstLoginDao;
	
	@Autowired
	MapperFacade mapperFacade;	
	
	@Override
	public List<MstLoginDto> getAllLengkap() {
		// TODO Auto-generated method stub
		List<MstLoginDto> mstLoginDtos = new ArrayList<>();
		List<Object[]> qr = mstLoginDao.getAllLengkap();
		
		for (Object[] obj : qr) {
			MstLoginDto mstLoginDto = new MstLoginDto();
			MstLogin mdl = new MstLogin();
			mdl = (MstLogin) obj[0];
			
			mstLoginDto = mapperFacade.map(mdl, MstLoginDto.class);
			mstLoginDto.setNamaKaryawan((String) obj[1]);
			
			mstLoginDtos.add(mstLoginDto);
		}
		return mstLoginDtos;
	}

	@Override
	public List<MstLoginDto> getAll() {
		// TODO Auto-generated method stub
		List<MstLoginDto> mstLoginDtos = new ArrayList<MstLoginDto>();
		List<Object> obj = mstLoginDao.getAll();
		
		mstLoginDtos = mapperFacade.mapAsList(obj, MstLoginDto.class);
		return mstLoginDtos;
	}

	@Override
	public MstLoginDto getOne(String kode) {
		// TODO Auto-generated method stub
		
		MstLoginDto mstLoginDto = new MstLoginDto();
		MstLogin mstLogin = mstLoginDao.getOne(kode);
		
		mstLoginDto = mapperFacade.map(mstLogin, MstLoginDto.class);
		
		return mstLoginDto;
	}

	@Override
	public int save(MstLoginDto isi) {
		// TODO Auto-generated method stub
		MstLogin b = mstLoginDao.getOne(isi.getIdKaryawan());
		if (!(b==null)) {
			return 2;
		}
		try {
			MstLogin isimdl = mapperFacade.map(isi, MstLogin.class);
			mstLoginDao.save(isimdl);
			return CommonConstants.OK_REST_STATUS;
		} catch (Exception e) {
			// TODO: handle exception
			return CommonConstants.ERROR_REST_STATUS;
		}
	}

	@Override
	public int delete(String kode) {
		// TODO Auto-generated method stub
		MstLogin b = mstLoginDao.getOne(kode);
		if (b==null) {
			return 2;
		} else {
			try {
				mstLoginDao.delete(kode);
				return CommonConstants.OK_REST_STATUS;
			} catch (Exception e) {
				// TODO: handle exception
				return CommonConstants.ERROR_REST_STATUS;
			}
		}
	}
	
	@Override
	public MstKaryawanDto login(MstLoginDto login) {
		// TODO Auto-generated method stub
		MstKaryawanDto mstKaryawanDto = new MstKaryawanDto();
		MstKaryawan mstKaryawan = mstLoginDao.login(login.getUsername(), login.getPassword());
		mstKaryawanDto = mapperFacade.map(mstKaryawan, MstKaryawanDto.class);
		return mstKaryawanDto;
	}

	@Override
	public LdapDto loginLdap(MstLoginDto login) {
		// TODO Auto-generated method stub
		LdapContextSource ctxSrc = new LdapContextSource();
		ctxSrc.setUrl(CommonConstants.url);
		ctxSrc.setBase(CommonConstants.base);
		ctxSrc.setUserDn(CommonConstants.userDn);
		ctxSrc.setPassword(CommonConstants.password);
		String filter = "(&(objectCategory=Person)(sAMAccountName=*)(|"
				+ "(mail=ASP.ACHMADA@xl.co.id)"
				+ "(mail=ASP.ANDRIS@xl.co.id)"
				+ "(mail=Tubagusm@xl.co.id)"
				+ "(mail=XSIS.HAFIDZA@xl.co.id)"
				+ "(mail=XSIS.RACHMADI@xl.co.id)"
				+ "(mail=XSIS.ASTYAB@xl.co.id)"
				+ "(mail=ajin1@xl.co.id)"
				+ "(mail=xsis.hanifahtria@xl.co.id)"
				+ "(mail=XSIS.REINHARTBINSARH@xl.co.id)"
				+ "(mail=ASEPTAYUDA@xl.co.id)"
				+ "(mail=asp.jeffryl@xl.co.id)"
				+ "(mail=ASP.EDWINY@xl.co.id)"
				+ "(mail=ASP.LINAA@xl.co.id)"
				+ "(mail=ASP.WENDY@xl.co.id)"
				+ "(mail=TANKA.RIZKYY@xl.co.id)"
				+ "(mail=VIM.DENANDRAP@xl.co.id)"
				+ "(mail=XSIS.HENYS@xl.co.id)"
				+ "(mail=XSIS.JOSUAD@xl.co.id)"
				+ "(mail=TISNAK@xl.co.id)"
				+ "(mail=ASP.NICOR@xl.co.id)"
				+ "(|(manager=CN=Dyah Sulistyorini,OU=IT Development - Core,OU=Service Management,OU=Directorate,DC=intra,DC=excelcom,DC=co,DC=id)))(mailNickname="+login.getEmail()+"))";
        
		try {
			ctxSrc.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LdapTemplate lt = new LdapTemplate(ctxSrc);
		
		boolean autenticated = lt.authenticate(DistinguishedName.EMPTY_PATH, filter, login.getPassword());
		
		if (autenticated) {
			@SuppressWarnings("unchecked")
			List<LdapDto> list = lt.search("", filter,  new core.util.ContactAttributeMapperJSON());			
			return list.get(0);
		} else {
			return null;
		}	
	}
}
