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

import dao.entity.CommercialEntity;
import dao.entity.MerchantEntity;
import service.CommercialServiceLocal;
import service.MerchantRegisterServiceLocal;

@Named
@RequestScoped
public class CommercialBean {

	public CommercialBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private CommercialServiceLocal commercialServiceLocal;
	@Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;
	private Part commercialPic;
	private String commercialTitle;
	
	
	
	public CommercialServiceLocal getCommercialServiceLocal() {
		return commercialServiceLocal;
	}



	public void setCommercialServiceLocal(CommercialServiceLocal commercialServiceLocal) {
		this.commercialServiceLocal = commercialServiceLocal;
	}



	public String getCommercialTitle() {
		return commercialTitle;
	}



	public void setCommercialTitle(String commercialTitle) {
		this.commercialTitle = commercialTitle;
	}

	


	public Part getCommercialPic() {
		return commercialPic;
	}



	public void setCommercialPic(Part commercialPic) {
		this.commercialPic = commercialPic;
	}



	public void insertToCommercialEntity(long merchantId) throws Exception {
	FacesContext context = FacesContext.getCurrentInstance();
	CommercialEntity commercialEntity=new CommercialEntity();
	commercialEntity.setCommercialTitle(commercialTitle);
	byte[] comPicByte=IOUtils.toByteArray(commercialPic.getInputStream());
	commercialEntity.setCommercialPicture(comPicByte);
	MerchantEntity merchantEntity=new MerchantEntity();
	merchantEntity=merchantRegisterServiceLocal.findMerchantById(merchantId);
	commercialEntity.setMerchantcom(merchantEntity);
	commercialServiceLocal.insertToCommercialEntity(commercialEntity);
	context.addMessage(null, new FacesMessage("Successful"));
	}
	
	public List<CommercialEntity> findCommercialByMerchant(long merchantId){
    MerchantEntity merchantEntity=new MerchantEntity();
	try {
		merchantEntity=merchantRegisterServiceLocal.findMerchantById(merchantId);
		return commercialServiceLocal.findCommercialByMerchant(merchantEntity);
	} catch (Exception e) {
        System.err.println("com merchant error");
        return null;
	}
	
    }
	
	
   
    public void deleteCommercial(long commId) throws IOException {
    CommercialEntity commercialEntity=new CommercialEntity();
    commercialEntity=commercialServiceLocal.findCommercialById(commId);
    commercialServiceLocal.deleteCommercial(commercialEntity);
    FacesContext.getCurrentInstance().getExternalContext().redirect("commercialedit.xhtml" );
    }
    
    public void test() {
    	System.err.println("&&&&&&$%$$$$$$$$$$$$$$$$$$$&&%$$$&&");
    }
    
    
	public List<CommercialEntity> findAllCommercial(){
		return commercialServiceLocal.findAllCommercial();
    }

	
	

}
