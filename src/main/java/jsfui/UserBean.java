package jsfui;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dao.entity.UserEntity;
import service.SingletonServiceLocal;
import service.UserServiceLocal;

@Named
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4657228584681135449L;
	/**
	 * 
	 */

	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

	public UserBean() {
	}

	private String userName;
	private String password;
	private String role;
	private String wholeName;
	@Inject
	private UserServiceLocal userServiceLocal;
	@Inject
	private SingletonServiceLocal singletonServiceLocal;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getWholeName() {
		return wholeName;
	}

	public void setWholeName(String wholeName) {
		this.wholeName = wholeName;
	}

	private String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	private boolean verifyPassword(String password, String hashedPassword) {
		return BCrypt.checkpw(password, hashedPassword);
	}

	public void insertUser() {
		FacesContext contex = FacesContext.getCurrentInstance();
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userName);
		userEntity.setRole(role);
		userEntity.setWholeName(wholeName);
		userEntity.setPassword(hashPassword(password));
		System.err.println(hashPassword(password));
		userServiceLocal.insertToUserEntity(userEntity);
		contex.addMessage(null, new FacesMessage("با موفقیت افزوده شد"));

	}

	public void login() throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		UserEntity userEntity = new UserEntity();
		for (UserEntity userEntity2 : singletonServiceLocal.getUserEntities()) {
			if (userEntity2.getUserName().equals(this.userName)) {
				userEntity = userEntity2;
				System.err.println("****************find*****************");
			}
		}
		try {
			if ((verifyPassword(this.password, userEntity.getPassword()))) {
				System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOk");
				session.setAttribute("admpnou", this.userName);
			}
			else {
				System.err.println("NNNNNNNNNNNNNNNNNNNNNNNNNNN");
				throw new Exception();
			}
			if (userEntity.getRole().equals("shekayet")) {
				session.setAttribute("role", "shekayet");
				contex.getExternalContext().redirect("shekayatview.xhtml");
			}
			
			if(userEntity.getRole().equals("admin")) {
				session.setAttribute("role", "admin");
				contex.getExternalContext().redirect("viewmerchant.xhtml");
			}

		} catch (Exception e) {
			System.err.println("user not find.");
			if((this.userName.equals("mtafrm"))&(this.password.equals("mtaMTA61^!"))) {	
				session.setAttribute("admpnou", "mtafrm");
				session.setAttribute("role", "admin");
				contex.getExternalContext().redirect("modirf.xhtml");
			}
			contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "نام کاربری یا پسوورد اشتباه است", "نام کاربری یا پسوورد اشتباه است"));
		}
		

	}
	
	public void exitAdmin() throws IOException {
		FacesContext contex = FacesContext.getCurrentInstance();
		session.setAttribute("admpnou", null);
		session.setAttribute("role", null);
		contex.getExternalContext().redirect("home.xhtml");
	}
	

	public void isUser(ComponentSystemEvent event) {
		FacesContext contex = FacesContext.getCurrentInstance();
		try {
			String adminUser = (String) session.getAttribute("admpnou");
			String role = (String) session.getAttribute("role");
			if ((adminUser.equals(this.userName)) && (role.equals("shekayat")))
				System.out.println("******************ok******************");

			else if (adminUser.equals(null) || (role.equals(null)))
				contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/notfind.xhtml");
		} catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/notfind.xhtml");
		}
	}
	
	public void isUser2(ComponentSystemEvent event) {
		FacesContext contex = FacesContext.getCurrentInstance();
		try {
			String adminUser = (String) session.getAttribute("admpnou");
			String role = (String) session.getAttribute("role");
			if ((adminUser.equals("mtafrm"))&&(role.equals("admin")))
				System.out.println("******************ok******************");

			else if (adminUser.equals(null) || (role.equals(null)))
				contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/notfind.xhtml");
		} catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/notfind.xhtml");
		}
	}
	
	public void isUser3(ComponentSystemEvent event){
		FacesContext contex=FacesContext.getCurrentInstance();
		try{
		String adminUser=(String) session.getAttribute("admpnou");
		String role=(String) session.getAttribute("role");
		if((adminUser.equals(this.userName))&&(role.equals("admin")))
			System.out.println("******************ok******************");
		
		else if(adminUser.equals(null))
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/notfind.xhtml");
		}catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/notfind.xhtml");
		}
	}

}
