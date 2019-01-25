package jsfui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.MerchantAddresEntity;
import service.SearchMapServiceLocal;
import service.SingletonServiceLocal;

@Named
@RequestScoped
public class SearchMapBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4267365486724137411L;

	public SearchMapBean() {
		// TODO Auto-generated constructor stub
	}


	@Inject
	private SearchMapServiceLocal searchMapServiceLocal;
	

	public List<MerchantAddresEntity> operation(double lat, double lng) {
        return searchMapServiceLocal.operation(lat, lng);
	}

}
