package braxxi.kursach.commons.model;

import braxxi.kursach.commons.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
	boolean success;
	UserEntity user;

	public LoginResponse() {
	}

	public LoginResponse(boolean success, UserEntity user) {
		this.success = success;
		this.user = user;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public UserEntity getUser() {
		return this.user;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("LoginResponse{");
		sb.append("success=").append(success);
		sb.append('}');
		return sb.toString();
	}


}
