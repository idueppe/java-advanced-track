package io.crowdcode.scrumr.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.crowdcode.ejb.service.Matches;
import io.crowdcode.scrumr.dao.ProjectDaoBean;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceBeanTest {

	@InjectMocks
	private ProjectServiceBean projectService;

	@Mock
	private ProjectDaoBean projectDaoBean;

	@Test
	public void test_with_answer_object_as_closure() {
		when(projectDaoBean.persistProject(any())).then(
				(invocation) -> {
					System.out.println("Mock:" + invocation.getMock());
					System.out.println("Method:" + invocation.getMethod());
					System.out.println("Argument:"
							+ Arrays.toString(invocation.getArguments()));
					return 2L;
				});

		projectService.createProjectWithId("Neues Projekt");

	}

	@Test
	public void test_with_custom_matcher_as_closure() throws Exception {
		when(projectDaoBean.persistProject(any())).thenReturn(1l);

		String title = "Neues Projekt";
		projectService.createProjectWithId(title);

		verify(projectDaoBean).persistProject(
			is((p) -> {return p.getTitle().equals(title);}));
	}

	public static <T> T is(final Matches<T> matches) {
		return argThat(new ArgumentMatcher<T>() {

			@Override
			@SuppressWarnings("unchecked")
			public boolean matches(Object argument) {
				return matches.matches((T) argument);
			}
		});
	}

	


}
