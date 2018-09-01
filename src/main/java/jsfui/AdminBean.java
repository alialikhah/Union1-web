package jsfui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import dao.entity.AdminEntity;
import service.AdminServiceLocal;

@Named
@SessionScoped
public class AdminBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminBean() {
		// TODO Auto-generated constructor stub
	}
	
	HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	@Inject
	private AdminServiceLocal adminServiceLocal;
	
	private String adminUsername;
	private String adminUserPass;
	private String slider1Pictures;

	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminUserPass() {
		return adminUserPass;
	}
	public void setAdminUserPass(String adminUserPass) {
		this.adminUserPass = adminUserPass;
	}
	
	
	
	public void findAdminByUser(){
		FacesContext contex=FacesContext.getCurrentInstance();
		try{
		AdminEntity adminEntity=new AdminEntity();
		adminEntity=adminServiceLocal.findAdminByUsername(this.adminUsername);
		session.setAttribute("adminUser", adminEntity.getAdminUsername());
		contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/admin.xhtml");
		}catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/home.xhtml");		}
	}
	
	public void isUser(ComponentSystemEvent event){
		FacesContext contex=FacesContext.getCurrentInstance();
		try{
		String adminUser=(String) session.getAttribute("adminUser");
		if(!adminUser.equals(null))
			System.out.println("******************ok******************");
		
		else if(adminUser.equals(null))
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/adminlogin.xhtml");
		}catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/adminlogin.xhtml");
		}
	}
	
	
			
	}


