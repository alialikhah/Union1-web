package jsfui;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.DedicatedEntity;
import dao.entity.ProductEntity;
import dao.entity.SpecialProductEntity;
import service.SpecialProductServiceLocal;

@Named
@RequestScoped
public class SpecialProductBean {

	public SpecialProductBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private SpecialProductServiceLocal specialProductServiceLocal;

	private long specialPrice;
	private DedicatedEntity dedicatedEntity;
	
	
	


	public DedicatedEntity getDedicatedEntity() {
		return dedicatedEntity;
	}




	public void setDedicatedEntity(DedicatedEntity dedicatedEntity) {
		this.dedicatedEntity = dedicatedEntity;
	}




	public long getSpecialPrice() {
		return specialPrice;
	}




	public void setSpecialPrice(long specialPrice) {
		this.specialPrice = specialPrice;
	}




	public void inserToSpecialProduct() {
    	SpecialProductEntity specialProductEntity=new SpecialProductEntity();
    	specialProductEntity.setSpacialPrice(specialPrice);
    	specialProductEntity.setDedicate(dedicatedEntity);
    	specialProductServiceLocal.inserToSpecialProduct(specialProductEntity);
    	
    }
	

	public List<SpecialProductEntity> findAllSpecialProduct(){
    	return specialProductServiceLocal.findAllSpecialProduct();
    }
	
}
