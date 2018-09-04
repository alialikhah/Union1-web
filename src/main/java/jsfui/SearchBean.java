package jsfui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.MashahirEngEntity;
import dao.entity.MashahirEntity;
import dao.entity.MerchantEntity;
import dao.entity.MojtameEntity;
import service.MashahirEngServiceLocal;
import service.MashahirServiceLocal;
import service.MerchantRegisterServiceLocal;
import service.MojtameServiceLocal;

@Named
@SessionScoped
public class SearchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private MerchantRegisterServiceLocal merchantRegisterServiceLocal;
	@Inject
	private MashahirServiceLocal mashahirServiceLocal;
	@Inject
	private MashahirEngServiceLocal mashahirEngServiceLocal;
	@Inject
	private MojtameServiceLocal mojtameServiceLocal;

	private String shopNamePer;

	public String getShopNamePer() {
		return shopNamePer;
	}

	public void setShopNamePer(String shopNamePer) {
		this.shopNamePer = shopNamePer;
	}

	public List<MerchantEntity> findForSearch() {
		return merchantRegisterServiceLocal.findAllMErchantEntity();
	}

	public List<String> autocomplete(String prefix) throws Exception {
		ArrayList<String> result = new ArrayList<String>();
		if ((prefix == null) || (prefix.length() == 0)) {
			for (int i = 0; i < 10; i++) {
				result.add(merchantRegisterServiceLocal.findAllMErchantEntity().get(i).getMerchantShopNamePer());
			}
			for (int i = 0; i < 10; i++) {
				result.add(mashahirServiceLocal.findAllMashahir().get(i).getMashahirName());
			}
			for (int i = 0; i < 10; i++) {
				result.add(mashahirEngServiceLocal.findAllMashahirEng().get(i).getMashahirEngName());
			}
			for (int i = 0; i < 10; i++) {
				result.add(mojtameServiceLocal.findAllMojtame().get(i).getMojtameTitle());
			}
		} else {
			Iterator<MerchantEntity> iterator = merchantRegisterServiceLocal.findAllMErchantEntity().iterator();
			while (iterator.hasNext()) {
				MerchantEntity elem = ((MerchantEntity) iterator.next());
				if ((elem.getMerchantShopNamePer() != null
						&& elem.getMerchantShopNamePer().toLowerCase().indexOf(prefix.toLowerCase()) == 0)
						|| "".equals(prefix)) {
					result.add(elem.getMerchantShopNamePer());
				}
			}
			Iterator<MashahirEntity> iterator2 = mashahirServiceLocal.findAllMashahir().iterator();
			while (iterator2.hasNext()) {
				MashahirEntity elem = ((MashahirEntity) iterator2.next());
				if ((elem.getMashahirName() != null
						&& elem.getMashahirName().toLowerCase().indexOf(prefix.toLowerCase()) == 0)
						|| "".equals(prefix)) {
					result.add(elem.getMashahirName());
				}
			}
			Iterator<MashahirEngEntity> iterator3 = mashahirEngServiceLocal.findAllMashahirEng().iterator();
			while (iterator3.hasNext()) {
				MashahirEngEntity elem = ((MashahirEngEntity) iterator3.next());
				if ((elem.getMashahirEngName() != null
						&& elem.getMashahirEngName().toLowerCase().indexOf(prefix.toLowerCase()) == 0)
						|| "".equals(prefix)) {
					result.add(elem.getMashahirEngName());
				}
			}
			Iterator<MojtameEntity> iterator4 = mojtameServiceLocal.findAllMojtame().iterator();
			while (iterator4.hasNext()) {
				MojtameEntity elem = ((MojtameEntity) iterator4.next());
				if ((elem.getMojtameTitle() != null
						&& elem.getMojtameTitle().toLowerCase().indexOf(prefix.toLowerCase()) == 0)
						|| "".equals(prefix)) {
					result.add(elem.getMojtameTitle());
				}
			}
		}

		return result;
	}

	public List<MerchantEntity> findMerchantByShopNamePer() {
		try {
			System.err.println(merchantRegisterServiceLocal.findMerchantByShopNamePer(this.shopNamePer).iterator()
					.next().getMerchantShopNamePer());
			return merchantRegisterServiceLocal.findMerchantByShopNamePer(this.shopNamePer);
		} catch (Exception e) {
			System.err.println("merchant not find per");
			return new ArrayList<MerchantEntity>();
		}
	}
	
	
	public void searchAct() throws IOException {
		this.findMerchantByShopNamePer();
		FacesContext.getCurrentInstance().getExternalContext().redirect("search.xhtml");

	}

}
