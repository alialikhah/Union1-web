package jsfui;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class TemplateBean {

	public TemplateBean() {
		// TODO Auto-generated constructor stub
	}

	public void goToAddMerchant() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addmerchant.xhtml");
	}
	
	public void goToAddviewmerchant() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("viewmerchant.xhtml");
	}
	
	public void goToAddaddproduct() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addproduct.xhtml");
	}
	
	public void goToAddproductview() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("productview.xhtml");
	}
	
	public void goToAddaddslider() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addslider.xhtml");
	}
	
	public void goToAddcommercialedit() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("commercialedit.xhtml");
	}
	
	public void goToAdddedivateproductedit() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("dedivateproductedit.xhtml");
	}
	
	public void goToaddbrand() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addbrand.xhtml");
	}
	
	public void goToMashahir() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahir.xhtml");
	}
	
	public void goToMashahirEng() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahireng.xhtml");
	}
	
	public void goToNaghd() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addnaghd.xhtml");
	}
	
	public void goToMojtame() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addmojtame.xhtml");
	}
	
	public void goToJob() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("jobview.xhtml");
	}
	
	public void goToNews() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("addnews.xhtml");
	}
	
	public void goToKarjo() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("karjoview.xhtml");
	}
	
	public void goToKarfarma() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("karfarmaview.xhtml");
	}
	
	public void goToRent() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("rentview.xhtml");
	}
	
}
