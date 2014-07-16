package io.crowdcode.scrumr.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest
{
	@InjectMocks
	private UserServiceBean userService;

	@Test
	public void testRegisterUser() throws Exception
	{
		// Arrage
		String username = "junit_test_user";
		String email = "junit@junit.org";
		// Act
		String id = userService.registerUser(username, email);
		// Assert
		assertThat(id, is(notNullValue()));
	}
	
}
