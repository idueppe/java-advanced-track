package com.lhsystems.usersadmin.dao.spi;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lhsystems.usersadmin.domain.Role;

@RunWith(Parameterized.class)
public class RoleAttributeConverterTest {

	private RoleAttributeConverter converter = new RoleAttributeConverter();

	@Parameters(name = "Checking {0}")
	public static Collection<Object[]> data() {
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[]{null});
		for (Role role : EnumSet.allOf(Role.class))
			params.add(new Object[] { role });
		return params;
	}

	public RoleAttributeConverterTest(Role role) {
		this.role = role;
	}

	private Role role;

	@Test
	public void testConverter() {
		assertEquals(role, //
			converter.convertToEntityAttribute( //
				converter.convertToDatabaseColumn(role)));

	}

}
