package braxxi.kursach.client.service;

import braxxi.kursach.commons.model.SystemConfigurationResponse;
import org.springframework.stereotype.Component;

@Component
public class ServerSession {

	private String cookie;
	private SystemConfigurationResponse systemConfiguration;

	public ServerSession() {
	}

	public synchronized void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public synchronized String getCookie() {
		return this.cookie;
	}

	public synchronized SystemConfigurationResponse getSystemConfiguration() {
		return this.systemConfiguration;
	}

	public synchronized void setSystemConfiguration(SystemConfigurationResponse systemConfiguration) {
		this.systemConfiguration = systemConfiguration;
	}
}
