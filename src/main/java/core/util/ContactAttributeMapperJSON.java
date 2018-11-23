package core.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.json.JSONObject;
import org.springframework.ldap.core.AttributesMapper;

import core.dto.LdapDto;

public class ContactAttributeMapperJSON implements AttributesMapper {

	public List<LdapDto> mapFromAttributes(Attributes attributes) throws NamingException {
		// TODO Auto-generated method stub
		NamingEnumeration<String> ids = attributes.getIDs();
		List<LdapDto> ldapDtos = new ArrayList<>();
		LdapDto ldap = new LdapDto();
		JSONObject jo = new JSONObject();
//		Map<String, Object> mapping = null;
//		String test = null;
//		int i = 0;
//		jo.put("mail", attributes.get("mail").get());
		ldap.setEmail(attributes.get("mail").get().toString());
		ldap.setName(attributes.get("name").get().toString());
		ldap.setMobile(attributes.get("mobile").get().toString());
		ldapDtos.add(ldap);
		System.out.println(ldapDtos.toString());
		
		return ldapDtos;
	}
	
}
