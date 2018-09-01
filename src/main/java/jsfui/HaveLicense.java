package jsfui;

public enum HaveLicense {
	ok("دارد"), darhal("در حال صدور"),tamdid("در حال تمدید");
	
	
	private String havel;

	private HaveLicense(String havel) {
		this.havel = havel;
	}

	public String getHavel() {
		return havel;
	}


}
