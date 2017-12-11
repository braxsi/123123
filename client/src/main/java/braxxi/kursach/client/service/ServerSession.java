package braxxi.kursach.client.service;

import braxxi.kursach.commons.entity.UserEntity;
import braxxi.kursach.commons.model.SystemConfigurationResponse;
import org.springframework.stereotype.Component;

@Component
public class ServerSession {

	private String cookie;
	private UserEntity user;
	private SystemConfigurationResponse systemConfiguration;

	public ServerSession() {
	}

	public synchronized void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public synchronized String getCookie() {
		return this.cookie;
	}

	public synchronized UserEntity getUser() {
		return this.user;
	}

	public synchronized void setUser(UserEntity user) {
		this.user = user;
	}

	public synchronized SystemConfigurationResponse getSystemConfiguration() {
		return this.systemConfiguration;
	}

	public synchronized void setSystemConfiguration(SystemConfigurationResponse systemConfiguration) {
		this.systemConfiguration = systemConfiguration;
	}
}
