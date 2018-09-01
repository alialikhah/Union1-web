package jsfui;

public enum State {
tehran("تهران");
	
	private String state;

	private State(String state) {
		this.state = state;
	}

	public String getStateName() {
		return state;
	}
}
