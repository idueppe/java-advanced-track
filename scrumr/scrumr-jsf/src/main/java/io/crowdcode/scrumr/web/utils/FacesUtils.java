package io.crowdcode.scrumr.web.utils;

import io.crowdcode.scrumr.exception.ApplicationException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils
{

	public static void addErrorMessage(ApplicationException e)
	{
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),e.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public static void addInfoMessage(final String msgSummary)
	{
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, msgSummary, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
