package jsfui;

public enum Group {
gold("طلایی"),silver("نقره ای"),bronze("برنزی");
	
	private String groupName;

	private Group(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}
}
