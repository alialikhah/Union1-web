package jsfui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.DedicatedEntity;
import dao.entity.MerchantEntity;
import service.MerchantRegisterServiceLocal;
import service.SingletonServiceLocal;

@Named
@SessionScoped
public class MerchantAdminBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5717016794854269577L;



	public MerchantAdminBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SingletonServiceLocal singletonServiceLocal;
	
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;

	private boolean viewPro=true;
	private int proNum;
	
	
	public boolean isViewPro() {
		return viewPro;
	}

	public void setViewPro(boolean viewPro) {
		this.viewPro = viewPro;
	}
	
	

	public int getProNum() {
		return proNum;
	}

	public void setProNum(int proNum) {
		this.proNum = proNum;
	}

	public MerchantEntity findMerchantById(long merchantId) {
/*			MerchantEntity merchantEntityX=new MerchantEntity();
		for (MerchantEntity merchantEntity : singletonServiceLocal.getMerchantList()) {
			if (merchantEntity.getMerchantId()==merchantId)
				merchantEntityX = merchantEntity;
		}
		return merchantEntityX;*/
		try {
			return merchantRegisterServiceLocal.findMerchantById(merchantId);
		} catch (Exception e) {
			return null;
		}

	}
	
	public List<DedicatedEntity> findDedicate(long merchantId){
		List<DedicatedEntity> dedicatedEntities=new ArrayList<>();
		try {
			dedicatedEntities.addAll(merchantRegisterServiceLocal.findMerchantById(merchantId).getMerchantDedicate());
			this.proNum=dedicatedEntities.size();
			System.err.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG"+this.proNum);
			return dedicatedEntities;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean viewProduct(long merchantId) throws Exception {
		List<DedicatedEntity> dedicatedEntities=new ArrayList<>();
			dedicatedEntities.addAll(merchantRegisterServiceLocal.findMerchantById(merchantId).getMerchantDedicate());
			//this.proNum=dedicatedEntities.size();
			System.err.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG"+this.proNum);
if(dedicatedEntities.size()>8)
	return false;
else
	return true;
	}
		
}
