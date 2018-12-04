package jsfui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.entity.ProductEntity;
import service.ProductServiceLocal;

@Named
@SessionScoped
public class AddProductBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddProductBean() {
		// TODO Auto-generated constructor stub
	}
	
	private long productId;
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
	private Part productPic6;
	private List<String> allBrand=new ArrayList<String>();
	private String productBrand;
	private String productModel;
	@Inject
	private ProductServiceLocal addProductServiceLocal;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
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
	public Part getProductPic6() {
		return productPic6;
	}
	public void setProductPic6(Part productPic6) {
		this.productPic6 = productPic6;
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
	public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful") );
    }
	
/*	public void insertToProduct() throws IOException{
		ProductEntity productEntity=new ProductEntity();
		productEntity.setProductName(productName);
		productEntity.setProductCategry(productCategry);
		productEntity.setProductDescription(productDescription);
		productEntity.setProductTitle(productTitle);
		productEntity.setProductBrand(productBrand);
		productEntity.setProductModel(productModel);
		ProductImageEntity productImageEntity=new ProductImageEntity();
		byte[] productImg1=IOUtils.toByteArray(productPic1.getInputStream());
		productImageEntity.setProductImage1(productImg1);
		byte[] productImg2=IOUtils.toByteArray(productPic2.getInputStream());
		productImageEntity.setProductImage2(productImg2);
		byte[] productImg3=IOUtils.toByteArray(productPic3.getInputStream());
		productImageEntity.setProductImage3(productImg3);
		byte[] productImg4=IOUtils.toByteArray(productPic4.getInputStream());
		productImageEntity.setProductImage4(productImg4);
		byte[] productImg5=IOUtils.toByteArray(productPic5.getInputStream());
		productImageEntity.setProductImage5(productImg5);
		productEntity.getProductImageEntities().add(productImageEntity);
		addProductServiceLocal.insertToProduct(productEntity);

	}*/
	

	@PostConstruct
	public void init() {
		Brand[] brand=Brand.values();
		for (Brand brand2 : brand) {
			this.allBrand.add(brand2.toString());
		}
	}
	
	

	
}
