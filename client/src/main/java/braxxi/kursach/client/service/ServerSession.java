package braxxi.kursach.client.service;

import org.springframework.stereotype.Component;

@Component
public class ServerSession {

	private String cookie;

	public ServerSession() {
	}

	public synchronized void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public synchronized String getCookie() {
		return this.cookie;
	}
}
