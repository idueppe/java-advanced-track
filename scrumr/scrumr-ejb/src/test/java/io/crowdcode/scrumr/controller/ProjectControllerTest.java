package io.crowdcode.scrumr.controller;

import static io.crowdcode.scrumr.test.InjectionUtil.inject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import io.crowdcode.scrumr.converters.ProjectDtoConverter;
import io.crowdcode.scrumr.dao.ProjectDao;
import io.crowdcode.scrumr.dto.ProjectDto;
import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.model.User;
import io.crowdcode.scrumr.service.ProjectService;
import io.crowdcode.scrumr.service.ProjectServiceBean;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectControllerTest
{
	
	private ProjectControllerBean projectController = new ProjectControllerBean();
	
	private ProjectService projectService = new ProjectServiceBean();
	
	@Mock
	private ProjectDao projectDao;
	
	@Spy
	private ProjectDtoConverter converter;

	@Before
	public void setUp() {
//		MockitoAnnotations.initMocks(this);
		inject(projectService).into(projectController);
		inject(converter).into(projectController);
		inject(projectDao).into(projectService);
//		projectController.setProjectService(projectService);
//		projectController.setProjectDtoConveter(converter);
//		projectService.setProjectDao(projectDao);
	}
	
	@Test
	public void test_find_all_projects() throws Exception
	{
		final Project project = new Project().withScrumMaster(new User().withEmail("email"));
		when(projectDao.findAllProjects()).thenReturn(Arrays.asList(project));
		List<ProjectDto> result = projectController.findProjectsByEmail("email");
		assertThat(result, hasSize(1));
	}
	
}
