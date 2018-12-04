/*package jsfui;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

@Named
@RequestScoped
public class IpBean {

	public IpBean() {
		// TODO Auto-generated constructor stub
	}

	public void IpAddr() {
		InetAddress ip;
		try {

			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void location() throws IOException {
		File file = new File("/home/fedoraali/Downloads/GeoLiteCity.dat");
		LookupService lookup = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
		Location location=lookup.getLocation("31.184.132.136");
		 System.err.println(location.countryName);
		 System.err.println(location.city);
		 System.err.println(location.latitude);
		 System.err.println(location.longitude);

	}

}
*/