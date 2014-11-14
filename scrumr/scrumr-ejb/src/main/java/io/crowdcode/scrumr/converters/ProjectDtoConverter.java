package io.crowdcode.scrumr.converters;

import io.crowdcode.scrumr.dto.ProjectDto;
import io.crowdcode.scrumr.model.Project;
import io.crowdcode.scrumr.model.User;

import javax.inject.Named;

@Named
public class ProjectDtoConverter extends AbstractDefaultConverter<Project, ProjectDto>
{

	@Override
	protected ProjectDto newTargetInstance()
	{
		return new ProjectDto();
	}

	@Override
	protected void copyProperties(Project source, ProjectDto target)
	{
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		
		if (source.getProductOwner() != null)
		{
			target.setProductOwnerMail(source.getProductOwner().getEmail());
		}
		
		if (source.getScrumMaster() != null)
		{
			target.setScrumMasterMail(source.getScrumMaster().getEmail());
		}

		if (source.getDevelopers() != null)
		{
			for (User user : source.getDevelopers())
			{
				target.getDeveloperMails().add(user.getEmail());
			}
		}
	}

}
