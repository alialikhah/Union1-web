package jsfui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.entity.RentEntity;
import service.RentServiceLocal;

@Named
@ViewScoped
public class RentBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6812319423856259667L;



	public RentBean() {
		// TODO Auto-generated constructor stub
	}

	private String rentType;
	private String homeType;
	private String address;
	private String vage;
	private String mogeiat;
	private String tedadTabage;
	private String tedadVahed;
	private String vadieeMoney;
	private String ejareMony;
	private List<String> emkanat = new ArrayList<>();
	private List<String> vaziatSanad = new ArrayList<>();
	private String senBana;
	private String masahat;
	private String vaziatMelk;
	private String description;
	private boolean parvane;
	private String etehadieName;
	private String phone;
	private Part pic1;
	private boolean show;
	
	@Inject
	private RentServiceLocal rentServiceLocal;
	
	

	public Part getPic1() {
		return pic1;
	}

	public void setPic1(Part pic1) {
		this.pic1 = pic1;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVage() {
		return vage;
	}

	public void setVage(String vage) {
		this.vage = vage;
	}

	public String getMogeiat() {
		return mogeiat;
	}

	public void setMogeiat(String mogeiat) {
		this.mogeiat = mogeiat;
	}

	public List<String> getEmkanat() {
		return emkanat;
	}

	public void setEmkanat(List<String> emkanat) {
		this.emkanat = emkanat;
	}

	public String getMasahat() {
		return masahat;
	}

	public void setMasahat(String masahat) {
		this.masahat = masahat;
	}

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

	public String getTedadTabage() {
		return tedadTabage;
	}

	public void setTedadTabage(String tedadTabage) {
		this.tedadTabage = tedadTabage;
	}

	public String getTedadVahed() {
		return tedadVahed;
	}

	public void setTedadVahed(String tedadVahed) {
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

	public List<String> getVaziatSanad() {
		return vaziatSanad;
	}

	public void setVaziatSanad(List<String> vaziatSanad) {
		this.vaziatSanad = vaziatSanad;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String convertEmkanat() {
		String emkanatAll = "";
		for (String string : this.emkanat) {
			emkanatAll += string + "-";
		}
		return emkanatAll;
	}
	
	public String convertVaziateSanad() {
		String vaziateSanad = "";
		for (String string : this.vaziatSanad) {
			vaziateSanad+=string + "-";
		}
		return vaziateSanad;
	}

	public void insertToRent() {
		FacesContext context = FacesContext.getCurrentInstance();
		RentEntity rentEntity = new RentEntity();
		rentEntity.setDescription(description);
		rentEntity.setEjareMony(Integer.parseInt(ejareMony));
		rentEntity.setEmkanat(convertEmkanat());
		rentEntity.setEtehadieName(etehadieName);
		rentEntity.setHomeType(homeType);
		rentEntity.setMasahat(Integer.parseInt(masahat));
		rentEntity.setMogeiat(mogeiat);
		rentEntity.setParvane(parvane);
		rentEntity.setPhone(phone);
		rentEntity.setAddress(address);
		try {
			byte[] pivByte = IOUtils.toByteArray(pic1.getInputStream());
			rentEntity.setPic1(pivByte);
		} catch (IOException e) {
			System.err.println("Error in image");
			rentEntity.setPic1(null);
		}
		rentEntity.setRentType(rentType);
		rentEntity.setSenBana(Integer.parseInt(senBana));
		rentEntity.setTedadTabage(Integer.parseInt(tedadTabage));
		rentEntity.setTedadVahed(Integer.parseInt(tedadVahed));
		rentEntity.setVadieeMoney(Integer.parseInt(vadieeMoney));
		rentEntity.setVage(vage);
		rentEntity.setVaziatMelk(vaziatMelk);
		rentEntity.setVaziatSanad(convertVaziateSanad());
		rentServiceLocal.insertToRent(rentEntity);	
		context.addMessage(null, new FacesMessage("با موفقیت ثبت گردید."));
		this.address="";
		this.description="";
		this.ejareMony="";
		this.emkanat.clear();
		this.etehadieName="";
		this.homeType="";
		this.masahat="";
		this.parvane=false;
		this.mogeiat="";
		this.phone="";
		this.rentType="";
		this.senBana="";
		this.tedadTabage="";
		this.tedadVahed="";
		this.vage="";
		this.vaziatMelk="";
		this.vaziatSanad.clear();
	}
	
    
	public List<RentEntity> findAllRent(){
    return rentServiceLocal.findAllRent();	
    }
	
	public RentEntity findRentById(long rentId) {
		return rentServiceLocal.findRentById(rentId);
	}
	
	public void deleteRent(long rentId) throws IOException {
		RentEntity rentEntity=new RentEntity();
		rentEntity=rentServiceLocal.findRentById(rentId);
		rentServiceLocal.deleteRent(rentEntity);
		FacesContext.getCurrentInstance().getExternalContext().redirect("rentview.xhtml");

	}
	
    public void updateRent(long rentId) throws IOException {
    	RentEntity rentEntity2=new RentEntity();
    	rentEntity2=rentServiceLocal.findRentById(rentId);
    	rentEntity2.setShow(show);
    	rentServiceLocal.updateRent(rentEntity2);
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("rentedit.xhtml" + "?rent=" + rentId);
    }
	

}
