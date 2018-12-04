package jsfui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

import Exceptions.PanooRoleBackException;
import dao.entity.MerchantAddresEntity;
import dao.entity.MerchantEntity;
import service.MerchantAddresServiceLocal;
import service.MerchantRegisterServiceLocal;
import service.SingletonServiceLocal;

@Named
@SessionScoped
public class MerchantAddres implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MerchantAddres() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private MerchantAddresServiceLocal merchantAddresServiceLocal;
	@Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;
	@Inject
	private SingletonServiceLocal singletonServiceLocal;
	
	private double width=0;
	private double height=0;
	private String area;
	private String state;
	private String city;
	private String postAddres;
	private String postCode;
	private List<String> areas=new ArrayList<>();
	private List<String> states =new ArrayList<>();
	private List<String> cities=new ArrayList<>();
	private long merchantId;
	private String widthStr;
	private String heightStr;
	
	private String areaU;
	private String stateU;
	private String cityU;
	private String postAddresU;
	private String postCodeU;
	private String widthStrU;
	private String heightStrU;
	
	private MerchantAddresEntity merchantAddresEntity;
	
	
	
	public MerchantAddresEntity getMerchantAddresEntity() {
		return merchantAddresEntity;
	}

	public void setMerchantAddresEntity(MerchantAddresEntity merchantAddresEntity) {
		this.merchantAddresEntity = merchantAddresEntity;
	}

	public String getWidthStr() {
		return widthStr;
	}

	public void setWidthStr(String widthStr) {
		this.widthStr = widthStr;
	}

	public String getHeightStr() {
		return heightStr;
	}

	public void setHeightStr(String heightStr) {
		this.heightStr = heightStr;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostAddres() {
		return postAddres;
	}

	public void setPostAddres(String postAddres) {
		this.postAddres = postAddres;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public void prnt(String width,String height){
		System.err.println("************************salam************************");
		System.err.println(width + "<><><><>" + height);
	}
	
	
	
	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	@PostConstruct
	public void addLists(){
				System.err.println("OOOOOOOOOOOmerchantAddresOOOOOOOOO");
		Area[] areas=Area.values();
		for (Area area : areas) {
			this.areas.add(area.getAreaName());
		}
		
		City[] cities=City.values();
		for (City city : cities) {
			this.cities.add(city.getCityName());
		}
		
		State[] states=State.values();
		for (State state : states) {
			this.states.add(state.getStateName());
		}
		

	}
	
	
	
    public String getAreaU() {
		return areaU;
	}

	public void setAreaU(String areaU) {
		this.areaU = areaU;
	}

	public String getStateU() {
		return stateU;
	}

	public void setStateU(String stateU) {
		this.stateU = stateU;
	}

	public String getCityU() {
		return cityU;
	}

	public void setCityU(String cityU) {
		this.cityU = cityU;
	}

	public String getPostAddresU() {
		return postAddresU;
	}

	public void setPostAddresU(String postAddresU) {
		this.postAddresU = postAddresU;
	}

	public String getPostCodeU() {
		return postCodeU;
	}

	public void setPostCodeU(String postCodeU) {
		this.postCodeU = postCodeU;
	}

	public String getWidthStrU() {
		return widthStrU;
	}

	public void setWidthStrU(String widthStrU) {
		this.widthStrU = widthStrU;
	}

	public String getHeightStrU() {
		return heightStrU;
	}

	public void setHeightStrU(String heightStrU) {
		this.heightStrU = heightStrU;
	}

	public MerchantEntity findMerchantById(long merchantId){
    	try {
			return merchantRegisterServiceLocal.findMerchantById(merchantId);
		} catch (Exception e) {
			System.err.println("merchant not find");
            return null;
		}
    	
    }
    
    public MerchantAddresEntity findAddresByMerchant(String merchantId){
    	long id=Long.parseLong(merchantId);
    	try {
    		return merchantAddresServiceLocal.findAddresByMerchant(findMerchantById(id));
		} catch (Exception e) {
			MerchantAddresEntity merchantAddresEntity=new MerchantAddresEntity();
			return merchantAddresEntity;
		}
    	
    }
    
    public MerchantAddresEntity findAddresByMerchant(long merchantId) throws PanooRoleBackException {
    	return merchantAddresServiceLocal.findAddresByMerchant(findMerchantById(merchantId));
    }
    
    public MerchantAddresEntity findAddresByMerchant2(long merchantId){
    	try {
    		return merchantAddresServiceLocal.findAddresByMerchant(findMerchantById(merchantId));
		} catch (Exception e) {
			System.err.println("addres not find");
			return null;
		}
    }
    
    public MerchantAddresEntity findAddresByMerchant3(long merchantId) {
    	this.merchantAddresEntity=null;
    	for (MerchantAddresEntity merchantAddresEntity:singletonServiceLocal.getMerchantAddresList()) {
			if(merchantAddresEntity.getMerchantaddr().getMerchantId()==merchantId) {
				this.merchantAddresEntity=merchantAddresEntity;
			}
		}
    	return this.merchantAddresEntity;
    }
    
    public boolean isAddrs(long merchantId) {
	    	try {
	    	merchantAddresServiceLocal.findAddresByMerchant(findMerchantById(merchantId));
    		return true;
    		}catch (Exception e) {
			return false;
			}

    }
    
    
	
	
    public void insetToMerchantAddres(long merchantId){
    	FacesContext context = FacesContext.getCurrentInstance();
    	MerchantAddresEntity merchantAddresEntity=new MerchantAddresEntity();
    	MerchantEntity merchantEntity=new MerchantEntity();
    	try {
			merchantEntity=merchantRegisterServiceLocal.findMerchantById(merchantId);
		} catch (Exception e) {
            System.err.println("merchant not find");
		}
    	try {
			findAddresByMerchant(merchantId);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"آدرس برای این کاربر وجود دارد",  ""));
		} catch (PanooRoleBackException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	    	System.err.println(merchantEntity.getMerchantName()+"***********************************");
	    	merchantAddresEntity.setMerchandWidth(Double.parseDouble(widthStr));
	    	merchantAddresEntity.setMerchantHeight(Double.parseDouble(heightStr));
	    	merchantAddresEntity.setMerchantArea(area);
	    	merchantAddresEntity.setMerchantCity(city);
	    	merchantAddresEntity.setMerchantState(state);
	    	merchantAddresEntity.setMerchantPostAddres(postAddres);
	    	merchantAddresEntity.setMerchantPostCode(postCode);
	    	merchantAddresEntity.setDastance(Math.sqrt(((Double.parseDouble(widthStr))*(Double.parseDouble(widthStr)))+((Double.parseDouble(heightStr))*(Double.parseDouble(heightStr)))));
	    	merchantAddresEntity.setMerchantaddr(merchantEntity);
    		merchantAddresServiceLocal.insetToMerchantAddres(merchantAddresEntity);
    		context.addMessage(null, new FacesMessage("Successful") );
		}    	
    }

    
	public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful") );
    }
	
	public void out(){
		System.err.println(this.width + "UUUUUUUUUUU" + this.height);
	}
	
	public void insertToMId(long merchantId){
		this.merchantId=merchantId;
		System.err.println("oooooooooooook");
	}
	
    
    public void onPointSelect(PointSelectEvent event) {
          LatLng latlng = event.getLatLng();
          this.widthStr=String.valueOf(latlng.getLat());
          this.heightStr=String.valueOf(latlng.getLng());
    }

    
    
    
    
    public void updateAddresPostAddres(String merchantId) throws IOException{
    	MerchantAddresEntity merchantAddresEntity=new MerchantAddresEntity();	
    	merchantAddresEntity=findAddresByMerchant(merchantId);
    	merchantAddresEntity.setMerchantPostAddres(postAddresU);
    	merchantAddresServiceLocal.updateMerchantAddre(merchantAddresEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect( "addresedit.xhtml"+"?merchantID=" + merchantId );
    }

    
    
    public void updateAddresPostCode(String merchantId) throws IOException{
    	MerchantAddresEntity merchantAddresEntity=new MerchantAddresEntity();	
    	merchantAddresEntity=findAddresByMerchant(merchantId);
    	merchantAddresEntity.setMerchantPostCode(postCodeU);
    	merchantAddresServiceLocal.updateMerchantAddre(merchantAddresEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect( "addresedit.xhtml"+"?merchantID=" + merchantId );
    }
    
    
    public void updateAddresPostCity(String merchantId) throws IOException{
    	MerchantAddresEntity merchantAddresEntity=new MerchantAddresEntity();	
    	merchantAddresEntity=findAddresByMerchant(merchantId);
    	merchantAddresEntity.setMerchantCity(cityU);
    	merchantAddresServiceLocal.updateMerchantAddre(merchantAddresEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect( "addresedit.xhtml"+"?merchantID=" + merchantId );
    }
    
    
    public void updateAddresPostArea(String merchantId) throws IOException{
    	MerchantAddresEntity merchantAddresEntity=new MerchantAddresEntity();	
    	merchantAddresEntity=findAddresByMerchant(merchantId);
    	merchantAddresEntity.setMerchantArea(areaU);
    	merchantAddresServiceLocal.updateMerchantAddre(merchantAddresEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect( "addresedit.xhtml"+"?merchantID=" + merchantId );
    }
    
    
    public void updateAddresPostState(String merchantId) throws IOException{
    	MerchantAddresEntity merchantAddresEntity=new MerchantAddresEntity();	
    	merchantAddresEntity=findAddresByMerchant(merchantId);
    	merchantAddresEntity.setMerchantState(stateU);
    	merchantAddresServiceLocal.updateMerchantAddre(merchantAddresEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect( "addresedit.xhtml"+"?merchantID=" + merchantId );
    }
	
    public void updateAddresGmap(String merchantId) throws IOException{
    	MerchantAddresEntity merchantAddresEntity=new MerchantAddresEntity();	
    	merchantAddresEntity=findAddresByMerchant(merchantId);
    	merchantAddresEntity.setMerchandWidth(Double.parseDouble(widthStr));
    	merchantAddresEntity.setMerchantHeight(Double.parseDouble(heightStr));
    	merchantAddresServiceLocal.updateMerchantAddre(merchantAddresEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect( "addresedit.xhtml"+"?merchantID=" + merchantId );
    }
	
	

}
