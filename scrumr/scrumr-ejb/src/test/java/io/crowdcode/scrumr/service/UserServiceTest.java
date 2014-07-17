package io.crowdcode.scrumr.service;

import static io.crowdcode.scrumr.test.TestUtils.with;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.InvalidUsernameException;
import io.crowdcode.scrumr.exception.UsernameAlreadyExistException;
import io.crowdcode.scrumr.model.User;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest
{
	@InjectMocks
	private UserServiceBean userService;

	@Mock
	private UserDao userDao; // = Mockito.mock(UserDao.class);

	@Captor
	private ArgumentCaptor<User> userCaptor;

	@Test
	public void testRegisterUser() throws Exception
	{
		String expectedId = "EXPECTED-ID-UNITTEST";
		// Arrange
		doAnswer(with(expectedId)).when(userDao).persist(any(User.class));
		String username = "junit_test_user";
		String email = "junit@junit.org";
		// Act
		String id = userService.registerUser(username, email);
		// Assert
		assertThat(id, is(notNullValue()));
		assertThat(id, is(expectedId));
		verify(userDao, times(1)).persist(any(User.class));
	}

	@Test
	public void testThatUsernameAndEmailIsStored() throws Exception
	{
		final String email = "email";
		final String username = "username";

		userService.registerUser(username, email);

		// this is not a left indent test!!!!
		verify(userDao, times(1)).persist(argThat(new ArgumentMatcher<User>()
		{

			@Override
			public boolean matches(Object argument)
			{
				User user = (User) argument;
				return user.getEmail().equals(email) && user.getUsername().equals(username);
			}
		}));

	}

	@Test
	public void testUsernameAndEmailRegistration() throws Exception
	{
		String email = "email";
		String username = "username";

		userService.registerUser(username, email);

		verify(userDao).persist(userCaptor.capture());
		
		assertThat(userCaptor.getValue().getEmail(), is(email));
		assertThat(userCaptor.getValue().getUsername(), is(username));
		
		// or this way
		assertThat(userCaptor.getValue(), hasProperty("username", equalTo(username)));
		assertThat(userCaptor.getValue(), hasProperty("email", equalTo(email)));
	}

	@Test(expected = InvalidUsernameException.class)
	public void testInvalidUsernameException() throws Exception
	{
		userService.registerUser("", "dsaf@dfsdf.com");
	}
	
	@Test(expected = InvalidEmailException.class)
	public void testInvalidEmailException() throws Exception
	{
		userService.registerUser("sdads", "");
	}

	@Test(expected = UsernameAlreadyExistException.class)
	public void testUsernameAlreadyUsed() throws Exception
	{
		when(userDao.findUserByUsername(anyString())).thenReturn(new User());
		userService.registerUser("username", "unit@unit.com");
	}

	@Test(expected = EmailAlreadyExistException.class)
	public void testEmailAlreadyExists() throws Exception
	{
		when(userDao.findUserByEmail(anyString())).thenReturn(new User());
		userService.registerUser("username", "does@exist.com");
	}

	@Test
	public void testUsernameIsNeverNull()
	{
		List<String> usernames = userService.getUsernames();
		assertThat(usernames, is(notNullValue()));
	}

	@Test
	public void testUsernameContainsToUsernames()
	{
		// arrange
		List<User> userList = Arrays.asList( //
				new User().withUsername("username1"), // 
				new User().withUsername("username2")); //
		when(userDao.findAll()).thenReturn(userList);
		// act
		List<String> usernames = userService.getUsernames();
		// assert
		assertThat(usernames, is(notNullValue()));
		assertThat(usernames, hasItems("username1", "username2"));
	}

}
