package io.crowdcode.scrumr.service;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
@Local(ProjectService.class)
@Remote(ProjectServiceRemote.class)
public class ProjectServiceBean implements ProjectServiceRemote{


}
