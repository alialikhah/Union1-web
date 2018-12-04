package jsfui;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;

@Named
@RequestScoped
public class RentBean {

	public RentBean() {
		// TODO Auto-generated constructor stub
	}

	private String rentType;// نوع آگهی
	private String homeType;// نوع ملک
	private String situation;// واقع در
	private String position;// موقعیت
	private String homeAddres; // آدرس ملک
	private int tedadTabage; // تعداد طبقات
	private int tedadVahed; // تعداد واحد در هر طبقه
	private String vadieeMoney;// مبلغ درخواستی ودیعه :
	private String ejareMony;// مبلغ درخواستی اجاره ماهیانه :
	private int tabageNum;// طبقه
	private String zirbana;
	private boolean homePhone;
	private boolean homeKitchen;
	private boolean homeService;
	private boolean homeKafposh;
	private boolean homeParking;
	private boolean homeAnbar;
	private boolean homeBalkon;
	private boolean sardarbTablo;
	private String metrajTablo;
	private boolean cooler;
	private boolean gaz;
	private boolean shofaj;
	private boolean fancoel;
	private boolean packag;
	private boolean chiler;
	private boolean asansor;
	private boolean hayat;
	private boolean hayatKhalvat;
	private boolean zirZamin;
	private boolean pasio;
	private boolean seraydar;
	private boolean herasat;
	private boolean pelebargi;
	private boolean foodkort;
	private boolean resturant;
	private boolean kafishap;
	private boolean sportSalon;
	private boolean arayeshgah;
	private boolean estakhr;
	private boolean sona;
	private boolean children;
	private boolean teatre;
	private String tarakom;
	private String mashahat;
	private String toleBar;
	private String eslahi;
	private String senBana;
	private String vaziatMelk;
	private String nama;
	private String vaziatSanad;
	private String ertefa;
	private String description;
	private boolean parvane;
	private String etehadieName;
	private String answererName;
	private String phone;
	private String mobile;
	private String addres;

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHomeAddres() {
		return homeAddres;
	}

	public void setHomeAddres(String homeAddres) {
		this.homeAddres = homeAddres;
	}

	public int getTedadTabage() {
		return tedadTabage;
	}

	public void setTedadTabage(int tedadTabage) {
		this.tedadTabage = tedadTabage;
	}

	public int getTedadVahed() {
		return tedadVahed;
	}

	public void setTedadVahed(int tedadVahed) {
		this.tedadVahed = tedadVahed;
	}

	public String getVadieeMoney() {
		return vadieeMoney;
	}

	public void setVadieeMoney(String vadieeMoney) {
		this.vadieeMoney = vadieeMoney;
	}

	public String getEjareMony() {
		return ejareMony;
	}

	public void setEjareMony(String ejareMony) {
		this.ejareMony = ejareMony;
	}

	public int getTabageNum() {
		return tabageNum;
	}

	public void setTabageNum(int tabageNum) {
		this.tabageNum = tabageNum;
	}

	public String getZirbana() {
		return zirbana;
	}

	public void setZirbana(String zirbana) {
		this.zirbana = zirbana;
	}

	public boolean isHomePhone() {
		return homePhone;
	}

	public void setHomePhone(boolean homePhone) {
		this.homePhone = homePhone;
	}

	public boolean isHomeKitchen() {
		return homeKitchen;
	}

	public void setHomeKitchen(boolean homeKitchen) {
		this.homeKitchen = homeKitchen;
	}

	public boolean isHomeService() {
		return homeService;
	}

	public void setHomeService(boolean homeService) {
		this.homeService = homeService;
	}

	public boolean isHomeKafposh() {
		return homeKafposh;
	}

	public void setHomeKafposh(boolean homeKafposh) {
		this.homeKafposh = homeKafposh;
	}

	public boolean isHomeParking() {
		return homeParking;
	}

	public void setHomeParking(boolean homeParking) {
		this.homeParking = homeParking;
	}

	public boolean isHomeAnbar() {
		return homeAnbar;
	}

	public void setHomeAnbar(boolean homeAnbar) {
		this.homeAnbar = homeAnbar;
	}

	public boolean isHomeBalkon() {
		return homeBalkon;
	}

	public void setHomeBalkon(boolean homeBalkon) {
		this.homeBalkon = homeBalkon;
	}

	public boolean isSardarbTablo() {
		return sardarbTablo;
	}

	public void setSardarbTablo(boolean sardarbTablo) {
		this.sardarbTablo = sardarbTablo;
	}

	public String getMetrajTablo() {
		return metrajTablo;
	}

	public void setMetrajTablo(String metrajTablo) {
		this.metrajTablo = metrajTablo;
	}

	public boolean isCooler() {
		return cooler;
	}

	public void setCooler(boolean cooler) {
		this.cooler = cooler;
	}

	public boolean isGaz() {
		return gaz;
	}

	public void setGaz(boolean gaz) {
		this.gaz = gaz;
	}

	public boolean isShofaj() {
		return shofaj;
	}

	public void setShofaj(boolean shofaj) {
		this.shofaj = shofaj;
	}

	public boolean isFancoel() {
		return fancoel;
	}

	public void setFancoel(boolean fancoel) {
		this.fancoel = fancoel;
	}

	public boolean isPackag() {
		return packag;
	}

	public void setPackag(boolean packag) {
		this.packag = packag;
	}

	public boolean isChiler() {
		return chiler;
	}

	public void setChiler(boolean chiler) {
		this.chiler = chiler;
	}

	public boolean isAsansor() {
		return asansor;
	}

	public void setAsansor(boolean asansor) {
		this.asansor = asansor;
	}

	public boolean isHayat() {
		return hayat;
	}

	public void setHayat(boolean hayat) {
		this.hayat = hayat;
	}

	public boolean isHayatKhalvat() {
		return hayatKhalvat;
	}

	public void setHayatKhalvat(boolean hayatKhalvat) {
		this.hayatKhalvat = hayatKhalvat;
	}

	public boolean isZirZamin() {
		return zirZamin;
	}

	public void setZirZamin(boolean zirZamin) {
		this.zirZamin = zirZamin;
	}

	public boolean isPasio() {
		return pasio;
	}

	public void setPasio(boolean pasio) {
		this.pasio = pasio;
	}

	public boolean isSeraydar() {
		return seraydar;
	}

	public void setSeraydar(boolean seraydar) {
		this.seraydar = seraydar;
	}

	public boolean isHerasat() {
		return herasat;
	}

	public void setHerasat(boolean herasat) {
		this.herasat = herasat;
	}

	public boolean isPelebargi() {
		return pelebargi;
	}

	public void setPelebargi(boolean pelebargi) {
		this.pelebargi = pelebargi;
	}

	public boolean isFoodkort() {
		return foodkort;
	}

	public void setFoodkort(boolean foodkort) {
		this.foodkort = foodkort;
	}

	public boolean isResturant() {
		return resturant;
	}

	public void setResturant(boolean resturant) {
		this.resturant = resturant;
	}

	public boolean isKafishap() {
		return kafishap;
	}

	public void setKafishap(boolean kafishap) {
		this.kafishap = kafishap;
	}

	public boolean isSportSalon() {
		return sportSalon;
	}

	public void setSportSalon(boolean sportSalon) {
		this.sportSalon = sportSalon;
	}

	public boolean isArayeshgah() {
		return arayeshgah;
	}

	public void setArayeshgah(boolean arayeshgah) {
		this.arayeshgah = arayeshgah;
	}

	public boolean isEstakhr() {
		return estakhr;
	}

	public void setEstakhr(boolean estakhr) {
		this.estakhr = estakhr;
	}

	public boolean isSona() {
		return sona;
	}

	public void setSona(boolean sona) {
		this.sona = sona;
	}

	public boolean isChildren() {
		return children;
	}

	public void setChildren(boolean children) {
		this.children = children;
	}

	public boolean isTeatre() {
		return teatre;
	}

	public void setTeatre(boolean teatre) {
		this.teatre = teatre;
	}

	public String getTarakom() {
		return tarakom;
	}

	public void setTarakom(String tarakom) {
		this.tarakom = tarakom;
	}

	public String getMashahat() {
		return mashahat;
	}

	public void setMashahat(String mashahat) {
		this.mashahat = mashahat;
	}

	public String getEslahi() {
		return eslahi;
	}

	public void setEslahi(String eslahi) {
		this.eslahi = eslahi;
	}

	public String getSenBana() {
		return senBana;
	}

	public void setSenBana(String senBana) {
		this.senBana = senBana;
	}

	public String getVaziatMelk() {
		return vaziatMelk;
	}

	public void setVaziatMelk(String vaziatMelk) {
		this.vaziatMelk = vaziatMelk;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getVaziatSanad() {
		return vaziatSanad;
	}

	public void setVaziatSanad(String vaziatSanad) {
		this.vaziatSanad = vaziatSanad;
	}

	public String getErtefa() {
		return ertefa;
	}

	public void setErtefa(String ertefa) {
		this.ertefa = ertefa;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isParvane() {
		return parvane;
	}

	public void setParvane(boolean parvane) {
		this.parvane = parvane;
	}

	public String getEtehadieName() {
		return etehadieName;
	}

	public void setEtehadieName(String etehadieName) {
		this.etehadieName = etehadieName;
	}

	public String getAnswererName() {
		return answererName;
	}

	public void setAnswererName(String answererName) {
		this.answererName = answererName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getToleBar() {
		return toleBar;
	}

	public void setToleBar(String toleBar) {
		this.toleBar = toleBar;
	}
	
	

}
