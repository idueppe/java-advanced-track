package io.crowdcode.scrumr.dao;

import io.crowdcode.scrumr.service.ProjectService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
@Local(ProjectService.class)
public class ProjectDaoBean {

}
