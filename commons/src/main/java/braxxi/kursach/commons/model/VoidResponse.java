package braxxi.kursach.commons.model;

public class VoidResponse {

	private boolean success;

	public VoidResponse() {
	}

	public VoidResponse(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return this.success;
	}
}
