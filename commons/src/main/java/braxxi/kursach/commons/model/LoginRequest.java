package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginRequest {
	private String login;
	private String password;

	public LoginRequest() {
	}

	public LoginRequest(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("LoginRequest{");
		sb.append("login='").append(login).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
