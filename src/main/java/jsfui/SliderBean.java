package jsfui;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.entity.SliderEntity;
import service.SliderServiceLocal;

@Named
@RequestScoped
public class SliderBean {

	public SliderBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SliderServiceLocal sliderServiceLocal;
	
	private Part sliderImg;
	private String sliderTitle;
	public Part getSliderImg() {
		return sliderImg;
	}
	public void setSliderImg(Part sliderImg) {
		this.sliderImg = sliderImg;
	}
	public String getSliderTitle() {
		return sliderTitle;
	}
	public void setSliderTitle(String sliderTitle) {
		this.sliderTitle = sliderTitle;
	}
	
	public void insertToSlider() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		SliderEntity sliderEntity=new SliderEntity();
		sliderEntity.setSliderTitle(sliderTitle);
		byte[] sliderImgByte=IOUtils.toByteArray(sliderImg.getInputStream());
		sliderEntity.setSliderImage(sliderImgByte);
		sliderServiceLocal.insertToSlider(sliderEntity);
		context.addMessage(null, new FacesMessage("Successful"));
		
	}
	
	public List<SliderEntity> findAllSlider(){
		return sliderServiceLocal.findAllSlider();
	}
	
    
    public void deleteSlider(long sliderId) throws IOException {
    	SliderEntity sliderEntity=new SliderEntity();
    	sliderEntity=sliderServiceLocal.findSliderById(sliderId);
    	sliderServiceLocal.deleteSlider(sliderEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("addslider.xhtml" );
    }
    
    
    
    public SliderEntity findSliderById(long sliderId) {
    	return sliderServiceLocal.findSliderById(sliderId);
    }
    
    
	
}
