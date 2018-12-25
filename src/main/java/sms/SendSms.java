package sms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SendSms {

	public SendSms() {
		// TODO Auto-generated constructor stub
	}

	public void sendSms() {
		try {
			URL url = new URL(
					"https://www.saharsms.com/api/gONhkiXUT8sBU1yUJUAQPAqOYlcIOho4/json/SendVerify?receptor=09379150740&template=16147-submit&token=3222&token2=1397/01/01&token3=8-14");
			
			HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
			System.out.println(httpURLConnection.getResponseMessage());
			httpURLConnection.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
