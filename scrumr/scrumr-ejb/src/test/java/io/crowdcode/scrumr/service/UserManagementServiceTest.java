package io.crowdcode.scrumr.service;

import static io.crowdcode.scrumr.test.TestUtils.withId;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.crowdcode.scrumr.dao.UserDao;
import io.crowdcode.scrumr.exception.EmailAlreadyExistException;
import io.crowdcode.scrumr.exception.EmptyNameException;
import io.crowdcode.scrumr.exception.InvalidEmailException;
import io.crowdcode.scrumr.exception.LastAdministorException;
import io.crowdcode.scrumr.exception.PasswordToShortException;
import io.crowdcode.scrumr.exception.UserNotFoundException;
import io.crowdcode.scrumr.model.User;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserManagementServiceTest
{

	@InjectMocks
	private UserManagementServiceBean userService;
	
	@Mock
	private UserDao userDao;
	
	@Captor
	private ArgumentCaptor<User> userCaptor;

	@Test
	public void test_that_a_user_can_be_register_if_data_is_valid() throws Exception
	{
		// arrange
		doAnswer(withId("abc123")).when(userDao).persist(any(User.class));

		// act
		String id = userService.registerUser("email@unit.org","name", "password",false);

		// assert
		assertThat(id, is("abc123"));
		verify(userDao,times(1)).persist(any(User.class));
	}
	
	@Test
	public void testUserProperties() throws Exception
	{
		// arrange
		final String email = "email@unit.org";
		final String name = "name";
		final String password = "password";
		final boolean isAdmin = false;
		// act
		userService.registerUser(email,name, password,isAdmin);
		// assert
		verify(userDao,times(1)).persist(userCaptor.capture());
		assertThat(userCaptor.getValue().getEmail(),is(email));
		assertThat(userCaptor.getValue().getFullname(),is(name));
		assertThat(userCaptor.getValue().getPassword(),is(password));
		assertThat(userCaptor.getValue().isAdmin(),is(isAdmin));
	}
	
	@Test(expected=InvalidEmailException.class)
	public void testInvalidEmail() throws Exception
	{
		userService.registerUser("invalid@email", "name", "password", false);
	}
	
	@Test(expected=EmailAlreadyExistException.class)
	public void testEmailAlreadyExists() throws Exception
	{
		when(userDao.findUserByEmail(anyString())).thenReturn(mock(User.class));
		userService.registerUser("email@unit.org", "name", "password", false);
	}
	
	@Test(expected=EmptyNameException.class)
	public void testEmptyNameException() throws Exception
	{
		userService.registerUser("user@unit.com", "  ", "password", false);
	}
	
	@Test(expected=PasswordToShortException.class)
	public void testPasswordToShortValidation() throws Exception
	{
		userService.registerUser("email@valid.com", "name", "shor", true);
	}
	
	@Test(expected=LastAdministorException.class)
	public void test_That_Removing_Last_Admin_Is_Not_Allowed() throws Exception
	{
		User admin = new User().withAdmin(true);
		when(userDao.findUserByEmail(anyString())).thenReturn(admin);
		when(userDao.findAdmins()).thenReturn(Arrays.asList(admin));

		userService.removeUser("email");
	}

	@Test
	public void testRemoveAnAdmin() throws Exception
	{
		User admin = new User().withAdmin(true);
		when(userDao.findUserByEmail(anyString())).thenReturn(admin);
		when(userDao.findAdmins()).thenReturn(Arrays.asList(admin, mock(User.class)));
		
		userService.removeUser("email");
	}
	
	
	@Test
	public void testRemoveUser() throws Exception
	{
		User admin = new User();
		when(userDao.findUserByEmail(anyString())).thenReturn(admin);

		userService.removeUser("email");
		
		verify(userDao, times(1)).remove(admin);
	}

	@Test(expected=UserNotFoundException.class)
	public void testRemoveUnknownUser() throws Exception
	{
		when(userDao.findUserByEmail(anyString())).thenReturn(null);
		userService.removeUser("email");
	}
	
	@Test(expected=LastAdministorException.class)
	public void testRemovingAdminRoleFromLastAdminIsNotAllowed() throws Exception {
		User admin = new User().withAdmin(true);
		when(userDao.findUserByEmail(anyString())).thenReturn(admin);
		when(userDao.findAdmins()).thenReturn(Arrays.asList(admin));
		
		userService.updateUser("id","name","password","email",false); 
	}
	
	@Test
	public void testGetUserList() throws Exception 
	{
		final User user = mock(User.class);
		when(userDao.findAllUsers()).thenReturn(Arrays.asList(user));
		
		List<User> users = userService.getUserList();
		
		verify(userDao, times(1)).findAllUsers();
		assertThat(users, hasItem(user));
	}

}
