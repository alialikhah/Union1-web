package navigate;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class NavigateTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 471025802223227682L;

	public NavigateTest() {
		// TODO Auto-generated constructor stub
	}
	
    public String moveToPage1(){
        return "home";
    }

}
