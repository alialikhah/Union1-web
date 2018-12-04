package jsfui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.BrandEntity;
import dao.entity.MerchantEntity;
import service.AddBrandServiceLocal;
import service.MerchantRegisterServiceLocal;
import service.SingletonServiceLocal;

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
	@Inject
	private SingletonServiceLocal singletonServiceLocal;
	private List<BrandEntity> brandEntities=new ArrayList<>();
	private String brands;
	private MerchantEntity merchantEntity;
	private List<BrandEntity> brandPartList=new ArrayList<>();
	private BrandEntity brand2;
	public List<BrandEntity> getBrandEntities() {
		return brandEntities;
	}

	


	public BrandEntity getBrand2() {
		return brand2;
	}




	public void setBrand2(BrandEntity brand2) {
		this.brand2 = brand2;
	}




	public List<BrandEntity> getBrandPartList() {
		return brandPartList;
	}



	public void setBrandPartList(List<BrandEntity> brandPartList) {
		this.brandPartList = brandPartList;
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
	


	public MerchantEntity getMerchantEntity() {
		return merchantEntity;
	}



	public void setMerchantEntity(MerchantEntity merchantEntity) {
		this.merchantEntity = merchantEntity;
	}



	public MerchantEntity findByMerchantShop(String shopName) {
		try {	
			
			this.brandEntities.clear();
			this.brands=merchantRegisterServiceLocal.findMerchantByShopNameEng(shopName).getBrands();
			this.merchantEntity=merchantRegisterServiceLocal.findMerchantByShopNameEng(shopName);
			return merchantEntity;
		} catch (Exception e) {
            System.err.println("shop name not find");
            return null;
		}
	}
	
	 public List<BrandEntity> brandha(){
		 String[] words=this.brands.split("-");
		 for (String string : words) {
			this.brandEntities.add(addBrandServiceLocal.findBrandByName(string));
		}
		 return brandEntities;
	 }

	 public BrandEntity findBranByName(String brandName) {
		 return addBrandServiceLocal.findBrandByName(brandName);
	 }
	
	public MerchantEntity findMerchantByEng(String shopName) {
		for (MerchantEntity merchantEntity : singletonServiceLocal.getMerchantList()) {
			if(merchantEntity.getMerchantShopNameEng().equals(shopName))
				this.merchantEntity=merchantEntity;
		}
		return this.merchantEntity;
		
			
	}
	@PostConstruct
	public void init() {
		System.err.println("OOOOOOOOOOmerchantpagebeanOOOOOOOOOO");
	}
	
	public List<BrandEntity> findMerchantBrands2(String shopName) {
		this.brandPartList.clear();
		String[] barandParts= {};
		try {
	for (MerchantEntity merchantEntity : singletonServiceLocal.getMerchantList()) {
		if(merchantEntity.getMerchantShopNameEng().equals(shopName)) {
			barandParts=merchantEntity.getBrands().split("-");
			for (String string : barandParts) {
				this.brandPartList.add(this.findBrandByName(string));
			}
		}
		}
	return this.brandPartList;
	}catch (Exception e) {
		return new ArrayList<>();
		}
}
public BrandEntity findBrandByName(String brandName) {
	for (BrandEntity brandEntity : singletonServiceLocal.getBrandList()) {
		if(brandEntity.getBrandName().equals(brandName)) {
		 this.brand2=brandEntity;
		}
	}
	return this.brand2;
}
	

}
