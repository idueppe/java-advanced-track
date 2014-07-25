package io.crowdcode.scrumr.web.validation;

import javax.faces.application.FacesMessage;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.validator.routines.EmailValidator;

@FacesValidator(value="emailValidator")
public class FacesEmailValidator implements Validator
{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
	{
		String email = value.toString();
		if (!EmailValidator.getInstance().isValid(email)) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, 
					"Email ist nicht valide.",
					"Die Email "+ email +" ist nicht korrekt.");
			throw new ValidatorException(message);
		}
		
	}

}
