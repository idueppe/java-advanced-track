package io.crowdcode.scrumr.converters;

import io.crowdcode.scrumr.dto.UserDto;
import io.crowdcode.scrumr.model.User;

import javax.inject.Named;

@Named
public class UserDtoConverter extends AbstractDefaultConverter<User,UserDto>
{

	@Override
	protected UserDto newTargetInstance()
	{
		return new UserDto();
	}

	@Override
	protected void copyProperties(User source, UserDto target)
	{
		target.setId(source.getId());
		target.setEmail(source.getEmail());
		target.setAdmin(source.isAdmin());
		target.setFullname(source.getFullname());
		target.setPassword("bekommst du nicht!");
	}

}
