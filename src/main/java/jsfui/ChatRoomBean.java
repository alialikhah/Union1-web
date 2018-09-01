package jsfui;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class ChatRoomBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChatRoomBean() {
		// TODO Auto-generated constructor stub
	}
	
	HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	private String name="aliam";
	
	

	public String getName() {
		return name;
	}

	@PostConstruct
	public void sessionSet(){
		name=session.getAttribute("adminUser").toString();
		System.err.println(name);
	}


	public void setName(String name) {
		this.name = name;
	}



	public void act(){
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	}
	
	//WebSocketRef2 webSocketRef2=new WebSocketRef2();
	
	
}
