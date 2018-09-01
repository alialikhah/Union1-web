package jsfui;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.ProductEntity;
import service.ProductServiceLocal;

@Named
@RequestScoped
public class AllProductsBean {

	public AllProductsBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ProductServiceLocal productServiceLocal;
	
	private int number1=30;
	private int number2=80;
	
	
	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public List<ProductEntity> findProductsByBrand(){
		return null;
	}
	
	public List<ProductEntity> findAllProductByBrand(String brandName){
		return productServiceLocal.findAllProductByBrandOnly(brandName);
	}
	
	public List<ProductEntity> findAllProductByBrandAndCategory(String brandName,String category){
		return productServiceLocal.findAllProductByBrand(brandName, category);
	}
	
	public List<ProductEntity> findAllProduct(){
		return productServiceLocal.findAllProducts();
	}

}
