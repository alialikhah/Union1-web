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

	private String productName;
	private String productTitle;
	private String productDescription;
	private String productCategry;
	private long productClicked;
	private Part productPic1;
	private Part productPic2;
	private Part productPic3;
	private Part productPic4;
	private Part productPic5;
	private List<String> allBrand=new ArrayList<String>();
	private String productBrand;
	private String productModel;

	
	
	
	
	
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductTitle() {
		return productTitle;
	}


	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}


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


	public long getProductClicked() {
		return productClicked;
	}


	public void setProductClicked(long productClicked) {
		this.productClicked = productClicked;
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


	public Part getProductPic4() {
		return productPic4;
	}


	public void setProductPic4(Part productPic4) {
		this.productPic4 = productPic4;
	}


	public Part getProductPic5() {
		return productPic5;
	}


	public void setProductPic5(Part productPic5) {
		this.productPic5 = productPic5;
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
	
	public void insertToProduct() throws IOException{
		ProductEntity productEntity=new ProductEntity();
		productEntity.setProductName(productName);
		productEntity.setProductCategry(productCategry);
		productEntity.setProductDescription(productDescription);
		productEntity.setProductTitle(productTitle);
		productEntity.setProductBrand(productBrand);
		productEntity.setProductModel(productModel);
        byte[] image1Byte=IOUtils.toByteArray(productPic1.getInputStream());
        byte[] image2Byte=IOUtils.toByteArray(productPic2.getInputStream());
        byte[] image3Byte=IOUtils.toByteArray(productPic3.getInputStream());
        byte[] image4Byte=IOUtils.toByteArray(productPic4.getInputStream());
        byte[] image5Byte=IOUtils.toByteArray(productPic5.getInputStream());
        productEntity.setProductImage1(image1Byte);
        productEntity.setProductImage2(image2Byte);
        productEntity.setProductImage3(image3Byte);
        productEntity.setProductImage4(image4Byte);
        productEntity.setProductImage5(image5Byte);
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
    	productEntity.setProductName(productName);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductTitle(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
    	productEntity.setProductTitle(productTitle);
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
    
    public void updateProductPic4(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
        byte[] image4Byte=IOUtils.toByteArray(productPic4.getInputStream());
        productEntity.setProductImage4(image4Byte);
    	productServiceLocal.updateProduct(productEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("productedit.xhtml"+"?productID=" + productId );
    }
    
    public void updateProductPic5(long productId) throws IOException{
    	ProductEntity productEntity=new ProductEntity();
    	productEntity=productServiceLocal.findProductByID(productId);
        byte[] image5Byte=IOUtils.toByteArray(productPic5.getInputStream());
        productEntity.setProductImage5(image5Byte);
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
