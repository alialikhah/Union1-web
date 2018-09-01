package jsfui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;

import dao.entity.UserEntity;
import service.UserServiceLocal;

@Named
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private UserServiceLocal userServiceLocal;
	 
	private String userName;
	private String userFamily;
	private String userSsn;
	private String userEmail;
	private String userMobile;
	private String access;
	private String password;
	
	
	 public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserFamily() {
		return userFamily;
	}



	public void setUserFamily(String userFamily) {
		this.userFamily = userFamily;
	}



	public String getUserSsn() {
		return userSsn;
	}



	public void setUserSsn(String userSsn) {
		this.userSsn = userSsn;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserMobile() {
		return userMobile;
	}



	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}



	public String getAccess() {
		return access;
	}



	public void setAccess(String access) {
		this.access = access;
	}
	
	



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void insertToUserEntity() {
		 UserEntity userEntity=new UserEntity();
		 userEntity.setUserName(userName);
		 userEntity.setUserFamily(userFamily);
		 userEntity.setUserMobile(userMobile);
		 userEntity.setUserEmail(userEmail);
		 userEntity.setUserSsn(userSsn);
		 userEntity.setPassword(password);
	 	 userServiceLocal.insertToUserEntity(userEntity);
	 }
}
