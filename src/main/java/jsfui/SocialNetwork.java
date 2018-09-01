package jsfui;

public enum SocialNetwork {
telegram("تلگرام"),instagram("اینستاگرام");
	
	private String socialNet;

	private SocialNetwork(String socialNet) {
		this.socialNet = socialNet;
	}

	public String getSocNetName() {
		return socialNet;
	}
}
