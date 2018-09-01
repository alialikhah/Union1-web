package jsfui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.BrandEntity;
import dao.entity.MerchantEntity;
import service.AddBrandServiceLocal;
import service.MerchantRegisterServiceLocal;

@Named
@SessionScoped
public class MerchantPageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MerchantPageBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;
	@Inject
	private AddBrandServiceLocal addBrandServiceLocal;

	
	private List<BrandEntity> brandEntities=new ArrayList<>();
	private String brands;
	

	public List<BrandEntity> getBrandEntities() {
		return brandEntities;
	}



	public void setBrandEntities(List<BrandEntity> brandEntities) {
		this.brandEntities = brandEntities;
	}



	public String getBrands() {
		return brands;
	}



	public void setBrands(String brands) {
		this.brands = brands;
	}

	public BrandEntity findBrandByName() {
		return null;
	}
	


	public MerchantEntity findByMerchantShop(String shopName) {
		try {	
			
			this.brandEntities.clear();
			this.brands=merchantRegisterServiceLocal.findMerchantByShopNameEng(shopName).getBrands();
			return merchantRegisterServiceLocal.findMerchantByShopNameEng(shopName);
		} catch (Exception e) {
            System.err.println("shop name not find");
            return null;
		}
	}
	 public List<BrandEntity> brandha(){
		 String[] words=this.brands.split("-");
		 for (String string : words) {
			this.brandEntities.add(this.findBranByName(string));
		}
		 return brandEntities;
	 }

	 public BrandEntity findBranByName(String brandName) {
		 return addBrandServiceLocal.findBrandByName(brandName);
	 }
	
	
	

}
