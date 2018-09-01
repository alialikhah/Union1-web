package jsfui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class PageRedirectBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PageRedirectBean() {
		// TODO Auto-generated constructor stub
	}
	
	private long productId;
	
	
	
	public long getProductId() {
		return productId;
	}



	public void setProductId(long productId) {
		this.productId = productId;
	}



	public void goToProductsDetails(long productId){
		this.productId=productId;
		FacesContext contex=FacesContext.getCurrentInstance();
		contex.getApplication().getNavigationHandler().handleNavigation(contex, null,"/productdetails.xhtml");
	}
	
	public String goPage(){
		return "success";
	}

}
