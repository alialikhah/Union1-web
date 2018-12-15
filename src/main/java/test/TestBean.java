package test;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TestBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4101025891576077316L;

	public TestBean() {
		// TODO Auto-generated constructor stub
	}
	
	private int count=1;

	public int getCount() {
		System.err.println(count);
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void act() {
		this.count++;
		System.err.println(count);
	}
	
	

}
