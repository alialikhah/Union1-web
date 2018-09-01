package jsfui;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.entity.MojtameEntity;
import dao.entity.NaghdOBaresiEntity;
import service.MojtameServiceLocal;

@Named
@RequestScoped
public class MojtameBean {

	public MojtameBean() {
		// TODO Auto-generated constructor stub
	}
	private String category;
	private String mojtameTitle;
	private String mojtameHead1;
	private String mojtameText1;
	private String mojtameHead2;
	private String mojtameText2;
	private String mojtameHead3;
	private String mojtameText3;
	private String mojtameHead4;
	private String mojtameText4;
	private String mojtameHead5;
	private String mojtameText5;
	private Part pic1;
	private Part pic2;
	private Part pic3;
	private Part pic4;
	private Part pic5;
	@Inject
	private MojtameServiceLocal mojtameServiceLocal;
	
	
	
	 public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public String getMojtameTitle() {
		return mojtameTitle;
	}





	public void setMojtameTitle(String mojtameTitle) {
		this.mojtameTitle = mojtameTitle;
	}





	public String getMojtameHead1() {
		return mojtameHead1;
	}





	public void setMojtameHead1(String mojtameHead1) {
		this.mojtameHead1 = mojtameHead1;
	}





	public String getMojtameText1() {
		return mojtameText1;
	}





	public void setMojtameText1(String mojtameText1) {
		this.mojtameText1 = mojtameText1;
	}





	public String getMojtameHead2() {
		return mojtameHead2;
	}





	public void setMojtameHead2(String mojtameHead2) {
		this.mojtameHead2 = mojtameHead2;
	}





	public String getMojtameText2() {
		return mojtameText2;
	}





	public void setMojtameText2(String mojtameText2) {
		this.mojtameText2 = mojtameText2;
	}





	public String getMojtameHead3() {
		return mojtameHead3;
	}





	public void setMojtameHead3(String mojtameHead3) {
		this.mojtameHead3 = mojtameHead3;
	}





	public String getMojtameText3() {
		return mojtameText3;
	}





	public void setMojtameText3(String mojtameText3) {
		this.mojtameText3 = mojtameText3;
	}





	public String getMojtameHead4() {
		return mojtameHead4;
	}





	public void setMojtameHead4(String mojtameHead4) {
		this.mojtameHead4 = mojtameHead4;
	}





	public String getMojtameText4() {
		return mojtameText4;
	}





	public void setMojtameText4(String mojtameText4) {
		this.mojtameText4 = mojtameText4;
	}





	public String getMojtameHead5() {
		return mojtameHead5;
	}





	public void setMojtameHead5(String mojtameHead5) {
		this.mojtameHead5 = mojtameHead5;
	}





	public String getMojtameText5() {
		return mojtameText5;
	}





	public void setMojtameText5(String mojtameText5) {
		this.mojtameText5 = mojtameText5;
	}





	public Part getPic1() {
		return pic1;
	}





	public void setPic1(Part pic1) {
		this.pic1 = pic1;
	}





	public Part getPic2() {
		return pic2;
	}





	public void setPic2(Part pic2) {
		this.pic2 = pic2;
	}





	public Part getPic3() {
		return pic3;
	}





	public void setPic3(Part pic3) {
		this.pic3 = pic3;
	}





	public Part getPic4() {
		return pic4;
	}





	public void setPic4(Part pic4) {
		this.pic4 = pic4;
	}





	public Part getPic5() {
		return pic5;
	}





	public void setPic5(Part pic5) {
		this.pic5 = pic5;
	}





	public void insertToMojtame() throws IOException {
		MojtameEntity mojtameEntity=new MojtameEntity();
		mojtameEntity.setCategory(category);
		mojtameEntity.setMojtameHead1(mojtameHead1);
		mojtameEntity.setMojtameHead2(mojtameHead2);
		mojtameEntity.setMojtameHead3(mojtameHead3);
		mojtameEntity.setMojtameHead4(mojtameHead4);
		mojtameEntity.setMojtameHead5(mojtameHead5);
		mojtameEntity.setMojtameText1(mojtameText1);
		mojtameEntity.setMojtameText2(mojtameText2);
		mojtameEntity.setMojtameText3(mojtameText3);
		mojtameEntity.setMojtameText4(mojtameText4);
		mojtameEntity.setMojtameText5(mojtameText5);
		mojtameEntity.setMojtameTitle(mojtameTitle);
    	byte[] img1=IOUtils.toByteArray(pic1.getInputStream());
    	byte[] img2=IOUtils.toByteArray(pic2.getInputStream());
    	byte[] img3=IOUtils.toByteArray(pic3.getInputStream());
    	byte[] img4=IOUtils.toByteArray(pic4.getInputStream());
    	byte[] img5=IOUtils.toByteArray(pic5.getInputStream());
    	mojtameEntity.setMojtamePic1(img1);
    	mojtameEntity.setMojtamePic2(img2);
    	mojtameEntity.setMojtamePic3(img3);
    	mojtameEntity.setMojtamePic4(img4);
    	mojtameEntity.setMojtamePic5(img5);
		mojtameServiceLocal.insertToMojtame(mojtameEntity);
	}
	
    
	public List<MojtameEntity> findAllMojtame(){
    	return mojtameServiceLocal.findAllMojtame();
    }
	
    public void deleteMojtameEntity(long mojtameId) throws IOException{
    	MojtameEntity mojtameEntity=new MojtameEntity();
    	mojtameEntity=mojtameServiceLocal.findMojtameById(mojtameId);
    	mojtameServiceLocal.deleteMojtameEntity(mojtameEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("addmojtame.xhtml" );
    }

}