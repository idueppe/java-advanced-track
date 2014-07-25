package io.crowdcode.scrumr.web.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("badWordValidator")
public class FacesBadWordValidator implements Validator
{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
	{
		String description = (String) value;
		if (description.toLowerCase().contains("php"))
		{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unglütig Beschreibung",
					"Wir machen keine PHP Projekt mehr!");
			throw new ValidatorException(message);
		}

	}

}
