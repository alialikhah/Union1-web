package jsfui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.entity.BrandEntity;
import dao.entity.ProductEntity;
import service.AddBrandServiceLocal;

@Named
@RequestScoped
public class BrandBean {

	public BrandBean() {
		// TODO Auto-generated constructor stub
	}
	
	private String brandName;
	private Part brandPic;
	private List<String> brands=new ArrayList<>();
	@Inject
	private AddBrandServiceLocal addBrandServiceLocal;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Part getBrandPic() {
		return brandPic;
	}
	public void setBrandPic(Part brandPic) {
		this.brandPic = brandPic;
	}
	
	
	
	public List<String> getBrands() {
		return brands;
	}
	public void setBrands(List<String> brands) {
		this.brands = brands;
	}
	public void insertToBrand() throws IOException {
		BrandEntity brandEntity=new BrandEntity();
		byte[] brandPicByte=IOUtils.toByteArray(brandPic.getInputStream());
		brandEntity.setBrandName(brandName);
		brandEntity.setBrandPic(brandPicByte);
		addBrandServiceLocal.inserToBrandEntity(brandEntity);
		FacesContext context = FacesContext.getCurrentInstance();
		 context.addMessage(null, new FacesMessage("Successful") );
	}
	
	public List<BrandEntity> findAllBrands(){
		try {
			return addBrandServiceLocal.findAllBrands();
		} catch (Exception e) {
            System.err.println("brand not find");
            return null;
		}
		
	}

	@PostConstruct
	public void init() {
		try {
			for (BrandEntity brand : addBrandServiceLocal.findAllBrands()) {
				brands.add(brand.getBrandName());
				System.err.println(brand.getBrandName());
			}
		} catch (Exception e) {
             System.err.println("brand not find");
		}
	}
	
	public BrandEntity findBrandById(long brandId) {
		return addBrandServiceLocal.findBrandById(brandId);
	}
	
  public void delBrand(long brandId) throws IOException {
     BrandEntity brandEntity=new BrandEntity();
     brandEntity=addBrandServiceLocal.findBrandById(brandId);
     addBrandServiceLocal.deleteBrand(brandEntity);
     FacesContext.getCurrentInstance().getExternalContext().redirect("addbrand.xhtml" );
  }

}
