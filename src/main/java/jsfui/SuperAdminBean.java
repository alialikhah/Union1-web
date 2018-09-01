package jsfui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import dao.entity.AdminEntity;
import service.AdminServiceLocal;

@Named
@SessionScoped
public class SuperAdminBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuperAdminBean() {
		// TODO Auto-generated constructor stub
	}
	
	HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	@Inject
	private AdminServiceLocal adminServiceLocal;
	
	private String superUsername;
	private String superPassword;
	
	private String adminUsername;
	private String adminPass;
	private String adminAccessing;

	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public String getAdminAccessing() {
		return adminAccessing;
	}
	public void setAdminAccessing(String adminAccessing) {
		this.adminAccessing = adminAccessing;
	}
	

	
	public String getSuperUsername() {
		return superUsername;
	}
	public void setSuperUsername(String superUsername) {
		this.superUsername = superUsername;
	}
	public String getSuperPassword() {
		return superPassword;
	}
	public void setSuperPassword(String superPassword) {
		this.superPassword = superPassword;
	}
	public void adminLogin(){
		FacesContext contex=FacesContext.getCurrentInstance();
		try{
		if((this.superUsername.equals("farnam"))&&(this.superPassword.equals("1"))){
			
			session.setAttribute("superUsername", this.superUsername);
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/superadmin.xhtml");
		}
		else
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/home.xhtml");
		}catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/home.xhtml");
		}
			
	}



	public void isUser(ComponentSystemEvent event){
		FacesContext contex=FacesContext.getCurrentInstance();
		try{
		String username=(String) session.getAttribute("superUsername");
		if(!username.equals(null))
			System.out.println("******************ok******************");
		
		else if(username.equals(null))
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/superadminlogin.xhtml");
		}catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/superadminlogin.xhtml");
		}
	}
	
	public void adminLogOut(){
		FacesContext contex=FacesContext.getCurrentInstance();
		try{
			
			session.setAttribute("superUsername", null);
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/superadminlogin.xhtml");
		}
		catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/superadminlogin.xhtml");
		}
	}
	
	public void insertToAdmin(){
		AdminEntity adminEntity=new AdminEntity();
		adminEntity.setAdminUsername(adminUsername);
		adminEntity.setAdminPass(adminPass);
		adminServiceLocal.insertToAdmin(adminEntity);
	}
	
	public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful") );
    }

}
