package jsfui;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.omnifaces.component.script.OnloadScript;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@Named
@RequestScoped
public class MerchantPageGmap {

	public MerchantPageGmap() {
		// TODO Auto-generated constructor stub
	}
	
	private double w;
	private double h;
	
    private MapModel simpleModel;


	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}
	
	public MapModel ali(double a,double b) {
		this.w=a;
		this.h=b;
		simpleModel = new DefaultMapModel();
		 LatLng coord1 = new LatLng(a,b);
		 simpleModel.addOverlay(new Marker(coord1, "merchantPoint"));
		 return simpleModel;
	}

	/*@PostConstruct*/
    public void init() {
        simpleModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(35.68361400896078,51.413975130266635);

          
        //Basic marker
        simpleModel.addOverlay(new Marker(coord1, "merchantPoint"));
        System.err.println("w" + this.w + "h" + this.h);
    }
  
    public MapModel getSimpleModel() {
        return simpleModel;
    }

}
