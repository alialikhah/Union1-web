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

import dao.entity.MashahirEngEntity;
import dao.entity.MashahirEntity;
import service.MashahirEngServiceLocal;
import service.MashahirServiceLocal;

@Named
@RequestScoped
public class MashahirEngBean {

	public MashahirEngBean() {
		// TODO Auto-generated constructor stub
	}
	
	private String mashahirEngHead1;
	private String mashahirEngText1;
	private String mashahirEngHead2;
	private String mashahirEngText2;
	private String mashahirEngHead3;
	private String mashahirEngText3;
	private String mashahirEngHead4;
	private String mashahirEngText4;
	private String mashahirEngHead5;
	private String mashahirEngText5;
	private Part mashahirEngImg1;
	private Part mashahirEngImg2;
	private Part mashahirEngImg3;
	private Part mashahirEngImg4;
	private Part mashahirEngImg5;
	private Part mashahirEngImg6;
	private String mashahirEngName;
	@Inject
	private MashahirEngServiceLocal mashahirEngServiceLocal;
	public String getMashahirEngHead1() {
		return mashahirEngHead1;
	}
	public void setMashahirEngHead1(String mashahirEngHead1) {
		this.mashahirEngHead1 = mashahirEngHead1;
	}
	public String getMashahirEngText1() {
		return mashahirEngText1;
	}
	public void setMashahirEngText1(String mashahirEngText1) {
		this.mashahirEngText1 = mashahirEngText1;
	}
	public String getMashahirEngHead2() {
		return mashahirEngHead2;
	}
	public void setMashahirEngHead2(String mashahirEngHead2) {
		this.mashahirEngHead2 = mashahirEngHead2;
	}
	public String getMashahirEngText2() {
		return mashahirEngText2;
	}
	public void setMashahirEngText2(String mashahirEngText2) {
		this.mashahirEngText2 = mashahirEngText2;
	}
	public String getMashahirEngHead3() {
		return mashahirEngHead3;
	}
	public void setMashahirEngHead3(String mashahirEngHead3) {
		this.mashahirEngHead3 = mashahirEngHead3;
	}
	public String getMashahirEngText3() {
		return mashahirEngText3;
	}
	public void setMashahirEngText3(String mashahirEngText3) {
		this.mashahirEngText3 = mashahirEngText3;
	}
	public String getMashahirEngHead4() {
		return mashahirEngHead4;
	}
	public void setMashahirEngHead4(String mashahirEngHead4) {
		this.mashahirEngHead4 = mashahirEngHead4;
	}
	public String getMashahirEngText4() {
		return mashahirEngText4;
	}
	public void setMashahirEngText4(String mashahirEngText4) {
		this.mashahirEngText4 = mashahirEngText4;
	}
	public String getMashahirEngHead5() {
		return mashahirEngHead5;
	}
	public void setMashahirEngHead5(String mashahirEngHead5) {
		this.mashahirEngHead5 = mashahirEngHead5;
	}
	public String getMashahirEngText5() {
		return mashahirEngText5;
	}
	public void setMashahirEngText5(String mashahirEngText5) {
		this.mashahirEngText5 = mashahirEngText5;
	}
	public Part getMashahirEngImg1() {
		return mashahirEngImg1;
	}
	public void setMashahirEngImg1(Part mashahirEngImg1) {
		this.mashahirEngImg1 = mashahirEngImg1;
	}
	public Part getMashahirEngImg2() {
		return mashahirEngImg2;
	}
	public void setMashahirEngImg2(Part mashahirEngImg2) {
		this.mashahirEngImg2 = mashahirEngImg2;
	}
	public Part getMashahirEngImg3() {
		return mashahirEngImg3;
	}
	public void setMashahirEngImg3(Part mashahirEngImg3) {
		this.mashahirEngImg3 = mashahirEngImg3;
	}
	public Part getMashahirEngImg4() {
		return mashahirEngImg4;
	}
	public void setMashahirEngImg4(Part mashahirEngImg4) {
		this.mashahirEngImg4 = mashahirEngImg4;
	}
	public Part getMashahirEngImg5() {
		return mashahirEngImg5;
	}
	public void setMashahirEngImg5(Part mashahirEngImg5) {
		this.mashahirEngImg5 = mashahirEngImg5;
	}
	public Part getMashahirEngImg6() {
		return mashahirEngImg6;
	}
	public void setMashahirEngImg6(Part mashahirEngImg6) {
		this.mashahirEngImg6 = mashahirEngImg6;
	}
	public String getMashahirEngName() {
		return mashahirEngName;
	}
	public void setMashahirEngName(String mashahirEngName) {
		this.mashahirEngName = mashahirEngName;
	}
	
	public void insertToMashahirEng() throws IOException {
    	FacesContext context = FacesContext.getCurrentInstance();
    	MashahirEngEntity mashahirEngEntity2=new MashahirEngEntity();
    	mashahirEngEntity2.setMashahirEngHead1(mashahirEngHead1);
    	mashahirEngEntity2.setMashahirEngHead2(mashahirEngHead2);
    	mashahirEngEntity2.setMashahirEngHead3(mashahirEngHead3);
    	mashahirEngEntity2.setMashahirEngHead4(mashahirEngHead4);
    	mashahirEngEntity2.setMashahirEngHead5(mashahirEngHead5);
    	mashahirEngEntity2.setMashahirEngText1(mashahirEngText1);
    	mashahirEngEntity2.setMashahirEngText2(mashahirEngText2);
    	mashahirEngEntity2.setMashahirEngText3(mashahirEngText3);
    	mashahirEngEntity2.setMashahirEngText4(mashahirEngText4);
    	mashahirEngEntity2.setMashahirEngText5(mashahirEngText5);
    	byte[] imgEngByte1=IOUtils.toByteArray(mashahirEngImg1.getInputStream());
    	byte[] imgEngByte2=IOUtils.toByteArray(mashahirEngImg2.getInputStream());
    	byte[] imgEngByte3=IOUtils.toByteArray(mashahirEngImg3.getInputStream());
    	byte[] imgEngByte4=IOUtils.toByteArray(mashahirEngImg4.getInputStream());
    	byte[] imgEngByte5=IOUtils.toByteArray(mashahirEngImg5.getInputStream());
    	byte[] imgEngByte6=IOUtils.toByteArray(mashahirEngImg6.getInputStream());
    	mashahirEngEntity2.setMashahirEngPic1(imgEngByte1);
    	mashahirEngEntity2.setMashahirEngPic2(imgEngByte2);
    	mashahirEngEntity2.setMashahirEngPic3(imgEngByte3);
    	mashahirEngEntity2.setMashahirEngPic4(imgEngByte4);
    	mashahirEngEntity2.setMashahirEngPic5(imgEngByte5);
    	mashahirEngEntity2.setMashahirEngPic6(imgEngByte6);
    	mashahirEngEntity2.setMashahirEngName(mashahirEngName);
    	mashahirEngServiceLocal.insertToMashahirEng(mashahirEngEntity2); 
    	context.addMessage(null, new FacesMessage("Successful"));
    }
	
	
	 public void deleteMerchantEngEntity(long mashahirEngId) throws IOException{
	    	MashahirEngEntity mashahirEngEntity=new MashahirEngEntity();
	    	try {
				mashahirEngEntity=mashahirEngServiceLocal.findMashahirEngById(mashahirEngId);
				mashahirEngServiceLocal.deleteMashahirEngEntity(mashahirEngEntity);
			} catch (Exception e) {
System.err.println("mashahireng not find");
			}
	    	
	    	FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahireng.xhtml" );
	    }
	    
	    
	    public void updateMashahirEngImg1(long mashahirEngId) throws IOException{
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	MashahirEngEntity mashahirEngEntity = new MashahirEngEntity();

	    	try {
				mashahirEngEntity=mashahirEngServiceLocal.findMashahirEngById(mashahirEngId);
		        byte[] imgEng1Byte=IOUtils.toByteArray(mashahirEngImg1.getInputStream());
		        mashahirEngEntity.setMashahirEngPic1(imgEng1Byte);
		    	mashahirEngServiceLocal.updateMashahirEng(mashahirEngEntity);
			} catch (Exception e) {
				System.err.println("mashahireng not find");
			}


	    	FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahireng.xhtml"+"?mashahirId=" + mashahirEngId );
	    }
	    
	    public void updateMashahirEngImg2(long mashahirEngId) throws IOException{
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	MashahirEngEntity mashahirEngEntity = new MashahirEngEntity();

	    	try {
				mashahirEngEntity=mashahirEngServiceLocal.findMashahirEngById(mashahirEngId);
		        byte[] imgEng2Byte=IOUtils.toByteArray(mashahirEngImg2.getInputStream());
		        mashahirEngEntity.setMashahirEngPic2(imgEng2Byte);
		    	mashahirEngServiceLocal.updateMashahirEng(mashahirEngEntity);
			} catch (Exception e) {
				System.err.println("mashahireng not find");
			}


	    	FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahireng.xhtml"+"?mashahirId=" + mashahirEngId );
	    }
	    
	    public void updateMashahirEngImg3(long mashahirEngId) throws IOException{
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	MashahirEngEntity mashahirEngEntity = new MashahirEngEntity();

	    	try {
				mashahirEngEntity=mashahirEngServiceLocal.findMashahirEngById(mashahirEngId);
		        byte[] imgEng3Byte=IOUtils.toByteArray(mashahirEngImg3.getInputStream());
		        mashahirEngEntity.setMashahirEngPic3(imgEng3Byte);
		    	mashahirEngServiceLocal.updateMashahirEng(mashahirEngEntity);
			} catch (Exception e) {
				System.err.println("mashahireng not find");
			}


	    	FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahireng.xhtml"+"?mashahirId=" + mashahirEngId );
	    }
	    
	    public void updateMashahirEngImg4(long mashahirEngId) throws IOException{
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	MashahirEngEntity mashahirEngEntity = new MashahirEngEntity();

	    	try {
				mashahirEngEntity=mashahirEngServiceLocal.findMashahirEngById(mashahirEngId);
		        byte[] imgEng4Byte=IOUtils.toByteArray(mashahirEngImg4.getInputStream());
		        mashahirEngEntity.setMashahirEngPic4(imgEng4Byte);
		    	mashahirEngServiceLocal.updateMashahirEng(mashahirEngEntity);
			} catch (Exception e) {
				System.err.println("mashahireng not find");
			}


	    	FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahireng.xhtml"+"?mashahirId=" + mashahirEngId );
	    }
	    
	    public void updateMashahirEngImg5(long mashahirEngId) throws IOException{
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	MashahirEngEntity mashahirEngEntity = new MashahirEngEntity();

	    	try {
				mashahirEngEntity=mashahirEngServiceLocal.findMashahirEngById(mashahirEngId);
		        byte[] imgEng5Byte=IOUtils.toByteArray(mashahirEngImg5.getInputStream());
		        mashahirEngEntity.setMashahirEngPic5(imgEng5Byte);
		    	mashahirEngServiceLocal.updateMashahirEng(mashahirEngEntity);
			} catch (Exception e) {
				System.err.println("mashahireng not find");
			}


	    	FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahireng.xhtml"+"?mashahirId=" + mashahirEngId );
	    }
	    
	    public void updateMashahirEngImg6(long mashahirEngId) throws IOException{
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	MashahirEngEntity mashahirEngEntity = new MashahirEngEntity();

	    	try {
				mashahirEngEntity=mashahirEngServiceLocal.findMashahirEngById(mashahirEngId);
		        byte[] imgEng6Byte=IOUtils.toByteArray(mashahirEngImg6.getInputStream());
		        mashahirEngEntity.setMashahirEngPic6(imgEng6Byte);
		    	mashahirEngServiceLocal.updateMashahirEng(mashahirEngEntity);
			} catch (Exception e) {
				System.err.println("mashahireng not find");
			}


	    	FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahireng.xhtml"+"?mashahirId=" + mashahirEngId );
	    }

	    public List<MashahirEngEntity> findAllMashahirEng(){
	    	try {
				return mashahirEngServiceLocal.findAllMashahirEng();
			} catch (Exception e) {
	System.err.println("mashahirEng not find");
	return null;
			}
	    }
	    

		public MashahirEngEntity findMashahirEngById(long mashahirEngId) {
	    	try {
				return mashahirEngServiceLocal.findMashahirEngById(mashahirEngId);
			} catch (Exception e) {
				System.err.println("mashahireng not find");
				return null;
			}
	    }
}
