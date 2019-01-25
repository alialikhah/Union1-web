package jsfui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

import dao.entity.MerchantEntity;
import service.MerchantRegisterServiceLocal;
import service.MerchantResultServiceLocal;
import service.SingletonServiceLocal;

@Named
@ViewScoped
public class MerchantResultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public MerchantResultBean() {
		// TODO Auto-generated constructor stub
	}
	private float widthStr;
	private float heightStr;
	private List<MerchantEntity> allRaste=new ArrayList<>();
	
	@Inject
	private MerchantResultServiceLocal merchantResultServiceLocal;
    @Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;
	
	private List<MerchantEntity> merchantEntitiesFilter=new ArrayList<>();
	@Inject
    private SingletonServiceLocal singletonServiceLocal;




	public float getWidthStr() {
		return widthStr;
	}



	public void setWidthStr(float widthStr) {
		this.widthStr = widthStr;
	}



	public float getHeightStr() {
		return heightStr;
	}



	public void setHeightStr(float heightStr) {
		this.heightStr = heightStr;
	}



	public List<MerchantEntity> getAllRaste() {
		return allRaste;
	}



	public void setAllRaste(List<MerchantEntity> allRaste) {
		this.allRaste = allRaste;
	}
	
	

	public List<MerchantEntity> getMerchantEntitiesFilter() {
		return merchantEntitiesFilter;
	}



	public void setMerchantEntitiesFilter(List<MerchantEntity> merchantEntitiesFilter) {
		this.merchantEntitiesFilter = merchantEntitiesFilter;
	}



	public List<MerchantEntity> findAllMerchant(){
		return merchantRegisterServiceLocal.findAllMErchantEntity();
	}

	public List<MerchantEntity> findMerchantByRaste(String raste){
		if(raste.equals("موبایل و لوازم جانبی"))
		//return merchantResultServiceLocal.findMerchantByRaste(raste);
		return singletonServiceLocal.getMerchantMobileList();
		else if (raste.equals("صوتی و تصویری و خانگی"))
		return singletonServiceLocal.getMerchantKhanegiList();
		else if (raste.equals("صوتی و تصویری اتومبیل"))
		return singletonServiceLocal.getMerchantCarList();
		else if (raste.equals("آلات موسیقی"))
		return singletonServiceLocal.getMerchantMusicList();
		else if (raste.equals("قطعات الکترونیک"))
		return singletonServiceLocal.getMerchantElecList();
		else if (raste.equals("دوربین عکاسی و فیلم برداری"))
		return singletonServiceLocal.getMerchantCamList();
		else if (raste.equals("دوربین مدار بسته"))
		return singletonServiceLocal.getMerchantCctvList();
		else if (raste.equals("سی دی"))
		return singletonServiceLocal.getMerchantCctvList();
		else
			return null;
	}

	
	public List<MerchantEntity> findMerchantGold(String raste){
		if(raste.equals("موبایل و لوازم جانبی"))
		//return merchantResultServiceLocal.findMerchantByRaste(raste);
		return singletonServiceLocal.getMerchantMobileListGold();
		else if (raste.equals("صوتی و تصویری و خانگی"))
		return singletonServiceLocal.getMerchantKhanegiListGold();
		else if (raste.equals("صوتی و تصویری اتومبیل"))
		return singletonServiceLocal.getMerchantCarListGold();
		else if (raste.equals("آلات موسیقی"))
		return singletonServiceLocal.getMerchantMusicListGold();
		else if (raste.equals("قطعات الکترونیک"))
		return singletonServiceLocal.getMerchantElecListGold();
		else if (raste.equals("دوربین عکاسی و فیلم برداری"))
		return singletonServiceLocal.getMerchantCamListGold();
		else if (raste.equals("دوربین مدار بسته"))
		return singletonServiceLocal.getMerchantCctvListGold();
		else if (raste.equals("سی دی"))
		return singletonServiceLocal.getMerchantCctvListGold();
		else
			return null;
	}

	
    public void onPointSelect(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        this.widthStr=(float) latlng.getLat();
        this.heightStr=(float) latlng.getLng();
        
  }
	

	
}
