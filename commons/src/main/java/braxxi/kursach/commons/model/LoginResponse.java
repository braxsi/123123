package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
	boolean success;

	public LoginResponse() {
	}

	public LoginResponse(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return this.success;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("LoginResponse{");
		sb.append("success=").append(success);
		sb.append('}');
		return sb.toString();
	}
}
