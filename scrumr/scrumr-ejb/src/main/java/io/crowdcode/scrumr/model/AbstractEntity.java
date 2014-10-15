package io.crowdcode.scrumr.model;

import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

import org.apache.commons.lang3.StringUtils;

@MappedSuperclass
public class AbstractEntity implements Identifiable
{

	@Id
	private String id;

	@Version
	private Long version;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@PrePersist
	public void beforePersist()
	{
		if (StringUtils.isBlank(id)) {
			id = UUID.randomUUID().toString();
		}
	}

}
