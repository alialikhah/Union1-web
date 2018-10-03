package jsfui;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.MerchantEntity;
import service.OnlineMerchantServiceLocal;

@Named
@ApplicationScoped
public class OnlinePageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OnlinePageBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private OnlineMerchantServiceLocal onlineMerchantServiceLocal;
	
	public List<MerchantEntity> onlineMerchantList(){
		return onlineMerchantServiceLocal.getMerchantEntities();
	}

}
