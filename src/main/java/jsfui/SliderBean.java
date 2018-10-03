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

import dao.entity.NaghdOBaresiEntity;
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
    	try {
			sliderEntity=sliderServiceLocal.findSliderById(sliderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("slider not find");
		}
    	sliderServiceLocal.deleteSlider(sliderEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("addslider.xhtml" );
    }
    
    
    
    public SliderEntity findSliderById(long sliderId) {
    	try {
			return sliderServiceLocal.findSliderById(sliderId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("slider not find");
			return null;
		}
		
    }
    
	public void updateSliderTitle(long slideId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		SliderEntity sliderEntity=new SliderEntity();

		try {
			sliderEntity=sliderServiceLocal.findSliderById(slideId);
			sliderEntity.setSliderTitle(sliderTitle);
			sliderServiceLocal.updateSlider(sliderEntity);
		} catch (Exception e) {
			System.err.println("slide not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("slideredit.xhtml" + "?slideId=" + slideId);
	}
    
    
	public void updateSliderImg(long slideId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		SliderEntity sliderEntity=new SliderEntity();
		try {
			sliderEntity=sliderServiceLocal.findSliderById(slideId);
			byte[] img2Byte = IOUtils.toByteArray(sliderImg.getInputStream());
			sliderEntity.setSliderImage(img2Byte);
			sliderServiceLocal.updateSlider(sliderEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("slideredit.xhtml" + "?slideId=" + slideId);
	}
}
