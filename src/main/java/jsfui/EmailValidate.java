package jsfui;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("jsfui.EmailValidate")
public class EmailValidate implements Validator{

	private static final String REGEX="([a-zA-Z]+@+[a-zA-Z]+.com)?";

	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		if(!value.toString().matches(REGEX)){
			FacesMessage msg=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Email invalid","correct format is :abcd@domail.com");
		throw new ValidatorException(msg);
		}
	}

}
