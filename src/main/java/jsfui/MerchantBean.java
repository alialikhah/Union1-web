package jsfui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.DedicatedEntity;
import dao.entity.MerchantEntity;
import service.SingletonServiceLocal;

@Named
@RequestScoped
public class MerchantBean {

	public MerchantBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private SingletonServiceLocal singletonServiceLocal;
	
	public MerchantEntity findMerchantByEng(String shopName) {
        MerchantEntity merchantEntityX=new MerchantEntity();
		for (MerchantEntity merchantEntity : singletonServiceLocal.getMerchantList()) {
			if (merchantEntity.getMerchantShopNameEng().equals(shopName))
				merchantEntityX = merchantEntity;
		}
		return merchantEntityX;

	}
	
	public List<DedicatedEntity> findDedicate(String shopName){
		List<DedicatedEntity> dedicatedEntities=new ArrayList<>();
		dedicatedEntities.addAll(this.findMerchantByEng(shopName).getMerchantDedicate());
		Collections.reverse(dedicatedEntities);
		return dedicatedEntities;
	}

}
