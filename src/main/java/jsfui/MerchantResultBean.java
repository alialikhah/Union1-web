package jsfui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.MerchantEntity;
import service.MerchantResultServiceLocal;

@Named
@SessionScoped
public class MerchantResultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public MerchantResultBean() {
		// TODO Auto-generated constructor stub
	}
	private List<MerchantEntity> allRaste=new ArrayList<>();
	@Inject
	private MerchantResultServiceLocal merchantResultServiceLocal;

	
	
	public List<MerchantEntity> getAllRaste() {
		return allRaste;
	}



	public void setAllRaste(List<MerchantEntity> allRaste) {
		this.allRaste = allRaste;
	}



	public List<MerchantEntity> findMerchantByRaste(String raste){
	for (MerchantEntity merchantEntity : merchantResultServiceLocal.findMerchantByRaste(raste)) {
		allRaste.add(merchantEntity);
	}
	return allRaste;
		//return merchantResultServiceLocal.findMerchantByRaste(raste);
	}
	
	
	
}
