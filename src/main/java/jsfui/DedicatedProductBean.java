package jsfui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import dao.dao.ProductDaoLocal;
import dao.entity.DedicatedEntity;
import dao.entity.MerchantEntity;
import dao.entity.ProductEntity;
import service.DedicatedProductServiceLocal;
import service.MerchantRegisterServiceLocal;
import service.ProductServiceLocal;

@Named
@SessionScoped
public class DedicatedProductBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DedicatedProductBean() {
		// TODO Auto-generated constructor stub
	}
	
	private long productId;
	private long merchantId;
	private long price;
	private long saled;
	private long popularity;
	private List<DedicatedEntity> dedicateFilter=new ArrayList<>();
	private ProductEntity productEntity;
	
	
	@Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;
	@Inject
	private DedicatedProductServiceLocal dedicatedProductServiceLocal;
	@Inject
	private ProductServiceLocal productServiceLocal;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}
	
	public MerchantEntity findMerchantById(long merchantId){
		try {
			return merchantRegisterServiceLocal.findMerchantById(merchantId);
		} catch (Exception e) {
			System.err.println("merchant not find");
			return null;
		}
	}
	
	public ProductEntity findProductByID(){
		return productServiceLocal.findProductByID(productId);
	}
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getSaled() {
		return saled;
	}
	public void setSaled(long saled) {
		this.saled = saled;
	}
	public long getPopularity() {
		return popularity;
	}
	public void setPopularity(long popularity) {
		this.popularity = popularity;
	}
	
	
	

	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
	public List<DedicatedEntity> getDedicateFilter() {
		return dedicateFilter;
	}
	public void setDedicateFilter(List<DedicatedEntity> dedicateFilter) {
		this.dedicateFilter = dedicateFilter;
	}
	public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful") );
    }
	
	public void insertToDedicated(String merchantId) throws IOException{
		long mId=Long.parseLong(merchantId);
		DedicatedEntity dedicatedEntity=new DedicatedEntity();
		dedicatedEntity.setMerchant(this.findMerchantById(mId));
		dedicatedEntity.setProduct(this.productEntity);
		dedicatedEntity.setPrice(price);
		dedicatedEntity.setSaled(saled);
		dedicatedEntity.setPopularity(popularity);
		dedicatedProductServiceLocal.insertToDedicated(dedicatedEntity);
		FacesContext.getCurrentInstance().getExternalContext().redirect("dedicateproduct.xhtml"+"?merchantID=" + merchantId );
	}
	
	
	public List<DedicatedEntity> findAllDedicatedProducts(){
		try {
			return dedicatedProductServiceLocal.findAllDedicatedProducts();
		} catch (Exception e) {
			System.err.println("dedicate product not find");
			return null;
		}
	}
	
    
    public List<DedicatedEntity> findAllDedicatedByPopularity(){
    	return dedicatedProductServiceLocal.findAllDedicatedByPopularity();
    }
    
    public List<MerchantEntity> findAllMerchantByGroup(){
    	return merchantRegisterServiceLocal.findAllMerchantsByGroup("طلایی");
    }
    

	public List<ProductEntity> findAllProducts(){
    	return productServiceLocal.findAllProducts();
    }
	 
    public List<DedicatedEntity> findAllDedicateFilter(){
    	dedicateFilter.clear();
    	for (DedicatedEntity dedicatedEntity : findAllDedicatedByPopularity()) {
    		if(dedicatedEntity.getMerchant().getMerchantGroup().equals("طلایی"))
    			dedicateFilter.add(dedicatedEntity);
		}
/*    	for (DedicatedEntity dedicatedEntity : findAllDedicatedByPopularity()) {
    		if(dedicatedEntity.getMerchant().getMerchantGroup().equals("نقره ای"))
    			dedicateFilter.add(dedicatedEntity);
		}
    	for (DedicatedEntity dedicatedEntity : findAllDedicatedByPopularity()) {
    		if(dedicatedEntity.getMerchant().getMerchantGroup().equals("برنزی"))
    			dedicateFilter.add(dedicatedEntity);
		}*/
    	return dedicateFilter;
    		
    }
    
    
/*    public byte[] findImage(long productId) throws IOException{
    	addProductServiceLocal.findProductPicById(productId);
		return addProductServiceLocal.getProductPic1Byte();
    }
    
    public byte[] findImage2(long productId) throws IOException{
    	addProductServiceLocal.findProductPicById(productId);
		return addProductServiceLocal.getProductPic2Byte();
    }
    
    public byte[] findImage3(long productId) throws IOException{
    	addProductServiceLocal.findProductPicById(productId);
		return addProductServiceLocal.getProductPic3Byte();
    }
    
    public byte[] findImage4(long productId) throws IOException{
    	addProductServiceLocal.findProductPicById(productId);
		return addProductServiceLocal.getProductPic4Byte();
    }
    
    public byte[] findImage5(long productId) throws IOException{
    	addProductServiceLocal.findProductPicById(productId);
		return addProductServiceLocal.getProductPic5Byte();
    }
    
    public byte[] findImage6(long productId) throws IOException{
    	addProductServiceLocal.findProductPicById(productId);
		return addProductServiceLocal.getProductPic6Byte();
    }*/
    

	public List<DedicatedEntity> findAllDedicateByMerchant(long merchantId){
		MerchantEntity merchantEntity=new MerchantEntity();
		try {
			merchantEntity=merchantRegisterServiceLocal.findMerchantById(merchantId);
			return dedicatedProductServiceLocal.findAllDedicateByMerchant(merchantEntity);
		} catch (Exception e) {
              System.err.println("merchant for dedicate not find");
              return null;
		}
		
    }
	
    
    public void deleteDedicateProduct(long dedicatedId) throws IOException {
    	DedicatedEntity dedicatedEntity=new DedicatedEntity();
    	try {
			dedicatedEntity=dedicatedProductServiceLocal.findDedicatedProductById(dedicatedId);
	    	dedicatedProductServiceLocal.deleteDedicateProduct(dedicatedEntity);
	    	FacesContext.getCurrentInstance().getExternalContext().redirect("dedicateproduct.xhtml"+"?merchantID=" + merchantId );
		} catch (Exception e) {
			System.err.println("dedicate product not find");
		}
    }

    	
			
		
    }

	



