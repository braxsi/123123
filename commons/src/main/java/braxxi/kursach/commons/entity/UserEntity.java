package braxxi.kursach.commons.entity;

public class UserEntity extends BaseEntity {
	private String login;
	private String password;
	private String email;

	public UserEntity() {
	}

	public UserEntity(Long id) {
		this.setId(id);
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
