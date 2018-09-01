package jsfui;

public enum Occupation {
	audio("صوتی و تصویری و خانگی"), video("لوازم جانبی"), mobile("موبایل و لوازم جانبی"), car(
			"صوتی و تصویری اتومبیل"), music("آلات موسیقی"), elec("قطعات الکترونیک"), cam(
					"دوربین عکاسی و فیلم برداری"), cctv("دوربین مدار بسته"), ps("کنسول های بازی"), cd("سی دی"),etc("متفرقه");

	private String occName;

	private Occupation(String occName) {
		this.occName = occName;
	}

	public String getOccName() {
		return occName;
	}
}
