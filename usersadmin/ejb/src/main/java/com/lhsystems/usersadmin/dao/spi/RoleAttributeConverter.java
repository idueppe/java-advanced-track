package com.lhsystems.usersadmin.dao.spi;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.lhsystems.usersadmin.domain.Role;

@Converter(autoApply = true)
public class RoleAttributeConverter implements
		AttributeConverter<Role, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Role attribute) {
		if (attribute == Role.ADMIN)
			return 1;
		else if (attribute == Role.USER)
			return 2;
		else
			return null;
	}

	@Override
	public Role convertToEntityAttribute(Integer dbData) {
		if (dbData == null)
			return null;
		else if (dbData == 1)
			return Role.ADMIN;
		else if (dbData == 2)
			return Role.USER;
		return null;
	}

}
