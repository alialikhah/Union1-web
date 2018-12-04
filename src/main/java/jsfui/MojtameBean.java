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
import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.LatLng;

import dao.entity.MojtameEntity;
import dao.entity.NaghdOBaresiEntity;
import service.MojtameServiceLocal;
import service.SingletonServiceLocal;

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
	private double gmapWhidth;
	private double gmapHeight;
	@Inject
	private MojtameServiceLocal mojtameServiceLocal;
	@Inject
	private SingletonServiceLocal singletonServiceLocal;

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

	public void insertToMojtame() throws IOException {
		MojtameEntity mojtameEntity = new MojtameEntity();
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
		mojtameEntity.setGmapWhidth(gmapWhidth);
		mojtameEntity.setGmapHeight(gmapHeight);
		byte[] img1 = IOUtils.toByteArray(pic1.getInputStream());
		mojtameEntity.setMojtamePic1(img1);
		byte[] img2 = IOUtils.toByteArray(pic2.getInputStream());
		mojtameEntity.setMojtamePic2(img2);
		mojtameServiceLocal.insertToMojtame(mojtameEntity);
	}

	public List<MojtameEntity> findAllMojtame() {
		//return mojtameServiceLocal.findAllMojtame();
		return singletonServiceLocal.getMojtameEntities();
	}

	public void deleteMojtameEntity(long mojtameId) throws IOException {
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		mojtameServiceLocal.deleteMojtameEntity(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext().redirect("addmojtame.xhtml");
	}

	public void updateMojtamaTitle(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		mojtameEntity.setMojtameTitle(mojtameTitle);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public void updateMojtamaText1(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		mojtameEntity.setMojtameText1(mojtameText1);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public void updateMojtamaText2(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		mojtameEntity.setMojtameText2(mojtameText2);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public void updateMojtamaText3(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		mojtameEntity.setMojtameText3(mojtameText3);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public void updateMojtamaText4(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		mojtameEntity.setMojtameText4(mojtameText4);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public void updateMojtamaText5(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		mojtameEntity.setMojtameText5(mojtameText5);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public void updateMojtamaHead1(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		mojtameEntity.setMojtameHead1(mojtameHead1);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public void updateMojtamaPic1(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		byte[] pic1Byte = IOUtils.toByteArray(pic1.getInputStream());
		mojtameEntity.setMojtamePic1(pic1Byte);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public void updateMojtamaPic2(long mojtameId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MojtameEntity mojtameEntity = new MojtameEntity();
		mojtameEntity = mojtameServiceLocal.findMojtameById(mojtameId);
		byte[] pic2Byte = IOUtils.toByteArray(pic2.getInputStream());
		mojtameEntity.setMojtamePic2(pic2Byte);
		mojtameServiceLocal.updateMojtama(mojtameEntity);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mojtamaedit.xhtml" + "?mojtameId=" + mojtameId);
	}
	
	public MojtameEntity findMojtamaById(long mojtamaId) {
		//return mojtameServiceLocal.findMojtameById(mojtamaId);
		MojtameEntity mojtameEntityX=new MojtameEntity();
		for (MojtameEntity mojtameEntity : singletonServiceLocal.getMojtameEntities()) {
			if(mojtameEntity.getMojtameId()==mojtamaId)
				mojtameEntityX=mojtameEntity;
		}
		return mojtameEntityX;
	}
	
    public void onPointSelect(PointSelectEvent event) {
        LatLng latlng = event.getLatLng();
        this.gmapWhidth=latlng.getLat();
        this.gmapHeight=latlng.getLng();
  }
}
