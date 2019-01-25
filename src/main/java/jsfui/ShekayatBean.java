package jsfui;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
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

	private String tarikh;
	private long shomare;
	private boolean check;
	private byte[] loadPic;

	private boolean showButton = false;

	// admin
	private String shekayatAdmin;
	private String shekayatPass;

	private List<String> titleList = new ArrayList<>();

	
	
	
	
	public byte[] getLoadPic() {
		return loadPic;
	}

	public void setLoadPic(byte[] loadPic) {
		this.loadPic = loadPic;
	}

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

	public String getTarikh() {
		return tarikh;
	}

	public void setTarikh(String tarikh) {
		this.tarikh = tarikh;
	}

	public long getShomare() {
		return shomare;
	}

	public void setShomare(long shomare) {
		this.shomare = shomare;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
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
		shekayat1.setMotesadiName(motesadiName);
		shekayat1.setShakiAddres(shakiAddres);
		shekayat1.setShakiEmail(shakiEmail);
		shekayat1.setShakiMobile(shakiMobile);
		shekayat1.setShakiMobile(shakiMobile);
		shekayat1.setShakiName(shakiName);
		shekayat1.setShakiPhone(shakiPhone);
		shekayat1.setShakiPostCode(shakiPostCode);
		shekayat1.setShakiSsn(shakiSsn);
		shekayat1.setSharh(sharh);
		shekayat1.setDate(new Date());
		shekayat1.setShekayatTitle(shekayatTitle);
		shekayat1.setVahedeSenfiMobile(vahedeSenfiMobile);
		shekayat1.setVahedeSenfiName(vahedeSenfiName);
		shekayat1.setVahedeSenfiPhone(vahedeSenfiPhone);
		shekayat1.setVahedeSenfiPostCode(vahedeSenfiPostCode);
		shekayat1.setVahedeShenaseAddres(vahedeShenaseAddres);
		shekayat1.setVahedeShenaseSenfi(vahedeShenaseSenfi);
		byte[] factorByte = IOUtils.toByteArray(shakiFactor.getInputStream());
		//shekayat1.setShakiFactor(factorByte);
		Random random=new Random();
		int picNum=random.nextInt(100000000);
        //write to hard
    	File out1=new File("/home/wildfly/ShekayatPictures/"+shakiMobile + picNum + ".jpg");
    	InputStream in1=new ByteArrayInputStream(factorByte);
    	BufferedImage img1=ImageIO.read(in1);
    	ImageIO.write(img1, "jpg", out1);
    	shekayat1.setPicPath("/home/wildfly/ShekayatPictures/"+shakiMobile + picNum + ".jpg");
    	////////////////////////////////
		shekayatServiceLocal.inserToShekayat(shekayat1);
		context.addMessage(null, new FacesMessage("در خواست با موفقیت ثبت گردید."));
		this.showButton = true;
		this.motesadiName = "";
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
		
		//return singletonServiceLocal.getShekayat1s();
		return shekayatServiceLocal.findAllShekayat();
	}

	public List<Shekayat1> findAllShekayatOrder() {
		//return singletonServiceLocal.getShekayat1s2();
	return shekayatServiceLocal.findAllShekayatOrder();
	}

	public Shekayat1 findShekayatById(long shakiId) throws IOException {
		Shekayat1 shekayat1;
		try {
			shekayat1 = shekayatServiceLocal.findShekayatById(shakiId);
			File imageFile=new File(shekayat1.getPicPath());
	    	BufferedImage image=ImageIO.read(imageFile);
	    	ByteArrayOutputStream baos=new ByteArrayOutputStream();
	    	ImageIO.write(image, "jpg", baos);
	    	this.loadPic=baos.toByteArray();
			return shekayat1;
		} catch (Exception e) {
			return null;
		}

	}
	
	public Shekayat1 findShekayatById2(long shakiId) {
		try {
			return shekayatServiceLocal.findShekayatById(shakiId);
		} catch (Exception e) {
			return null;
		}
	}

	public void shekayatUpdate(long shakiId) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
		Shekayat1 shekayat1 = new Shekayat1();
		shekayat1 = shekayatServiceLocal.findShekayatById(shakiId);
		shekayat1.setVaziat(vaziat);
		shekayat1.setCheckO(true);
		shekayat1.setShomare(shomare);
		shekayat1.setTarikh(tarikh);
		shekayatServiceLocal.shekayatUpdate(shekayat1);
		context.addMessage(null, new FacesMessage("با موفقیت ثبت گردید."));
		this.showButton = true;
		}catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطا", "Error login"));
		}
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

	
	
	
	
	
	
	public void sendSmsOk(String mobile ,String token1,String token2) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			URL url = new URL(
					"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=" + mobile +"&template=16147-submit&token=" + token1 +"&token2=" + token2 + "&token3=8-14");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			System.out.println(httpURLConnection.getResponseMessage());
			httpURLConnection.disconnect();
			context.addMessage(null, new FacesMessage("پیامک حضور شخص با موفقیت ارسال شد"));
		} catch (IOException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطای ارسال پیامک", "خطای ارسال پیامک"));
		}

	}
	
	
	

	public void sendSmsNok(String mobile) {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			URL url = new URL(
					"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor="+ mobile + "&template=16147-subject&token=end");
			System.err.println("https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor="+ mobile + "&template=16147-subject&token=end");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			System.out.println(httpURLConnection.getResponseMessage());
			httpURLConnection.disconnect();
			context.addMessage(null, new FacesMessage("پیامک عدم ارتباط با اتحادیه با موفقیت ارسال شد"));
		} catch (IOException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "خطای ارسال پیامک", "خطای ارسال پیامک"));
		}

	}
	
	public String gregorian_to_jalali(int gy, int gm, int gd) {
		int[] g_d_m = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
		int jy;
		if (gy > 1600) {
			jy = 979;
			gy -= 1600;
		} else {
			jy = 0;
			gy -= 621;
		}
		int gy2 = (gm > 2) ? (gy + 1) : gy;
		int days = (365 * gy) + ((int) ((gy2 + 3) / 4)) - ((int) ((gy2 + 99) / 100)) + ((int) ((gy2 + 399) / 400)) - 80
				+ gd + g_d_m[gm - 1];
		jy += 33 * ((int) (days / 12053));
		days %= 12053;
		jy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			jy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int jm = (days < 186) ? 1 + (int) (days / 31) : 7 + (int) ((days - 186) / 30);
		int jd = 1 + ((days < 186) ? (days % 31) : ((days - 186) % 30));
		int[] out = { jy, jm, jd };
		// return out;
		// return null;
		return jy + "-" + jm + "-" + jd;
	}
	
	
	public String convertToJalali(long shakiId) {
		try {
		Shekayat1 shekayat1=new Shekayat1();
		shekayat1=this.findShekayatById(shakiId);
		String dateEng = shekayat1.getDate().toString();
		char[] mnth = new char[3];
		dateEng.getChars(4, 7, mnth, 0);
		String month = "";
		for (char c : mnth) {
			month += c;
		}
		System.err.println(month);
		int month1 = 0;
		if (month.equals("Jan"))
			month1 = 1;
		else if (month.equals("Feb"))
			month1 = 2;
		else if (month.equals("Mar"))
			month1 = 3;
		else if (month.equals("Apr"))
			month1 = 4;
		else if (month.equals("May"))
			month1 = 5;
		else if (month.equals("Jun"))
			month1 = 6;
		else if (month.equals("Jul"))
			month1 = 7;
		else if (month.equals("Aug"))
			month1 = 8;
		else if (month.equals("Sep"))
			month1 = 9;
		else if (month.equals("Oct"))
			month1 = 10;
		else if (month.equals("Nov"))
			month1 = 11;
		else if (month.equals("Dec"))
			month1 = 12;

		char[] dy = new char[2];
		dateEng.getChars(8, 10, dy, 0);
		String day = "";
		for (char c : dy) {
			day += c;
		}

		int day1 = Integer.parseInt(day);

		char[] yer = new char[4];
		dateEng.getChars(25, 29, yer, 0);
		String year = "";
		for (char c : yer) {
			year += c;
		}
		int year1 = Integer.parseInt(year);
		return gregorian_to_jalali(year1, month1, day1);
		}catch (Exception e) {
			return null;
		}

	}
	
    public void deleteShekayatEntity(long shakiId) throws IOException{
		FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayatServiceLocal.deleteShekayatEntity(shekayat1);
		contex.getExternalContext().redirect("shekayatview.xhtml");
    }
    
    public void updateShakiMobile(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setShakiMobile(shakiMobile);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateVahedeSenfiMobile(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setVahedeSenfiMobile(vahedeSenfiMobile);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateShakiName(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setShakiName(shakiName);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateVahedeSenfiName(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setVahedeSenfiName(vahedeSenfiName);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateMotesadiName(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setMotesadiName(motesadiName);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    public void updateShakiSsn(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setShakiSsn(shakiSsn);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateShakiPhone(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setShakiPhone(shakiPhone);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateShakiEmail(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setShakiEmail(shakiEmail);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updatePostCode(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setShakiPostCode(shakiPostCode);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateShakiAddres(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setShakiAddres(shakiAddres);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateVahedeSenfiPhone(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setVahedeSenfiPhone(vahedeSenfiPhone);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateShenaseSenfi(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setVahedeShenaseSenfi(vahedeShenaseSenfi);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateVahedeSenfiPostCode(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setVahedeSenfiPostCode(vahedeSenfiPostCode);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateVahedeSenfiAddres(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setVahedeShenaseAddres(vahedeShenaseAddres);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
    
    public void updateVahedeSenfiSharh(long shakiId) throws IOException {
    	FacesContext contex = FacesContext.getCurrentInstance();
    	Shekayat1 shekayat1=new Shekayat1();
    	shekayat1=this.findShekayatById2(shakiId);
    	shekayat1.setSharh(sharh);
    	shekayatServiceLocal.shekayatUpdate(shekayat1);
    	contex.getExternalContext().redirect("shekayatedit.xhtml?shakiId="+shakiId);
    }
}
