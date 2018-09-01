package jsfui;

public enum HaveEtebar {
	ok("دارد"), darhal("در حال صدور"),tamdid("در حال تمدید");
	
	
	private String hete;

	private HaveEtebar(String hete) {
		this.hete = hete;
	}

	public String getHete() {
		return hete;
	}


	
}
