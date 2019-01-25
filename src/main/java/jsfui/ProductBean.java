package jsfui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.entity.MerchantEntity;
import dao.entity.ProductEntity;
/*import dao.entity.ProductEntity;
*/import service.ProductServiceLocal;

@Named
@RequestScoped
public class ProductBean {

	public ProductBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ProductServiceLocal productServiceLocal;

	private Part productPic1;
	private Part productPic2;
	private Part productPic3;
	private List<String> allBrand=new ArrayList<String>();
	private String productCategry;
	private String productModel;
	private String productBrand;
	private String productDescription;
	private String raste;
	private String ports;
	private String size;
	private String screenSize;
	private String pixel;
	private String quality;
	private String battery;
	private String color;
	private String memory;
	private String innerMemory;
	private String weight;
	private String camera;
	private String cpu;
	private String gpu;
	private String os;
	private String netMobile;
	private String other;
	


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public String getProductCategry() {
		return productCategry;
	}


	public void setProductCategry(String productCategry) {
		this.productCategry = productCategry;
	}




	public Part getProductPic1() {
		return productPic1;
	}


	public void setProductPic1(Part productPic1) {
		this.productPic1 = productPic1;
	}


	public Part getProductPic2() {
		return productPic2;
	}


	public void setProductPic2(Part productPic2) {
		this.productPic2 = productPic2;
	}


	public Part getProductPic3() {
		return productPic3;
	}


	public void setProductPic3(Part productPic3) {
		this.productPic3 = productPic3;
	}





	public List<String> getAllBrand() {
		return allBrand;
	}


	public void setAllBrand(List<String> allBrand) {
		this.allBrand = allBrand;
	}


	public String getProductBrand() {
		return productBrand;
	}


	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}


	public String getProductModel() {
		return productModel;
	}


	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	
	


	public ProductServiceLocal getProductServiceLocal() {
		return productServiceLocal;
	}


	public void setProductServiceLocal(ProductServiceLocal productServiceLocal) {
		this.productServiceLocal = productServiceLocal;
	}


	public String getRaste() {
		return raste;
	}


	public void setRaste(String raste) {
		this.raste = raste;
	}


	public String getPorts() {
		return ports;
	}


	public void setPorts(String ports) {
		this.ports = ports;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getScreenSize() {
		return screenSize;
	}


	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}


	public String getPixel() {
		return pixel;
	}


	public void setPixel(String pixel) {
		this.pixel = pixel;
	}


	public String getQuality() {
		return quality;
	}


	public void setQuality(String quality) {
		this.quality = quality;
	}


	public String getBattery() {
		return battery;
	}


	public void setBattery(String battery) {
		this.battery = battery;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getMemory() {
		return memory;
	}


	public void setMemory(String memory) {
		this.memory = memory;
	}


	public String getInnerMemory() {
		return innerMemory;
	}


	public void setInnerMemory(String innerMemory) {
		this.innerMemory = innerMemory;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getCamera() {
		return camera;
	}


	public void setCamera(String camera) {
		this.camera = camera;
	}


	public String getCpu() {
		return cpu;
	}


	public void setCpu(String cpu) {
		this.cpu = cpu;
	}


	public String getGpu() {
		return gpu;
	}


	public void setGpu(String gpu) {
		this.gpu = gpu;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}
	
	


	public String getNetMobile() {
		return netMobile;
	}


	public void setNetMobile(String netMobile) {
		this.netMobile = netMobile;
	}


	public List<ProductEntity> findAllProductByBrand(String productBrand,String productCategory){
		return productServiceLocal.findAllProductByBrand(productBrand,productCategory);
	}
	
	
	public String goToProductPage() {
		return "productpage";
	}
	
	public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful") );
    }
	
	
	
	public String getOther() {
		return other;
	}


	public void setOther(String other) {
		this.other = other;
	}


	public void insertToProduct() throws IOException{
		ProductEntity productEntity=new ProductEntity();
		productEntity.setProductCategry(productCategry);
		productEntity.setProductDescription(productDescription);
		productEntity.setProductBrand(productBrand);
		productEntity.setProductModel(productModel);
		productEntity.setBattery(battery);
		productEntity.setCamera(camera);
		productEntity.setColor(color);
		productEntity.setCpu(cpu);
		productEntity.setGpu(gpu);
		productEntity.setInnerMemory(innerMemory);
		productEntity.setMemory(memory);
		productEntity.setOs(os);
		productEntity.setPixel(pixel);
		productEntity.setPorts(ports);
		productEntity.setQuality(quality);
		productEntity.setScreenSize(screenSize);
		productEntity.setSize(size);
		productEntity.setWeight(weight);
		productEntity.setRaste(raste);
		productEntity.setNetMobile(netMobile);
        byte[] image1Byte=IOUtils.toByteArray(productPic1.getInputStream());
        byte[] image2Byte=IOUtils.toByteArray(productPic2.getInputStream());
        byte[] image3Byte=IOUtils.toByteArray(productPic3.getInputStream());
        productEntity.setProductImage1(image1Byte);
        productEntity.setProductImage2(image2Byte);
        productEntity.setProductImage3(image3Byte);
		productServiceLocal.insertToProduct(productEntity);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful") );
		
	}
	
	public List<ProductEntity> findAllProducts() {
		return productServiceLocal.findAllProduct();
	}
	
	public ProductEntity findProductById(long productId) {
		return productServiceLocal.findProductByID(productId);
	}
	
//	******************************update***************************
    public void updateProductName(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductTitle(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductModel(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
    	productEntity.setProductModel(productModel);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductDescription(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
    	productEntity.setProductDescription(productDescription);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductCategory(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
    	productEntity.setProductCategry(productCategry);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductBrand(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
    	productEntity.setProductBrand(productBrand);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductPic1(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
        byte[] image1Byte=IOUtils.toByteArray(productPic1.getInputStream());
        productEntity.setProductImage1(image1Byte);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductPic2(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
        byte[] image2Byte=IOUtils.toByteArray(productPic2.getInputStream());
        productEntity.setProductImage2(image2Byte);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductPic3(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
        byte[] image3Byte=IOUtils.toByteArray(productPic3.getInputStream());
        productEntity.setProductImage3(image3Byte);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    
    //************************************delete*****************************
    
    public void deleteProduct(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=this.findProductById(productId);
    	productServiceLocal.deleteProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productview.xhtml" );
    }
	

}
