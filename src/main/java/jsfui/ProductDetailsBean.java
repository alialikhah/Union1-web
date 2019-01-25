package jsfui;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.DedicatedEntity;
import dao.entity.ProductEntity;
import service.SingletonServiceLocal;

@Named
@RequestScoped
public class ProductDetailsBean {

	public ProductDetailsBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private SingletonServiceLocal singletonServiceLocal;
	
	public ProductEntity findProductById(long productId) {
		ProductEntity productEntityX=new ProductEntity();
		for (ProductEntity productEntity : singletonServiceLocal.getProductEntities()) {
			if(productEntity.getProductId()==productId)
				productEntityX=productEntity;
		}
		return productEntityX;
	}
	
	public DedicatedEntity findDedicateById(long dedId) {
		DedicatedEntity dedicatedEntity=new DedicatedEntity();
		for (DedicatedEntity dedicatedEntity2 : singletonServiceLocal.getDedicatedEntities()) {
			if(dedicatedEntity2.getDedicatedId()==dedId)
				dedicatedEntity=dedicatedEntity2;
		}
		return dedicatedEntity;
	}
}
