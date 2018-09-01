package jsfui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

@Named
@SessionScoped
public class NotFindBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFindBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void isUser(ComponentSystemEvent event) {
/*		String origRequest = FacesContext.getCurrentInstance().getExternalContext().get;
		System.err.println(origRequest.toString());*/
	}

}
