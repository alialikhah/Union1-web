package jsfui;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.joda.time.DateTime;

import ir.jnf.maven.libs.Kernel.soapClients.paymentGateway.mellat.IPaymentGateway;
import ir.jnf.maven.libs.Kernel.soapClients.paymentGateway.mellat.PaymentGatewayImplService;
import ir.jnf.maven.libs.Kernel.util.JNFFormatUtil;

@Named
@SessionScoped
public class BankBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2272811069029850000L;

	public BankBean() {
		// TODO Auto-generated constructor stub
	}

	private String money;
	private String token;

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getToken() {
		return token;
	}

	public String doTransaction() {
		System.out.println(this.money);
		IPaymentGateway im = new PaymentGatewayImplService().getPaymentGatewayImplPort();
		try {
			DateTime todayIsoDT = new DateTime();
			String mellatReqRes = im.bpPayRequest(3553885, "mrdomain2", "46728263", 19, Integer.valueOf(money),
					JNFFormatUtil.format(todayIsoDT, "EYYYYEMMEDD"), JNFFormatUtil.format(todayIsoDT, "EhhEmmEss"), "",
					"http://127.0.0.1:8080/verifymelat.xhtml", 0);
			String [] res = mellatReqRes.split(",");
			if (res[0].equals("0")) {
				System.out.println("Token is " + res[1]);
				this.token = res[1].trim();
				return "mellat";
			}
			/*
			 * AsanPardakhtServertimeSoap asanPardakhtTimeSoap = new
			 * AsanPardakhtServertimeSoapProxy(); AsanPardakhtMerchantservicesSoap
			 * asanPardakhtSoap = new AsanPardakhtMerchantservicesSoapProxy(); String
			 * asanPardakhtStr = String .format("%s,%s,%s,%s,%s,%s,,%s,",
			 * "1","domian609396","wpyun0gr",1121, 2000,
			 * asanPardakhtTimeSoap.getPaymentServerTime(), "http://www.yahoo.com"); String
			 * asanPardakhtRes = asanPardakhtSoap.requestOperation(508, JNFEncryption
			 * .AES256EncryptWithFixedKeyAndIV(
			 * asanPardakhtStr,"iyjtHd6xuMTG2t0Hg3OVpU7SoHW8BvrfvtacpNcnYq4=",
			 * "P1DQjE7yM/9PQ6qIXvkvBAvox53iwcr4+dlmo6lQjS0="));
			 * System.out.println(asanPardakhtRes); System.out.println(asanPardakhtStr);
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.money;
	}
	
	public String checkTransaction() {
		Map<String,String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		for (String param : requestParams.keySet()) {
			System.out.println(String.format("%s : %s", param,requestParams.get(param)));
		}
		if (requestParams.get("ResCode").equals("0")) {
			IPaymentGateway im = new PaymentGatewayImplService().getPaymentGatewayImplPort();
			String res = im.bpVerifyRequest(3553885, "mrdomain2", "46728263", 19, Long.valueOf(requestParams.get("SaleOrderId")), Long.valueOf(requestParams.get("SaleReferenceId")));
			System.out.println(res);
		}
		return "";
	}

}
