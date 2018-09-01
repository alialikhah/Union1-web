package jsfui;

public enum Union {
	tv("اتحادیه لوازم صوتی و تصویری و تلفن همراه و لوازم جانبی"), mobile("اتحادیه صنف دستگاه های مخابراتی"), trnsdev(
			"اتحادیه انفورماتیک"), tablet("متفرقه");

	private String union;

	private Union(String union) {
		this.union = union;
	}

	public String getUnionName() {
		return union;
	}
}
