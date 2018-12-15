package jsfui;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userName);
		userEntity.setRole(role);
		userEntity.setWholeName(wholeName);
		userEntity.setPassword(hashPassword(password));
		System.err.println(hashPassword(password));
		userServiceLocal.insertToUserEntity(userEntity);
	}

	public void login() {
		FacesContext contex = FacesContext.getCurrentInstance();
		UserEntity userEntity = new UserEntity();
		for (UserEntity userEntity2 : singletonServiceLocal.getUserEntities()) {
			if (userEntity2.getUserName().equals(this.userName)) {
				userEntity = userEntity2;
				System.err.println("****************find*****************");
			}
		}
		try {
			if (verifyPassword(this.password, userEntity.getPassword())) {
				System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOk");
				session.setAttribute("admpnou", this.userName);
			} else {
				System.err.println("NNNNNNNNNNNNNNNNNNNNNNNNNNN");
			}
			if (userEntity.getRole().equals("shekayet")) {
				session.setAttribute("role", "shekayet");
				contex.getExternalContext().redirect("shekayatview.xhtml");
			}
		} catch (Exception e) {
			System.err.println("user not find.");
		}
	}

	public void isUser(ComponentSystemEvent event) {
		FacesContext contex = FacesContext.getCurrentInstance();
		try {
			String adminUser = (String) session.getAttribute("admpnou");
			String role = (String) session.getAttribute("role");
			if ((adminUser.equals("mtafrm")) && (role.equals("shekayat")))
				System.out.println("******************ok******************");

			else if (adminUser.equals(null) || (role.equals(null)))
				contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/notfind.xhtml");
		} catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/notfind.xhtml");
		}
	}

}
