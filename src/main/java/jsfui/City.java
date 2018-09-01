package jsfui;

public enum City {
tehran("تهران");
	
	private String cityName;

	private City(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}
}
