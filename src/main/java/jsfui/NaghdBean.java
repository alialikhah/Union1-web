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

import dao.entity.MashahirEntity;
import dao.entity.NaghdOBaresiEntity;
import service.NaghdServiceLocal;

@Named
@RequestScoped
public class NaghdBean {

	public NaghdBean() {
		// TODO Auto-generated constructor stub
	}
	
	private String category;
	private String naghdTitle;
	private String naghdHead1;
	private String naghdText1;
	private String naghdHead2;
	private String naghdText2;
	private String naghdHead3;
	private String naghdText3;
	private String naghdHead4;
	private String naghdText4;
	private String naghdHead5;
	private String naghdText5;
	private Part pic1;
	private Part pic2;
	private Part pic3;
	private Part pic4;
	private Part pic5;
	private Part pic6;
	private Part pic7;
	private Part pic8;
	private Part pic9;
	private Part pic10;
	@Inject
	private NaghdServiceLocal naghdServiceLocal;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getNaghdTitle() {
		return naghdTitle;
	}
	public void setNaghdTitle(String naghdTitle) {
		this.naghdTitle = naghdTitle;
	}
	public String getNaghdHead1() {
		return naghdHead1;
	}
	public void setNaghdHead1(String naghdHead1) {
		this.naghdHead1 = naghdHead1;
	}
	public String getNaghdText1() {
		return naghdText1;
	}
	public void setNaghdText1(String naghdText1) {
		this.naghdText1 = naghdText1;
	}
	public String getNaghdHead2() {
		return naghdHead2;
	}
	public void setNaghdHead2(String naghdHead2) {
		this.naghdHead2 = naghdHead2;
	}
	public String getNaghdText2() {
		return naghdText2;
	}
	public void setNaghdText2(String naghdText2) {
		this.naghdText2 = naghdText2;
	}
	public String getNaghdHead3() {
		return naghdHead3;
	}
	public void setNaghdHead3(String naghdHead3) {
		this.naghdHead3 = naghdHead3;
	}
	public String getNaghdText3() {
		return naghdText3;
	}
	public void setNaghdText3(String naghdText3) {
		this.naghdText3 = naghdText3;
	}
	public String getNaghdHead4() {
		return naghdHead4;
	}
	public void setNaghdHead4(String naghdHead4) {
		this.naghdHead4 = naghdHead4;
	}
	public String getNaghdText4() {
		return naghdText4;
	}
	public void setNaghdText4(String naghdText4) {
		this.naghdText4 = naghdText4;
	}
	public String getNaghdHead5() {
		return naghdHead5;
	}
	public void setNaghdHead5(String naghdHead5) {
		this.naghdHead5 = naghdHead5;
	}
	public String getNaghdText5() {
		return naghdText5;
	}
	public void setNaghdText5(String naghdText5) {
		this.naghdText5 = naghdText5;
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
	
	
	
	
	public Part getPic6() {
		return pic6;
	}
	public void setPic6(Part pic6) {
		this.pic6 = pic6;
	}
	public Part getPic7() {
		return pic7;
	}
	public void setPic7(Part pic7) {
		this.pic7 = pic7;
	}
	public Part getPic8() {
		return pic8;
	}
	public void setPic8(Part pic8) {
		this.pic8 = pic8;
	}
	public Part getPic9() {
		return pic9;
	}
	public void setPic9(Part pic9) {
		this.pic9 = pic9;
	}
	public Part getPic10() {
		return pic10;
	}
	public void setPic10(Part pic10) {
		this.pic10 = pic10;
	}
	public void insertToNaghd() throws IOException {
    	NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();
    	naghdOBaresiEntity.setNaghdHead1(naghdHead1);
    	naghdOBaresiEntity.setNaghdHead2(naghdHead2);
    	naghdOBaresiEntity.setNaghdHead3(naghdHead3);
    	naghdOBaresiEntity.setNaghdHead4(naghdHead4);
    	naghdOBaresiEntity.setNaghdHead5(naghdHead5);
    	naghdOBaresiEntity.setCategory(category);
    	naghdOBaresiEntity.setNaghdTitle(naghdTitle);
    	naghdOBaresiEntity.setNaghdText1(naghdText1);
    	naghdOBaresiEntity.setNaghdText2(naghdText2);
    	naghdOBaresiEntity.setNaghdText3(naghdText3);
    	naghdOBaresiEntity.setNaghdText4(naghdText4);
    	naghdOBaresiEntity.setNaghdText5(naghdText5);
    	byte[] img1=IOUtils.toByteArray(pic1.getInputStream());
    	byte[] img2=IOUtils.toByteArray(pic2.getInputStream());
    	byte[] img3=IOUtils.toByteArray(pic3.getInputStream());
    	byte[] img4=IOUtils.toByteArray(pic4.getInputStream());
    	byte[] img5=IOUtils.toByteArray(pic5.getInputStream());
    	byte[] img6=IOUtils.toByteArray(pic6.getInputStream());
    	byte[] img7=IOUtils.toByteArray(pic7.getInputStream());
    	byte[] img8=IOUtils.toByteArray(pic8.getInputStream());
    	byte[] img9=IOUtils.toByteArray(pic9.getInputStream());
    	byte[] img10=IOUtils.toByteArray(pic10.getInputStream());
    	naghdOBaresiEntity.setNaghdPic1(img1);
    	naghdOBaresiEntity.setNaghdPic2(img2);
    	naghdOBaresiEntity.setNaghdPic3(img3);
    	naghdOBaresiEntity.setNaghdPic4(img4);
    	naghdOBaresiEntity.setNaghdPic5(img5);
    	naghdOBaresiEntity.setNaghdPic6(img6);
    	naghdOBaresiEntity.setNaghdPic7(img7);
    	naghdOBaresiEntity.setNaghdPic8(img8);
    	naghdOBaresiEntity.setNaghdPic9(img9);
    	naghdOBaresiEntity.setNaghdPic10(img10);
    	naghdServiceLocal.insertToNaghd(naghdOBaresiEntity);
    }
	
	public List<NaghdOBaresiEntity> findAllNaghd(){
		return naghdServiceLocal.findAllNaghd();
	}
	
	public NaghdOBaresiEntity findNagdById(long nagdId) {
		return naghdServiceLocal.findNagdByID(nagdId);
	}
	
    public void deleteNAghdEntity(long naghdId) throws IOException{
    	NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();
    	naghdOBaresiEntity=naghdServiceLocal.findNagdByID(naghdId);
    	naghdServiceLocal.deleteNaghdEntity(naghdOBaresiEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("addnaghd.xhtml" );
    }
    
    
	public void updateNagdImg1(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity = new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity = naghdServiceLocal.findNagdByID(naghdId);
			byte[] img1Byte = IOUtils.toByteArray(pic1.getInputStream());
			naghdOBaresiEntity.setNaghdPic1(img1Byte);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}
	
	public void updateNagdImg2(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity = new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity = naghdServiceLocal.findNagdByID(naghdId);
			byte[] img2Byte = IOUtils.toByteArray(pic2.getInputStream());
			naghdOBaresiEntity.setNaghdPic2(img2Byte);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}
	
	public void updateNagdTitle(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity=naghdServiceLocal.findNagdByID(naghdId);
			naghdOBaresiEntity.setNaghdTitle(naghdTitle);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}
	
	public void updateNagdHead1(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity=naghdServiceLocal.findNagdByID(naghdId);
			naghdOBaresiEntity.setNaghdHead1(naghdHead1);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}
	
	public void updateNagdText1(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity=naghdServiceLocal.findNagdByID(naghdId);
			naghdOBaresiEntity.setNaghdText1(naghdText1);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}
	
	public void updateNagdText2(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity=naghdServiceLocal.findNagdByID(naghdId);
			naghdOBaresiEntity.setNaghdText2(naghdText2);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}
	
	public void updateNagdText3(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity=naghdServiceLocal.findNagdByID(naghdId);
			naghdOBaresiEntity.setNaghdText3(naghdText3);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}
	
	public void updateNagdText4(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity=naghdServiceLocal.findNagdByID(naghdId);
			naghdOBaresiEntity.setNaghdText4(naghdText4);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}
	
	public void updateNagdText5(long naghdId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NaghdOBaresiEntity naghdOBaresiEntity=new NaghdOBaresiEntity();

		try {
			naghdOBaresiEntity=naghdServiceLocal.findNagdByID(naghdId);
			naghdOBaresiEntity.setNaghdText5(naghdText5);
			naghdServiceLocal.updateNagd(naghdOBaresiEntity);
		} catch (Exception e) {
			System.err.println("nagd not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("nagdedit.xhtml" + "?naghdId=" + naghdId);
	}

}
