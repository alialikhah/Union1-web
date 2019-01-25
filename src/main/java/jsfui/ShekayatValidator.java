package jsfui;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator(value="shekayatValidator")
public class ShekayatValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			Part file=(Part) value;	
			 FacesMessage message=null;
			 
		        try {
		        	 
		            if (file==null || file.getSize()<=0 || file.getContentType().isEmpty() )
		                message=new FacesMessage("Select a valid file");
		            else if ((!file.getContentType().equals("image/jpeg"))&(!file.getContentType().equals("image/png"))) {
		            	System.err.println(file.getContentType().toString());
		            	message= new FacesMessage(FacesMessage.SEVERITY_ERROR, "png or jpg!", "png or jpg");}
		            if (message!=null && !message.getDetail().isEmpty())
		                {
		                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
		                    throw new ValidatorException(message );
		                }
		 
		        } catch (Exception ex) {
		               throw new ValidatorException(new FacesMessage(ex.getMessage()));
		        }
		
	}

}
