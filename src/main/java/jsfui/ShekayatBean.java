package jsfui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.entity.Shekayat1;
import service.ShekayatServiceLocal;
import service.SingletonServiceLocal;

@Named
@ViewScoped
public class ShekayatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShekayatBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private ShekayatServiceLocal shekayatServiceLocal;
	@Inject
	private SingletonServiceLocal singletonServiceLocal;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	private String shakiName;
	private String shakiSsn;
	private String shakiPhone;
	private String shakiMobile;
	private String shakiEmail;
	private String shakiPostCode;
	private String shakiAddres;
	private String vahedeSenfiName;
	private String motesadiName;
	private String vahedeSenfiPhone;
	private String vahedeSenfiMobile;
	private String vahedeShenaseSenfi;
	private String vahedeSenfiPostCode;
	private String vahedeShenaseAddres;
	private String shekayatTitle;
	private String sharh;
	private Part shakiFactor;
	// after shekayat
	private String vaziat;
	private String parvande;
	private String date;
	private String rahgiri;

	private boolean showButton = false;;

	// admin
	private String shekayatAdmin;
	private String shekayatPass;

	private List<String> titleList = new ArrayList<>();

	public String getShakiName() {
		return shakiName;
	}

	public void setShakiName(String shakiName) {
		this.shakiName = shakiName;
	}

	public String getShakiMobile() {
		return shakiMobile;
	}

	public void setShakiMobile(String shakiMobile) {
		this.shakiMobile = shakiMobile;
	}

	public String getShakiEmail() {
		return shakiEmail;
	}

	public void setShakiEmail(String shakiEmail) {
		this.shakiEmail = shakiEmail;
	}

	public String getShakiAddres() {
		return shakiAddres;
	}

	public void setShakiAddres(String shakiAddres) {
		this.shakiAddres = shakiAddres;
	}

	public String getVahedeSenfiName() {
		return vahedeSenfiName;
	}

	public void setVahedeSenfiName(String vahedeSenfiName) {
		this.vahedeSenfiName = vahedeSenfiName;
	}

	public String getMotesadiName() {
		return motesadiName;
	}

	public void setMotesadiName(String motesadiName) {
		this.motesadiName = motesadiName;
	}

	public String getVahedeSenfiMobile() {
		return vahedeSenfiMobile;
	}

	public void setVahedeSenfiMobile(String vahedeSenfiMobile) {
		this.vahedeSenfiMobile = vahedeSenfiMobile;
	}

	public String getVahedeShenaseSenfi() {
		return vahedeShenaseSenfi;
	}

	public void setVahedeShenaseSenfi(String vahedeShenaseSenfi) {
		this.vahedeShenaseSenfi = vahedeShenaseSenfi;
	}

	public String getVahedeShenaseAddres() {
		return vahedeShenaseAddres;
	}

	public void setVahedeShenaseAddres(String vahedeShenaseAddres) {
		this.vahedeShenaseAddres = vahedeShenaseAddres;
	}

	public String getShekayatTitle() {
		return shekayatTitle;
	}

	public void setShekayatTitle(String shekayatTitle) {
		this.shekayatTitle = shekayatTitle;
	}

	public String getSharh() {
		return sharh;
	}

	public void setSharh(String sharh) {
		this.sharh = sharh;
	}

	public Part getShakiFactor() {
		return shakiFactor;
	}

	public void setShakiFactor(Part shakiFactor) {
		this.shakiFactor = shakiFactor;
	}

	public String getVaziat() {
		return vaziat;
	}

	public void setVaziat(String vaziat) {
		this.vaziat = vaziat;
	}

	public String getParvande() {
		return parvande;
	}

	public void setParvande(String parvande) {
		this.parvande = parvande;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRahgiri() {
		return rahgiri;
	}

	public void setRahgiri(String rahgiri) {
		this.rahgiri = rahgiri;
	}

	public String getShekayatAdmin() {
		return shekayatAdmin;
	}

	public void setShekayatAdmin(String shekayatAdmin) {
		this.shekayatAdmin = shekayatAdmin;
	}

	public String getShekayatPass() {
		return shekayatPass;
	}

	public void setShekayatPass(String shekayatPass) {
		this.shekayatPass = shekayatPass;
	}

	public ShekayatServiceLocal getShekayatServiceLocal() {
		return shekayatServiceLocal;
	}

	public void setShekayatServiceLocal(ShekayatServiceLocal shekayatServiceLocal) {
		this.shekayatServiceLocal = shekayatServiceLocal;
	}

	public String getShakiSsn() {
		return shakiSsn;
	}

	public void setShakiSsn(String shakiSsn) {
		this.shakiSsn = shakiSsn;
	}

	public String getShakiPhone() {
		return shakiPhone;
	}

	public void setShakiPhone(String shakiPhone) {
		this.shakiPhone = shakiPhone;
	}

	public String getShakiPostCode() {
		return shakiPostCode;
	}

	public void setShakiPostCode(String shakiPostCode) {
		this.shakiPostCode = shakiPostCode;
	}

	public String getVahedeSenfiPhone() {
		return vahedeSenfiPhone;
	}

	public void setVahedeSenfiPhone(String vahedeSenfiPhone) {
		this.vahedeSenfiPhone = vahedeSenfiPhone;
	}

	public String getVahedeSenfiPostCode() {
		return vahedeSenfiPostCode;
	}

	public void setVahedeSenfiPostCode(String vahedeSenfiPostCode) {
		this.vahedeSenfiPostCode = vahedeSenfiPostCode;
	}

	public boolean isShowButton() {
		return showButton;
	}

	public void setShowButton(boolean showButton) {
		this.showButton = showButton;
	}

	public List<String> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<String> titleList) {
		this.titleList = titleList;
	}

	@PostConstruct
	public void init() {
		titleList.add("گرانفروشی");
		titleList.add("تقلب");
		titleList.add("عدم درج قیمت و نصب نرخنامه");
		titleList.add("عدم صدور صورت حساب");
		titleList.add("نداشتن پروانه کسب");
		titleList.add("عدم انجام خدمات پس از فروش در دوره ضمانت");
	}

	public void inserToShekayat() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1.setDate(date);
		shekayat1.setMotesadiName(motesadiName);
		shekayat1.setParvande(parvande);
		shekayat1.setRahgiri(rahgiri);
		shekayat1.setShakiAddres(shakiAddres);
		shekayat1.setShakiEmail(shakiEmail);
		shekayat1.setShakiMobile(shakiMobile);
		shekayat1.setShakiMobile(shakiMobile);
		shekayat1.setShakiName(shakiName);
		shekayat1.setShakiPhone(shakiPhone);
		shekayat1.setShakiPostCode(shakiPostCode);
		shekayat1.setShakiSsn(shakiSsn);
		shekayat1.setSharh(sharh);
		shekayat1.setShekayatTitle(shekayatTitle);
		shekayat1.setVahedeSenfiMobile(vahedeSenfiMobile);
		shekayat1.setVahedeSenfiName(vahedeSenfiName);
		shekayat1.setVahedeSenfiPhone(vahedeSenfiPhone);
		shekayat1.setVahedeSenfiPostCode(vahedeSenfiPostCode);
		shekayat1.setVahedeShenaseAddres(vahedeShenaseAddres);
		shekayat1.setVahedeShenaseSenfi(vahedeShenaseSenfi);
		shekayat1.setVaziat(vaziat);
		byte[] factorByte = IOUtils.toByteArray(shakiFactor.getInputStream());
		shekayat1.setShakiFactor(factorByte);
		shekayatServiceLocal.inserToShekayat(shekayat1);

		context.addMessage(null, new FacesMessage("در خواست با موفقیت ثبت گردید."));
		this.showButton = true;
		this.motesadiName = "";
		this.parvande = "";
		this.rahgiri = "";
		this.shakiAddres = "";
		this.shakiEmail = "";
		this.shakiMobile = "";
		this.shakiName = "";
		this.shakiPhone = "";
		this.shakiPostCode = "";
		this.shakiSsn = "";
		this.sharh = "";
		this.shekayatAdmin = "";
		this.shekayatPass = "";
		this.shekayatTitle = "";
		this.vahedeSenfiMobile = "";
		this.vahedeSenfiName = "";
		this.vahedeSenfiPhone = "";
		this.vahedeSenfiPostCode = "";
		this.vahedeShenaseAddres = "";
		this.vahedeShenaseSenfi = "";
		this.vaziat = "";
		/*
		 * FacesContext.getCurrentInstance().getExternalContext()
		 * .redirect("shekayatprint.xhtml");
		 */
	}

	public List<Shekayat1> findAllShekayat() {
		return singletonServiceLocal.getShekayat1s();
	}
	
	public List<Shekayat1> findAllShekayatOrder(){
    	return singletonServiceLocal.getShekayat1s2();
    }

	public Shekayat1 findShekayatById(long shakiId) {
		return shekayatServiceLocal.findShekayatById(shakiId);
	}

	public void shekayatUpdate(long shakiId) {
		FacesContext context = FacesContext.getCurrentInstance();
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = shekayatServiceLocal.findShekayatById(shakiId);
		Date date = new Date();
		shekayat1.setDate(date.toString());
		shekayat1.setVaziat(vaziat);
		shekayat1.setRahgiri(rahgiri);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		context.addMessage(null, new FacesMessage("با موفقیت ثبت گردید."));
		this.showButton = true;
	}

	public void enterAdmin() {
		FacesContext contex = FacesContext.getCurrentInstance();
		if (this.shekayatAdmin.equals("user1") && (this.shekayatPass.equals("1234"))) {
			session.setAttribute("user1", this.shekayatAdmin);
			session.setAttribute("pass", this.shekayatPass);
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/shekayatview.xhtml");
		} else {
			contex.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا", "Error login"));
		}
	}

	public void exitAdmin() {
		FacesContext contex = FacesContext.getCurrentInstance();
		session.setAttribute("user1", null);
		session.setAttribute("pass", null);
		contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/shekayatlogin.xhtml");
	}

	public void isUser(ComponentSystemEvent event) {
		FacesContext contex = FacesContext.getCurrentInstance();
		try {
			String shekayatAdmin = (String) session.getAttribute("user1");
			String shekayatPass = (String) session.getAttribute("pass");
			if ((shekayatAdmin.equals("user1")) && (shekayatPass.equals("1234")))
				System.out.println("******************ok******************");

			else if (shekayatAdmin.equals(null))
				contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/shekayatlogin.xhtml");
		} catch (Exception e) {
			contex.getApplication().getNavigationHandler().handleNavigation(contex, null, "/shekayatlogin.xhtml");
		}
	}

}
