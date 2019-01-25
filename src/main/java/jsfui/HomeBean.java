package jsfui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.CommercialEntity;
import dao.entity.HomeEntity;
import dao.entity.SliderEntity;
import service.CommercialServiceLocal;
import service.HomeServiceLocal;
import service.SingletonServiceLocal;
import service.SliderServiceLocal;

@Named
@SessionScoped
public class HomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private SliderServiceLocal sliderServiceLocal;
	@Inject
	private CommercialServiceLocal commercialServiceLocal;
	@Inject
	private SingletonServiceLocal singletonServiceLocal;
	@Inject
	private HomeServiceLocal homeServiceLocal;
	
	
	private long onLineUser;
	
	private List<byte[]> slider=new ArrayList<>();

	
	
	
	
	public long getOnLineUser() {
		this.onLineUser=singletonServiceLocal.getOnlineUser();
		return onLineUser;
	}





	public List<byte[]> getSlider() {
		return slider;
	}


	public void setSlider(List<byte[]> slider) {
		this.slider = slider;
	}
	
	
	
	@PostConstruct
	public void init() {
		for (SliderEntity sliderEntity : sliderServiceLocal.findAllSlider()) {
			this.slider.add(sliderEntity.getSliderImage());
		}
	singletonServiceLocal.setOnlineUser(1);
	}
	
	public List<SliderEntity> findAllSlider(){
		return sliderServiceLocal.findAllSlider();
	}

	
	public List<CommercialEntity> findAllComm(){
	return commercialServiceLocal.findAllCommercial();	
	}
	
	
	
	
	
	@PreDestroy
	public void destroy() {
		HomeEntity homeEntity=new HomeEntity();
		
	 homeServiceLocal.inserToHomeEntity(homeEntity);
	}
	
	
	
	
	
}
