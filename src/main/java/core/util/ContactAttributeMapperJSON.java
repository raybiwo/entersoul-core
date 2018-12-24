package core.util;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import core.dto.LdapDto;

public class ContactAttributeMapperJSON implements AttributesMapper {

	public LdapDto mapFromAttributes(Attributes attributes) throws NamingException {
		// TODO Auto-generated method stub
		LdapDto ldap = new LdapDto();
		ldap.setEmail(attributes.get("mail").get().toString());
		ldap.setName(attributes.get("name").get().toString());
		ldap.setMobile(attributes.get("mobile").get().toString());
		ldap.setMailNickname(attributes.get("mailNickname").get().toString());
		return ldap;
	}
	
}
