package jsfui;

import java.io.IOException;
import java.io.Serializable;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import Exceptions.MerchantRegisterException;
import Exceptions.MerchantShomareParvandeException;
import Exceptions.MerchantShopNameException;
import Exceptions.MerchantSsnException;
import Exceptions.PanooRoleBackException;
import dao.entity.BrandEntity;
import dao.entity.MerchantEntity;
import service.AddBrandServiceLocal;
import service.MerchantRegisterServiceLocal;
import service.SingletonServiceLocal;

@Named
@RequestScoped
public class MerchantRegisterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MerchantRegisterBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SingletonServiceLocal singletonServiceLocal;

	private String merchantName; // 4
	private String merchantFamily; // 44
	private String merchantShoar; // 444
	private String merchantPass; // 4444
	private String merchantPhone; // 17
	private String merchantEmail; // 20
	private String merchantMobile;// 7
	private String merchantSsn;// 6
	private String merchantSaliManagerName;// 8
	private String merchantSailManagerMobile;// 9
	private String merchantJobTitleInterface;// 11
	private String merchantInterfaceMobile;// 12
	private String merchantSocialNetworkNumber;// 14
	private String merchantPostAddres;// 15
	private String merchantPostCode;// 16
	private String merchantFax;// 18
	private String merchantSiteAddres;// 19
	private String merchantTelegram;// 21
	private String merchantInstagram;// 22
	private long merchantLicenseNumber;// 23
	private String merchantShopNamePer;// 1
	private String merchantShopNameEng;// 2
	private String merchantSrwardName;// 27
	private boolean merchantStewardShip;// 26
	private boolean merchantEMark;// 29
	private List<String> occupations = new ArrayList<>();
	private List<String> groups = new ArrayList<>();
	private List<String> socialNetworks = new ArrayList<>();
	private List<String> unions = new ArrayList<>();
	private List<String> areas = new ArrayList<>();
	private List<String> states = new ArrayList<>();
	private List<String> cities = new ArrayList<>();
	private List<String> haveLicenceList = new ArrayList<>();
	private List<String> haveEtebarList = new ArrayList<>();
	private String occupation;
	private String group;
	private String socialNetwork;
	private String union;
	private String area;
	private String city;
	private String state;
	private double gmapWhidth;
	private double gmapHeight;

	private String merchantInterfaceNamee;
	private Part licenseImage;
	private Part shopImg1;
	private Part shopImg2;
	private Part shopImg3;
	private Part shopImg4;
	private Part logo;
	private MerchantEntity merchantEntity;
	private boolean textboxRenderer = false;
	private String description;
	private List<String> brandName = new ArrayList<>();
	private String brands = "";
	private long shomareParPaano;
	private long shomareParUnion;
	private String searchSsn;
	private long searchShomareParvande;
	private String merchantBirthDayChange;
	private String merchantKhatemeChange;
	private String merchantMobasherDateChange;
	private String merchantEtebarChange;
	private String merchantGarardadChange;
	private String merchantStartChange;
	private String merchantTelegramAddres;
	private String merchantTelegramNumber;
	private String merchantInstagramAddres;
	private String merchantInstagramNumber;
	private boolean merchantPicJavaz;
	private String merchantWatsup;
	private String merchantTwiter;
	private String haveLicenese;
	private boolean haveMobasher;
	private String haveEtebar;
	private boolean phoneShow;
	private boolean faxShow;
	private boolean siteShow;
	private boolean instagramShow;
	private boolean telegramShow;
	private boolean watsupShow;
	private boolean twiterShow;
	private boolean haveLogo;
	
	private BrandEntity brand2;
	
	
	

	public BrandEntity getBrand2() {
		return brand2;
	}

	public void setBrand2(BrandEntity brand2) {
		this.brand2 = brand2;
	}
	private List<BrandEntity> brandPartList = new ArrayList<>();

	public List<BrandEntity> getBrandPartList() {
		return brandPartList;
	}

	public void setBrandPartList(List<BrandEntity> brandPartList) {
		this.brandPartList = brandPartList;
	}

	public String getMerchantStartChange() {
		return merchantStartChange;
	}

	public void setMerchantStartChange(String merchantStartChange) {
		this.merchantStartChange = merchantStartChange;
	}

	public String getMerchantGarardadChange() {
		return merchantGarardadChange;
	}

	public void setMerchantGarardadChange(String merchantGarardadChange) {
		this.merchantGarardadChange = merchantGarardadChange;
	}

	public boolean isHaveLogo() {
		return haveLogo;
	}

	public void setHaveLogo(boolean haveLogo) {
		this.haveLogo = haveLogo;
	}

	public boolean isPhoneShow() {
		return phoneShow;
	}

	public void setPhoneShow(boolean phoneShow) {
		this.phoneShow = phoneShow;
	}

	public boolean isFaxShow() {
		return faxShow;
	}

	public void setFaxShow(boolean faxShow) {
		this.faxShow = faxShow;
	}

	public boolean isSiteShow() {
		return siteShow;
	}

	public void setSiteShow(boolean siteShow) {
		this.siteShow = siteShow;
	}

	public boolean isInstagramShow() {
		return instagramShow;
	}

	public void setInstagramShow(boolean instagramShow) {
		this.instagramShow = instagramShow;
	}

	public boolean isTelegramShow() {
		return telegramShow;
	}

	public void setTelegramShow(boolean telegramShow) {
		this.telegramShow = telegramShow;
	}

	public boolean isWatsupShow() {
		return watsupShow;
	}

	public void setWatsupShow(boolean watsupShow) {
		this.watsupShow = watsupShow;
	}

	public boolean isTwiterShow() {
		return twiterShow;
	}

	public void setTwiterShow(boolean twiterShow) {
		this.twiterShow = twiterShow;
	}

	public List<String> getHaveLicenceList() {
		return haveLicenceList;
	}

	public void setHaveLicenceList(List<String> haveLicenceList) {
		this.haveLicenceList = haveLicenceList;
	}

	public List<String> getHaveEtebarList() {
		return haveEtebarList;
	}

	public void setHaveEtebarList(List<String> haveEtebarList) {
		this.haveEtebarList = haveEtebarList;
	}

	public String getHaveLicenese() {
		return haveLicenese;
	}

	public void setHaveLicenese(String haveLicenese) {
		this.haveLicenese = haveLicenese;
	}

	public boolean isHaveMobasher() {
		return haveMobasher;
	}

	public void setHaveMobasher(boolean haveMobasher) {
		this.haveMobasher = haveMobasher;
	}

	public String getHaveEtebar() {
		return haveEtebar;
	}

	public void setHaveEtebar(String haveEtebar) {
		this.haveEtebar = haveEtebar;
	}

	public String getMerchantWatsup() {
		return merchantWatsup;
	}

	public void setMerchantWatsup(String merchantWatsup) {
		this.merchantWatsup = merchantWatsup;
	}

	public String getMerchantTwiter() {
		return merchantTwiter;
	}

	public void setMerchantTwiter(String merchantTwiter) {
		this.merchantTwiter = merchantTwiter;
	}

	public String getMerchantEtebarChange() {
		return merchantEtebarChange;
	}

	public void setMerchantEtebarChange(String merchantEtebarChange) {
		this.merchantEtebarChange = merchantEtebarChange;
	}

	public String getMerchantTelegramAddres() {
		return merchantTelegramAddres;
	}

	public void setMerchantTelegramAddres(String merchantTelegramAddres) {
		this.merchantTelegramAddres = merchantTelegramAddres;
	}

	public String getMerchantTelegramNumber() {
		return merchantTelegramNumber;
	}

	public void setMerchantTelegramNumber(String merchantTelegramNumber) {
		this.merchantTelegramNumber = merchantTelegramNumber;
	}

	public String getMerchantInstagramAddres() {
		return merchantInstagramAddres;
	}

	public void setMerchantInstagramAddres(String merchantInstagramAddres) {
		this.merchantInstagramAddres = merchantInstagramAddres;
	}

	public String getMerchantInstagramNumber() {
		return merchantInstagramNumber;
	}

	public void setMerchantInstagramNumber(String merchantInstagramNumber) {
		this.merchantInstagramNumber = merchantInstagramNumber;
	}

	public boolean isMerchantPicJavaz() {
		return merchantPicJavaz;
	}

	public void setMerchantPicJavaz(boolean merchantPicJavaz) {
		this.merchantPicJavaz = merchantPicJavaz;
	}

	public String getMerchantBirthDayChange() {
		return merchantBirthDayChange;
	}

	public void setMerchantBirthDayChange(String merchantBirthDayChange) {
		this.merchantBirthDayChange = merchantBirthDayChange;
	}

	public String getMerchantKhatemeChange() {
		return merchantKhatemeChange;
	}

	public void setMerchantKhatemeChange(String merchantCreditDateChange) {
		this.merchantKhatemeChange = merchantCreditDateChange;
	}

	public String getMerchantMobasherDateChange() {
		return merchantMobasherDateChange;
	}

	public void setMerchantMobasherDateChange(String merchantMobasherDateChange) {
		this.merchantMobasherDateChange = merchantMobasherDateChange;
	}

	public String getSearchSsn() {
		return searchSsn;
	}

	public void setSearchSsn(String searchSsn) {
		this.searchSsn = searchSsn;
	}

	public long getSearchShomareParvande() {
		return searchShomareParvande;
	}

	public void setSearchShomareParvande(long searchShomareParvande) {
		this.searchShomareParvande = searchShomareParvande;
	}

	public long getShomareParvande() {
		return shomareParPaano;
	}

	public void setShomareParvande(long shomareParvande) {
		this.shomareParPaano = shomareParvande;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	public List<String> getBrandName() {
		return brandName;
	}

	public void setBrandName(List<String> brandName) {
		this.brandName = brandName;
	}

	public boolean isTextboxRenderer() {
		return textboxRenderer;
	}

	public void setTextboxRenderer(boolean textboxRenderer) {
		this.textboxRenderer = textboxRenderer;
	}

	public MerchantEntity getMerchantEntity() {
		return merchantEntity;
	}

	public void setMerchantEntity(MerchantEntity merchantEntity) {
		this.merchantEntity = merchantEntity;
	}

	@Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;

	@Inject
	private AddBrandServiceLocal addBrandServiceLocal;

	public String getMerchantInterfaceNamee() {
		return merchantInterfaceNamee;
	}

	public void setMerchantInterfaceNamee(String merchantInterfaceNamee) {
		this.merchantInterfaceNamee = merchantInterfaceNamee;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantFamily() {
		return merchantFamily;
	}

	public void setMerchantFamily(String merchantFamily) {
		this.merchantFamily = merchantFamily;
	}

	public String getMerchantShoar() {
		return merchantShoar;
	}

	public void setMerchantShoar(String userName) {
		this.merchantShoar = userName;
	}

	public String getMerchantPass() {
		return merchantPass;
	}

	public void setMerchantPass(String merchantPass) {
		this.merchantPass = merchantPass;
	}

	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}

	public String getMerchantMobile() {
		return merchantMobile;
	}

	public void setMerchantMobile(String merchantMobile) {
		this.merchantMobile = merchantMobile;
	}

	public String getMerchantSsn() {
		return merchantSsn;
	}

	public void setMerchantSsn(String merchantSsn) {
		this.merchantSsn = merchantSsn;
	}

	public String getMerchantSaliManagerName() {
		return merchantSaliManagerName;
	}

	public void setMerchantSaliManagerName(String merchantSaliManagerName) {
		this.merchantSaliManagerName = merchantSaliManagerName;
	}

	public String getMerchantSailManagerMobile() {
		return merchantSailManagerMobile;
	}

	public void setMerchantSailManagerMobile(String merchantSailManagerMobile) {
		this.merchantSailManagerMobile = merchantSailManagerMobile;
	}

	public String getMerchantJobTitleInterface() {
		return merchantJobTitleInterface;
	}

	public void setMerchantJobTitleInterface(String merchantJobTitleInterface) {
		this.merchantJobTitleInterface = merchantJobTitleInterface;
	}

	public String getMerchantInterfaceMobile() {
		return merchantInterfaceMobile;
	}

	public void setMerchantInterfaceMobile(String merchantInterfaceMobile) {
		this.merchantInterfaceMobile = merchantInterfaceMobile;
	}

	public String getMerchantSocialNetworkNumber() {
		return merchantSocialNetworkNumber;
	}

	public void setMerchantSocialNetworkNumber(String merchantSocialNetworkNumber) {
		this.merchantSocialNetworkNumber = merchantSocialNetworkNumber;
	}

	public String getMerchantPostAddres() {
		return merchantPostAddres;
	}

	public void setMerchantPostAddres(String merchantPostAddres) {
		this.merchantPostAddres = merchantPostAddres;
	}

	public String getMerchantPostCode() {
		return merchantPostCode;
	}

	public void setMerchantPostCode(String merchantPostCode) {
		this.merchantPostCode = merchantPostCode;
	}

	public String getMerchantFax() {
		return merchantFax;
	}

	public void setMerchantFax(String merchantFax) {
		this.merchantFax = merchantFax;
	}

	public String getMerchantSiteAddres() {
		return merchantSiteAddres;
	}

	public void setMerchantSiteAddres(String merchantSiteAddres) {
		this.merchantSiteAddres = merchantSiteAddres;
	}

	public String getMerchantTelegram() {
		return merchantTelegram;
	}

	public void setMerchantTelegram(String merchantTelegram) {
		this.merchantTelegram = merchantTelegram;
	}

	public String getMerchantInstagram() {
		return merchantInstagram;
	}

	public void setMerchantInstagram(String merchantInstagram) {
		this.merchantInstagram = merchantInstagram;
	}

	public long getMerchantLicenseNumber() {
		return merchantLicenseNumber;
	}

	public void setMerchantLicenseNumber(long merchantLicenseNumber) {
		this.merchantLicenseNumber = merchantLicenseNumber;
	}

	public String getMerchantShopNamePer() {
		return merchantShopNamePer;
	}

	public void setMerchantShopNamePer(String merchantShopNamePer) {
		this.merchantShopNamePer = merchantShopNamePer;
	}

	public String getMerchantShopNameEng() {
		return merchantShopNameEng;
	}

	public void setMerchantShopNameEng(String merchantShopNameEng) {
		this.merchantShopNameEng = merchantShopNameEng;
	}

	public String getMerchantSrwardName() {
		return merchantSrwardName;
	}

	public void setMerchantSrwardName(String merchantSrwardName) {
		this.merchantSrwardName = merchantSrwardName;
	}

	public boolean isMerchantStewardShip() {
		return merchantStewardShip;
	}

	public void setMerchantStewardShip(boolean merchantStewardShip) {
		this.merchantStewardShip = merchantStewardShip;
	}

	public boolean isMerchantEMark() {
		return merchantEMark;
	}

	public void setMerchantEMark(boolean merchantEMark) {
		this.merchantEMark = merchantEMark;
	}

	public List<String> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<String> occupations) {
		this.occupations = occupations;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<String> getSocialNetworks() {
		return socialNetworks;
	}

	public void setSocialNetworks(List<String> socialNetworks) {
		this.socialNetworks = socialNetworks;
	}

	public List<String> getUnions() {
		return unions;
	}

	public void setUnions(List<String> unions) {
		this.unions = unions;
	}

	public List<String> getAreas() {
		return areas;
	}

	public void setAreas(List<String> areas) {
		this.areas = areas;
	}

	public List<String> getStates() {
		return states;
	}

	public void setStates(List<String> states) {
		this.states = states;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getSocialNetwork() {
		return socialNetwork;
	}

	public void setSocialNetwork(String socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	public String getUnion() {
		return union;
	}

	public void setUnion(String union) {
		this.union = union;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getGmapWhidth() {
		return gmapWhidth;
	}

	public void setGmapWhidth(double gmapWhidth) {
		this.gmapWhidth = gmapWhidth;
	}

	public double getGmapHeight() {
		return gmapHeight;
	}

	public void setGmapHeight(double gmapHeight) {
		this.gmapHeight = gmapHeight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Part getLogo() {
		return logo;
	}

	public void setLogo(Part logo) {
		this.logo = logo;
	}

	public long getShomareParPaano() {
		return shomareParPaano;
	}

	public void setShomareParPaano(long shomareParPaano) {
		this.shomareParPaano = shomareParPaano;
	}

	public long getShomareParUnion() {
		return shomareParUnion;
	}

	public void setShomareParUnion(long shomareParUnion) {
		this.shomareParUnion = shomareParUnion;
	}

	@PostConstruct
	public void addLists() {
		Area[] areas = Area.values();
		for (Area area : areas) {
			this.areas.add(area.getAreaName());

		}

		City[] cities = City.values();
		for (City city : cities) {
			this.cities.add(city.getCityName());
		}

		Group[] groups = Group.values();
		for (Group group : groups) {
			this.groups.add(group.getGroupName());
		}

		Occupation[] occupations = Occupation.values();
		for (Occupation occupation : occupations) {
			this.occupations.add(occupation.getOccName());
		}

		SocialNetwork[] socialNetwork = SocialNetwork.values();
		for (SocialNetwork socialNetwork2 : socialNetwork) {
			this.socialNetworks.add(socialNetwork2.getSocNetName());
		}

		State[] states = State.values();
		for (State state : states) {
			this.states.add(state.getStateName());
		}

		Union[] unions = Union.values();
		for (Union union : unions) {
			this.unions.add(union.getUnionName());
		}

		HaveEtebar[] haveEtebars = HaveEtebar.values();

		for (HaveEtebar haveEtebar : haveEtebars) {
			this.haveEtebarList.add(haveEtebar.getHete());
		}

		HaveLicense[] haveLicenses = HaveLicense.values();
		for (HaveLicense haveLicense : haveLicenses) {
			this.haveLicenceList.add(haveLicense.getHavel());
		}

	}

	public Part getLicenseImage() {
		return licenseImage;
	}

	public void setLicenseImage(Part licenseImage) {
		this.licenseImage = licenseImage;
	}

	public Part getShopImg1() {
		return shopImg1;
	}

	public void setShopImg1(Part shopImg1) {
		this.shopImg1 = shopImg1;
	}

	public Part getShopImg2() {
		return shopImg2;
	}

	public void setShopImg2(Part shopImg2) {
		this.shopImg2 = shopImg2;
	}

	public Part getShopImg3() {
		return shopImg3;
	}

	public void setShopImg3(Part shopImg3) {
		this.shopImg3 = shopImg3;
	}

	public Part getShopImg4() {
		return shopImg4;
	}

	public void setShopImg4(Part shopImg4) {
		this.shopImg4 = shopImg4;
	}

	// *****************************************Convert Persian To English
	// Calendar**************************************

	public Date jalali_to_gregorian(int jy, int jm, int jd) {
		int gy;
		if (jy > 979) {
			gy = 1600;
			jy -= 979;
		} else {
			gy = 621;
		}
		int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd
				+ ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
		gy += 400 * ((int) (days / 146097));
		days %= 146097;
		if (days > 36524) {
			gy += 100 * ((int) (--days / 36524));
			days %= 36524;
			if (days >= 365)
				days++;
		}
		gy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			gy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int gd = days + 1;
		int[] sal_a = { 0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		int gm;
		for (gm = 0; gm < 13; gm++) {
			int v = sal_a[gm];
			if (gd <= v)
				break;
			gd -= v;
		}
		int[] out = { gy, gm, gd };
		System.err.println("year:" + gy);
		System.err.println("month:" + gm);
		System.err.println("day:" + gd);
		// Date date=new Date(gy,gm,gd);
		Calendar calendar = new GregorianCalendar(gy, gm - 1, gd);
		Date date = new Date();
		date = calendar.getTime();
		return date;
	}

	public Date changeDate() {
		String test = this.merchantBirthDayChange;
		String arr[] = test.split("-");
		String ans = "";

		for (String t : arr) {
			ans += t;
		}
		System.err.println(ans);
		char[] daychar = new char[2];
		char[] monthchar = new char[2];
		char[] yearchar = new char[4];
		ans.getChars(0, 4, yearchar, 0);
		String yearstr = "";
		String monthstr = "";
		String daystr = "";
		for (char c : yearchar) {
			yearstr += c;
		}
		System.err.println(yearstr);

		ans.getChars(4, 6, monthchar, 0);
		for (char cc : monthchar) {
			monthstr += cc;
		}
		System.err.println(monthstr);

		ans.getChars(6, 8, daychar, 0);
		for (char ccc : daychar) {
			daystr += ccc;
		}
		System.err.println(daystr);

		return jalali_to_gregorian(Integer.parseInt(yearstr), Integer.parseInt(monthstr), Integer.parseInt(daystr));

	}

	public Date jalali_to_gregorian2(int jy, int jm, int jd) {
		int gy;
		if (jy > 979) {
			gy = 1600;
			jy -= 979;
		} else {
			gy = 621;
		}
		int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd
				+ ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
		gy += 400 * ((int) (days / 146097));
		days %= 146097;
		if (days > 36524) {
			gy += 100 * ((int) (--days / 36524));
			days %= 36524;
			if (days >= 365)
				days++;
		}
		gy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			gy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int gd = days + 1;
		int[] sal_a = { 0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		int gm;
		for (gm = 0; gm < 13; gm++) {
			int v = sal_a[gm];
			if (gd <= v)
				break;
			gd -= v;
		}
		int[] out = { gy, gm, gd };
		System.err.println("year:" + gy);
		System.err.println("month:" + gm);
		System.err.println("day:" + gd);
		// Date date=new Date(gy,gm,gd);
		Calendar calendar = new GregorianCalendar(gy, gm - 1, gd);
		Date date = new Date();
		date = calendar.getTime();
		return date;
	}

	public Date changeDate2() {
		String test = this.merchantKhatemeChange;
		String arr[] = test.split("-");
		String ans = "";

		for (String t : arr) {
			ans += t;
		}
		System.err.println(ans);
		char[] daychar = new char[2];
		char[] monthchar = new char[2];
		char[] yearchar = new char[4];
		ans.getChars(0, 4, yearchar, 0);
		String yearstr = "";
		String monthstr = "";
		String daystr = "";
		for (char c : yearchar) {
			yearstr += c;
		}

		ans.getChars(4, 6, monthchar, 0);
		for (char cc : monthchar) {
			monthstr += cc;
		}

		ans.getChars(6, 8, daychar, 0);
		for (char ccc : daychar) {
			daystr += ccc;
		}

		return jalali_to_gregorian2(Integer.parseInt(yearstr), Integer.parseInt(monthstr), Integer.parseInt(daystr));

	}

	public Date jalali_to_gregorian3(int jy, int jm, int jd) {
		int gy;
		if (jy > 979) {
			gy = 1600;
			jy -= 979;
		} else {
			gy = 621;
		}
		int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd
				+ ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
		gy += 400 * ((int) (days / 146097));
		days %= 146097;
		if (days > 36524) {
			gy += 100 * ((int) (--days / 36524));
			days %= 36524;
			if (days >= 365)
				days++;
		}
		gy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			gy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int gd = days + 1;
		int[] sal_a = { 0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		int gm;
		for (gm = 0; gm < 13; gm++) {
			int v = sal_a[gm];
			if (gd <= v)
				break;
			gd -= v;
		}
		int[] out = { gy, gm, gd };
		// Date date=new Date(gy,gm,gd);
		Calendar calendar = new GregorianCalendar(gy, gm - 1, gd);
		Date date = new Date();
		date = calendar.getTime();
		return date;
	}

	public Date changeDate3() {
		String test = this.merchantMobasherDateChange;
		String arr[] = test.split("-");
		String ans = "";

		for (String t : arr) {
			ans += t;
		}
		char[] daychar = new char[2];
		char[] monthchar = new char[2];
		char[] yearchar = new char[4];
		ans.getChars(0, 4, yearchar, 0);
		String yearstr = "";
		String monthstr = "";
		String daystr = "";
		for (char c : yearchar) {
			yearstr += c;
		}

		ans.getChars(4, 6, monthchar, 0);
		for (char cc : monthchar) {
			monthstr += cc;
		}

		ans.getChars(6, 8, daychar, 0);
		for (char ccc : daychar) {
			daystr += ccc;
		}

		return jalali_to_gregorian3(Integer.parseInt(yearstr), Integer.parseInt(monthstr), Integer.parseInt(daystr));

	}

	public Date jalali_to_gregorian4(int jy, int jm, int jd) {
		int gy;
		if (jy > 979) {
			gy = 1600;
			jy -= 979;
		} else {
			gy = 621;
		}
		int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd
				+ ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
		gy += 400 * ((int) (days / 146097));
		days %= 146097;
		if (days > 36524) {
			gy += 100 * ((int) (--days / 36524));
			days %= 36524;
			if (days >= 365)
				days++;
		}
		gy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			gy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int gd = days + 1;
		int[] sal_a = { 0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		int gm;
		for (gm = 0; gm < 13; gm++) {
			int v = sal_a[gm];
			if (gd <= v)
				break;
			gd -= v;
		}
		int[] out = { gy, gm, gd };
		Calendar calendar = new GregorianCalendar(gy, gm - 1, gd);
		Date date = new Date();
		date = calendar.getTime();
		return date;
	}

	public Date changeDate4() {
		String test = this.merchantEtebarChange;
		String arr[] = test.split("-");
		String ans = "";

		for (String t : arr) {
			ans += t;
		}
		char[] daychar = new char[2];
		char[] monthchar = new char[2];
		char[] yearchar = new char[4];
		ans.getChars(0, 4, yearchar, 0);
		String yearstr = "";
		String monthstr = "";
		String daystr = "";
		for (char c : yearchar) {
			yearstr += c;
		}

		ans.getChars(4, 6, monthchar, 0);
		for (char cc : monthchar) {
			monthstr += cc;
		}

		ans.getChars(6, 8, daychar, 0);
		for (char ccc : daychar) {
			daystr += ccc;
		}

		return jalali_to_gregorian3(Integer.parseInt(yearstr), Integer.parseInt(monthstr), Integer.parseInt(daystr));

	}

	public Date jalali_to_gregorian5(int jy, int jm, int jd) {
		int gy;
		if (jy > 979) {
			gy = 1600;
			jy -= 979;
		} else {
			gy = 621;
		}
		int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd
				+ ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
		gy += 400 * ((int) (days / 146097));
		days %= 146097;
		if (days > 36524) {
			gy += 100 * ((int) (--days / 36524));
			days %= 36524;
			if (days >= 365)
				days++;
		}
		gy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			gy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int gd = days + 1;
		int[] sal_a = { 0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		int gm;
		for (gm = 0; gm < 13; gm++) {
			int v = sal_a[gm];
			if (gd <= v)
				break;
			gd -= v;
		}
		int[] out = { gy, gm, gd };

		Calendar calendar = new GregorianCalendar(gy, gm - 1, gd);
		Date date = new Date();
		date = calendar.getTime();
		return date;
	}

	public Date changeDate5() {
		String test = this.merchantGarardadChange;
		String arr[] = test.split("-");
		String ans = "";

		for (String t : arr) {
			ans += t;
		}
		char[] daychar = new char[2];
		char[] monthchar = new char[2];
		char[] yearchar = new char[4];
		ans.getChars(0, 4, yearchar, 0);
		String yearstr = "";
		String monthstr = "";
		String daystr = "";
		for (char c : yearchar) {
			yearstr += c;
		}

		ans.getChars(4, 6, monthchar, 0);
		for (char cc : monthchar) {
			monthstr += cc;
		}

		ans.getChars(6, 8, daychar, 0);
		for (char ccc : daychar) {
			daystr += ccc;
		}

		return jalali_to_gregorian3(Integer.parseInt(yearstr), Integer.parseInt(monthstr), Integer.parseInt(daystr));

	}

	public Date jalali_to_gregorian6(int jy, int jm, int jd) {
		int gy;
		if (jy > 979) {
			gy = 1600;
			jy -= 979;
		} else {
			gy = 621;
		}
		int days = (365 * jy) + (((int) (jy / 33)) * 8) + ((int) (((jy % 33) + 3) / 4)) + 78 + jd
				+ ((jm < 7) ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
		gy += 400 * ((int) (days / 146097));
		days %= 146097;
		if (days > 36524) {
			gy += 100 * ((int) (--days / 36524));
			days %= 36524;
			if (days >= 365)
				days++;
		}
		gy += 4 * ((int) (days / 1461));
		days %= 1461;
		if (days > 365) {
			gy += (int) ((days - 1) / 365);
			days = (days - 1) % 365;
		}
		int gd = days + 1;
		int[] sal_a = { 0, 31, ((gy % 4 == 0 && gy % 100 != 0) || (gy % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31,
				30, 31, 30, 31 };
		int gm;
		for (gm = 0; gm < 13; gm++) {
			int v = sal_a[gm];
			if (gd <= v)
				break;
			gd -= v;
		}
		int[] out = { gy, gm, gd };
		Calendar calendar = new GregorianCalendar(gy, gm - 1, gd);
		Date date = new Date();
		date = calendar.getTime();
		return date;
	}

	public Date changeDate6() {
		String test = this.merchantStartChange;
		String arr[] = test.split("-");
		String ans = "";

		for (String t : arr) {
			ans += t;
		}
		System.err.println(ans);
		char[] daychar = new char[2];
		char[] monthchar = new char[2];
		char[] yearchar = new char[4];
		ans.getChars(0, 4, yearchar, 0);
		String yearstr = "";
		String monthstr = "";
		String daystr = "";
		for (char c : yearchar) {
			yearstr += c;
		}

		ans.getChars(4, 6, monthchar, 0);
		for (char cc : monthchar) {
			monthstr += cc;
		}

		ans.getChars(6, 8, daychar, 0);
		for (char ccc : daychar) {
			daystr += ccc;
		}

		return jalali_to_gregorian3(Integer.parseInt(yearstr), Integer.parseInt(monthstr), Integer.parseInt(daystr));

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

	// *****************************************growl
	// message*****************************

	/*
	 * public void saveMessage() { FacesContext context =
	 * FacesContext.getCurrentInstance();
	 * 
	 * context.addMessage(null, new FacesMessage("Successful") ); }
	 */

	// **********************************************brand**********************

	public String convertBrand() {
		String brands = "";
		for (String brand : this.brandName) {
			brands += brand + "-";
		}
		return brands;
	}

	public List<BrandEntity> findMerchantBrands(String shopName) {
		try {
			String[] barandParts = merchantRegisterServiceLocal.findMerchantByShopNameEng(shopName).getBrands()
					.split("-");
			for (String string : barandParts) {
				this.brandPartList.add(addBrandServiceLocal.findBrandByName(string));
			}
			return this.brandPartList;
		} catch (Exception e) {
			return null;
		}
	}
	

	public List<BrandEntity> findMerchantBrands2(String shopName) {

		
			String[] barandParts= {};
			try {
		for (MerchantEntity merchantEntity : singletonServiceLocal.getMerchantList()) {
			if(merchantEntity.getMerchantShopNameEng().equals(shopName)) {
				barandParts=merchantEntity.getBrands().split("-");
				for (String string : barandParts) {
					this.brandPartList.add(this.findBrandByName(string));
				}
			}
			}
		return this.brandPartList;
		}catch (Exception e) {
			return new ArrayList<>();
			}
	}
	public BrandEntity findBrandByName(String brandName) {
		for (BrandEntity brandEntity : singletonServiceLocal.getBrandList()) {
			if(brandEntity.getBrandName().equals(brandName)) {
			 this.brand2=brandEntity;
			}
		}
		return this.brand2;
	}

	// **********************************************brand**********************

	public void insertToMarchantEntity() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		// try {
		/// merchantRegisterServiceLocal.findMerchantBySsn(merchantSsn);
		// context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
		// "Error!", "Contact admin."));
		// } catch (Exception e) {
		// try {
		// merchantRegisterServiceLocal.findMerchantByShomareParvande(shomareParPaano);
		// context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
		// "Error!", "Contact admin."));
		// } catch (Exception e2) {
		// try {
		// merchantRegisterServiceLocal.findMerchantByShopNameEng(merchantShopNameEng);
		// context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
		// "Error!", "Contact admin."));
		// } catch (Exception e1) {
		MerchantEntity merchantEntity = new MerchantEntity();
		merchantEntity.setMerchantName(merchantName);
		merchantEntity.setMerchantFamily(merchantFamily);
		merchantEntity.setMerchantShoar(merchantShoar);
		merchantEntity.setMerchantPass(merchantPass);
		merchantEntity.setMerchantPhone(merchantPhone);
		merchantEntity.setMerchantEmail(merchantEmail);
		merchantEntity.setMerchantMobile(merchantMobile);
		merchantEntity.setMerchantSsn(merchantSsn);
		merchantEntity.setMerchantGroup(group);
		merchantEntity.setMerchantSaliManagerName(merchantSaliManagerName);
		merchantEntity.setMerchantSailManagerMobile(merchantSailManagerMobile);
		merchantEntity.setMerchantّInterfaceName(merchantInterfaceNamee);
		merchantEntity.setMerchantInterfaceMobile(merchantInterfaceMobile);
		merchantEntity.setMerchantFax(merchantFax);
		merchantEntity.setMerchantSiteAddres(merchantSiteAddres);
		merchantEntity.setMerchantTelegramAddres(merchantTelegram);
		merchantEntity.setMerchantInstagramAddres(merchantInstagram);
		merchantEntity.setMerchantLicenseNumber(merchantLicenseNumber);
		merchantEntity.setMerchantShopNameEng(merchantShopNameEng);
		merchantEntity.setMerchantShopNamePer(merchantShopNamePer);
		merchantEntity.setMerchantMobasherName(merchantSrwardName);
		merchantEntity.setMerchantRaste(occupation);
		merchantEntity.setMerchantEtehadie(union);
		merchantEntity.setMerchantMobasherat(merchantStewardShip);
		merchantEntity.setMerchantEMark(merchantEMark);
		merchantEntity.setShomarehParPaano(shomareParPaano);
		try {
		merchantEntity.setMerchantBirthDay(changeDate());
		}catch(Exception e) {
			merchantEntity.setMerchantBirthDay(null);
		}
		// merchantEntity.setMerchantKhateme(changeDate2());
		// merchantEntity.setMerchantMobasherDate(changeDate3());
		try {
		merchantEntity.setMerchantEtebar(changeDate4());
		}catch (Exception e) {
			merchantEntity.setMerchantEtebar(null);
		}
		try {
		merchantEntity.setMerchantGarardad(changeDate5());
		}catch (Exception e) {
			merchantEntity.setMerchantGarardad(null);
		}
		// merchantEntity.setMerchantStart(changeDate6());
		merchantEntity.setMerchantInstagramAddres(merchantInstagramAddres);
		merchantEntity.setMerchantInstagramNumber(merchantInstagramNumber);
		merchantEntity.setMerchantTelegramAddres(merchantTelegramAddres);
		merchantEntity.setMerchantTelegramNumber(merchantTelegramNumber);
		merchantEntity.setMerchantPicJavaz(merchantPicJavaz);
		merchantEntity.setMerchantDescription(description);
		merchantEntity.setMerchantWatsup(merchantWatsup);
		merchantEntity.setMerchantTwiter(merchantTwiter);
		merchantEntity.setHaveEtebar(haveEtebar);
		merchantEntity.setHaveLicenese(haveLicenese);
		merchantEntity.setHaveMobasher(haveMobasher);
		merchantEntity.setPhoneShow(phoneShow);
		merchantEntity.setFaxShow(faxShow);
		merchantEntity.setInstagramShow(instagramShow);
		merchantEntity.setTelegramShow(telegramShow);
		merchantEntity.setSiteShow(siteShow);
		merchantEntity.setWatsupShow(watsupShow);
		merchantEntity.setTwiterShow(twiterShow);
		merchantEntity.setHaveLogo(haveLogo);
		merchantEntity.setShomarehParUnion(shomareParUnion);
		merchantEntity.setBrands(this.convertBrand());
		try {
		byte[] licenseByte = IOUtils.toByteArray(licenseImage.getInputStream());
		merchantEntity.setLicenceImg(licenseByte);
		}catch (Exception e) {
			merchantEntity.setLicenceImg(null);
		}
		try {
		byte[] shop1Byte = IOUtils.toByteArray(shopImg1.getInputStream());
		merchantEntity.setShopImg2(shop1Byte);
		}catch (Exception e) {
			merchantEntity.setShopImg2(null);
		}
		try {
		byte[] shop2Byte = IOUtils.toByteArray(shopImg2.getInputStream());
		merchantEntity.setShopImg3(shop2Byte);
		}catch (Exception e) {
			merchantEntity.setShopImg3(null);
		}
		try {
		byte[] shop3Byte = IOUtils.toByteArray(shopImg3.getInputStream());
		merchantEntity.setShopImg4(shop3Byte);
		}catch (Exception e) {
			merchantEntity.setShopImg4(null);
		}
		try {
		byte[] shop4Byte = IOUtils.toByteArray(shopImg4.getInputStream());
		merchantEntity.setShopImg5(shop4Byte);
		}catch (Exception e) {
			merchantEntity.setShopImg5(null);
		}
		try {
		byte[] logoByte = IOUtils.toByteArray(logo.getInputStream());
		merchantEntity.setLogo(logoByte);
		}catch (Exception e) {
			merchantEntity.setLogo(null);
		}
		
		try {
			System.err.println(this.brands);
			merchantRegisterServiceLocal.insertToMarchantEntity(merchantEntity);
		} catch (MerchantRegisterException e3) {
			System.err.println("nnnnnnnnnnnnnnnnnnnnnnnnnn");
		}
		context.addMessage(null, new FacesMessage("Successful"));
	}
	// }

	// }
	// }

	// ***************************************Find Merchants*******************8

	public List<MerchantEntity> findAllMerchants() {
		return merchantRegisterServiceLocal.findAllMErchantEntity();
	}

	public MerchantEntity findMerchantById(long merchantId) {
		try {
			return merchantRegisterServiceLocal.findMerchantById(merchantId);
		} catch (Exception e) {
			System.err.println("merchant not find");
			return null;
		}

	}

	// ***************************************Update**************************

	public void updateMerchantEntityName(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantName(merchantName);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntityFamily(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantFamily(merchantFamily);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntityShoar(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantShoar(merchantShoar);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntityPhone(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantPhone(merchantPhone);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntityEmail(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantEmail(merchantEmail);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntityMobile(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantMobile(merchantMobile);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntitySsn(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantSsn(merchantSsn);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntityGroup(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantGroup(group);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntitySaliManagerName(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantSaliManagerName(merchantSaliManagerName);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntitySailManagerMobile(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantSailManagerMobile(merchantSailManagerMobile);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntityInterfaceNamee(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantّInterfaceName(merchantInterfaceNamee);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEntityJobTitleInterface(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		/*
		 * merchantEntity.setMerchantJobTitleInterface(merchantJobTitleInterface);
		 */ try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantInterfaceMobile(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantInterfaceMobile(merchantInterfaceMobile);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantSocialNetworkNumber(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		// merchantEntity.setMerchantSocialNetworkNumber(merchantSocialNetworkNumber);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantFax(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantFax(merchantFax);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantSiteAddres(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantSiteAddres(merchantSiteAddres);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantTelegram(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantTelegramAddres(merchantTelegramAddres);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateInstagramAddres(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantInstagramAddres(merchantInstagramAddres);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantLicenseNumber(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantLicenseNumber(merchantLicenseNumber);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantShopNameEng(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantShopNameEng(merchantShopNameEng);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantShopNamePer(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantShopNamePer(merchantShopNamePer);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantMobasherName(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantMobasherName(merchantSrwardName);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantBirthDay(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantBirthDay(changeDate());
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantCreditDate(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantGarardad(changeDate5());
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantMobasheratDate(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantMobasherDate(changeDate3());
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantRaste(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantRaste(occupation);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantSocialNEtwork(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		// merchantEntity.setMerchantSocialNEtwork(socialNetwork);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEtehadie(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantEtehadie(union);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantMobasherat(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantMobasherat(merchantStewardShip);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantEMark(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantEMark(merchantEMark);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantDescription(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantDescription(description);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantShomareParvande(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setShomarehParPaano(shomareParPaano);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantPass(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantPass(merchantPass);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantInterfaceName(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantّInterfaceName(merchantInterfaceNamee);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantGroup(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantGroup(group);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantBrand(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setBrands(this.convertBrand());
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateTelegramNumber(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantTelegramNumber(merchantTelegramNumber);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateInstagramNumber(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantInstagramNumber(merchantInstagramNumber);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateTwiter(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantTwiter(merchantTwiter);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateWatsup(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setMerchantWatsup(merchantWatsup);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateShowPhone(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setPhoneShow(phoneShow);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateShowFax(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setFaxShow(faxShow);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}
	
	public void updateShowSite(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setSiteShow(siteShow);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}
	
	public void updateShowInstagram(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setInstagramShow(instagramShow);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}
	
	public void updateShowTelegram(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setTelegramShow(telegramShow);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}
	
	public void updateShowWatsup(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setWatsupShow(watsupShow);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}
	
	public void updateShowTwiter(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setTwiterShow(twiterShow);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}
	
	public void updateShowMobile(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantEntity.setHaveLogo(haveLogo);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	// *****************************************update
	// pictures*****************************************

	public void updateMerchantImg1(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		byte[] licenseByte = IOUtils.toByteArray(licenseImage.getInputStream());
		merchantEntity.setLicenceImg(licenseByte);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantImg2(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		byte[] shop1Byte = IOUtils.toByteArray(shopImg1.getInputStream());
		merchantEntity.setShopImg2(shop1Byte);

		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantImg3(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);

		byte[] shop2Byte = IOUtils.toByteArray(shopImg2.getInputStream());

		merchantEntity.setShopImg3(shop2Byte);

		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantImg4(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);

		byte[] shop3Byte = IOUtils.toByteArray(shopImg3.getInputStream());
		merchantEntity.setShopImg4(shop3Byte);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	public void updateMerchantImg5(String merchantId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		byte[] shop4Byte = IOUtils.toByteArray(shopImg4.getInputStream());
		merchantEntity.setShopImg5(shop4Byte);
		try {
			merchantRegisterServiceLocal.updateMerchantEntity(merchantEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("merchantedit.xhtml" + "?merchantID=" + merchantId);
	}

	// *********************************************************English to Persian
	// Calendar******************************

	public String convertToJalali1(String merchantId) {
		try {
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		String dateEng = merchantEntity.getMerchantBirthDay().toString();
		System.err.println(dateEng);
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

	public String convertToJalali2(String merchantId) {
		try {
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		String dateEng = merchantEntity.getMerchantGarardad().toString();
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

	public String convertToJalali3(String merchantId) {
		try {
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		String dateEng = merchantEntity.getMerchantEtebar().toString();
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

	// **********************************Delete*************************

	public void deleteMerchantEntity(String merchantId) throws IOException {
		MerchantEntity merchantEntity = new MerchantEntity();
		long id = Long.parseLong(merchantId);
		merchantEntity = this.findMerchantById(id);
		merchantRegisterServiceLocal.deleteMerchantEntity(merchantEntity);
		FacesContext.getCurrentInstance().getExternalContext().redirect("viewmerchant.xhtml");
	}

	// ************************************SEarch*************************************

	/*
	 * public MerchantEntity findMerchantByShomareParvande(){ FacesContext context =
	 * FacesContext.getCurrentInstance();
	 * 
	 * return merchantRegisterServiceLocal.findMerchantByShomareParvande(
	 * searchShomareParvande);
	 * 
	 * }
	 */

	public MerchantEntity findMerchantBySsn() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			return merchantRegisterServiceLocal.findMerchantBySsn(merchantSsn);
		} catch (Exception e) {
			return null;

		}
	}

	public String findSsnAndGoPage() {
		return "merchantedit.xhtml?merchantID=" + findMerchantBySsn().getMerchantId() + "&faces-redirect=true";
	}

	/*
	 * public String findShomareParAndGoPage() { return
	 * "merchantedit.xhtml?merchantID="+
	 * findMerchantByShomareParvande().getMerchantId() + "&faces-redirect=true"; }
	 */
	
	
	
	
	public boolean isImg1(long merchantId) {
		
		return Arrays.equals(this.findMerchantById(merchantId).getLicenceImg(), null);
	}
	public boolean isImg2(long merchantId) {
		
		return Arrays.equals(this.findMerchantById(merchantId).getShopImg2(), null);
	}
	public boolean isImg3(long merchantId) {
		
		return Arrays.equals(this.findMerchantById(merchantId).getShopImg3(), null);
	}
	public boolean isImg4(long merchantId) {
		
		return Arrays.equals(this.findMerchantById(merchantId).getShopImg4(), null);
	}
	public boolean isImg5(long merchantId) {
		
		return Arrays.equals(this.findMerchantById(merchantId).getShopImg5(), null);
	}

}
