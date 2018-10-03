package jsfui;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import dao.entity.MerchantEntity;
import dao.entity.UserEntity;
import service.MerchantRegisterServiceLocal;
import service.OnlineMerchantServiceLocal;
import service.SendMailServiceLocal;
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
	@Inject
	private SendMailServiceLocal sendMailServiceLocal;
	@Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;
	@Inject
	private OnlineMerchantServiceLocal onlineMerchantServiceLocal; 
	
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

	private String userName;
	private String userEmail;
	private boolean usertaeed;
	private String password;
	private String merchantSsn;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public boolean isUsertaeed() {
		return usertaeed;
	}

	public void setUsertaeed(boolean usertaeed) {
		this.usertaeed = usertaeed;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getMerchantSsn() {
		return merchantSsn;
	}

	public void setMerchantSsn(String merchantSsn) {
		this.merchantSsn = merchantSsn;
	}

	public void insertToUserEntity() throws IOException {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userName);
		userEntity.setUserEmail(userEmail);
		String ramz = this.createRamz();
		userEntity.setUserRamz(ramz);
		FacesContext.getCurrentInstance().getExternalContext().redirect("userlogin.xhtml");
		try {
			sendMailServiceLocal.sendMail(ramz, userEmail);
		} catch (Exception e) {
			System.err.println("Email error");
		}
		userServiceLocal.insertToUserEntity(userEntity);
	}

	public String createRamz() {
		char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
				'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
				'z', '!', '@', '#', '$', '%', '&', '*' };
		char[] c = new char[10];
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			c[i] = ch[random.nextInt(ch.length)];
		}
		return new String(c);
	}

	public void userLogin() throws IOException {
		UserEntity userEntity = new UserEntity();
		userEntity = userServiceLocal.findUserByEmail(userEmail);
		if (userEntity.getUserEmail().equals(this.userEmail) && (userEntity.getUserRamz().equals(this.password))) {
			session.setAttribute("mail", this.userEmail);
			session.setAttribute("username", userEntity.getUserName());
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} else {
			System.err.println("nothing");
		}
	}

	public String userIs() {
		String userName = (String) session.getAttribute("username");
		try {
			if (userName.equals(""))
				return "مهمان";
			else {
				return userName;
			}
		} catch (Exception e) {
			return "مهمان";
		}

	}

	public void logout(){
		MerchantEntity merchantEntity=new MerchantEntity();
		try {
			merchantEntity=merchantRegisterServiceLocal.findMerchantById(Long.parseLong(session.getAttribute("merchantId").toString()));
			onlineMerchantServiceLocal.getMerchantEntities().remove(merchantEntity);
			session.setAttribute("mail", "");
			session.setAttribute("username", "");
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (Exception e) {
			System.err.println("merchant not find");
		}

	}

	public boolean shoeLogout() {
		try {
			if (session.getAttribute("username").equals(""))
				return false;
			else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public void merchantLogin() {
		MerchantEntity merchantEntity=new MerchantEntity();
		try {
			merchantEntity=merchantRegisterServiceLocal.findMerchantBySsn(merchantSsn);
			if (merchantEntity.getMerchantSsn().equals(this.merchantSsn)) {
				session.setAttribute("username", merchantEntity.getMerchantShopNamePer());
				session.setAttribute("merchantId", merchantEntity.getMerchantId());
				onlineMerchantServiceLocal.getMerchantEntities().add(merchantEntity);
				FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
			}
			else
				System.err.println("nothing");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	public void destroy() {
		MerchantEntity merchantEntity=new MerchantEntity();
		try {
			merchantEntity=merchantRegisterServiceLocal.findMerchantById(Long.parseLong(session.getAttribute("merchantId").toString()));
			onlineMerchantServiceLocal.getMerchantEntities().remove(merchantEntity);
			session.setAttribute("mail", "");
			session.setAttribute("username", "");
			FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
		} catch (Exception e) {
			System.err.println("merchant not find");
		}
	}

	
}
