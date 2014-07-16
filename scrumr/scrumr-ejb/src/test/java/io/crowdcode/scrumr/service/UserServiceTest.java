package io.crowdcode.scrumr.service;

import static io.crowdcode.scrumr.test.TestUtils.with;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.InvalidUsernameException;
import io.crowdcode.scrumr.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Test
	public void testRegisterUser() throws Exception
	{
		String expectedId = "xyz123";
		// Arrange
		doAnswer(with(expectedId)).when(userDao).persist(any(User.class));
		String username = "junit_test_user";
		String email = "junit@junit.org";
		// Act
		String id = userService.registerUser(username, email);
		// Assert
		assertThat(id, is(expectedId));
		verify(userDao, times(1)).persist(any(User.class));
	}

	@Test(expected = InvalidUsernameException.class)
	public void testInvalidUsernameException() throws Exception
	{
		userService.registerUser("", "dsaf@dfsdf.com");
	}

}
