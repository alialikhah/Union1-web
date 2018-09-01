package jsfui;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.MerchantEntity;
import service.MerchantRegisterServiceLocal;
import service.MerchantServiceLocal;

@Named
@RequestScoped
public class IndexBean{

	public IndexBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
    private MerchantServiceLocal merchantServiceLocal;
	@Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;
	
	
    public List<MerchantEntity> findByMerchantReste(String merchantRaste) {
    	return merchantServiceLocal.findByMerchantReste(merchantRaste);
    }
    
    public MerchantEntity findMerchantById(long merchantId) {
    	try {
			return merchantRegisterServiceLocal.findMerchantById(merchantId);
		} catch (Exception e) {
			System.err.println("merchant not find");
             return null;
		}
    }

	
	


}
