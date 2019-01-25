package jsfui;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.entity.HomeEntity;
import service.HomeServiceLocal;
import service.SingletonServiceLocal;

@Named
@SessionScoped
public class TempBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5805002736240781697L;

	public TempBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private HomeServiceLocal homeServiceLocal;
	@Inject
	private SingletonServiceLocal singletonServiceLocal;
	
	private long bazdid=0;

	public long getBazdid() {
		return bazdid;
	}

	public void setBazdid(long bazdid) {
		this.bazdid = bazdid;
	}
	@PostConstruct
	public void init() {
		System.err.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOKKKK");
		this.bazdid=singletonServiceLocal.getHomeEntity().getBazdid();
	}
	
	@PreDestroy
	public void destroy() {
		HomeEntity homeEntity=new HomeEntity();
		homeEntity=homeServiceLocal.findHomeEntity(1);
		homeEntity.setBazdid(homeServiceLocal.findHomeEntity(1).getBazdid()+1);
		homeServiceLocal.updateHomeEntity(homeEntity);
		System.err.println("UUUUUUUUUUUUUUUUUUUUUUPPPPPPPPPDDDDDDDDAAAAAAAAAA");

	}

}
