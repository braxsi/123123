package braxxi.kursach.client.controller;

import braxxi.kursach.client.service.ServerServce;
import braxxi.kursach.client.ui.LoginDialog;
import braxxi.kursach.commons.model.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;

@Component
//@Scope(scopeName = SCOPE_PROTOTYPE)
public class LoginController implements UIControlller {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ServerServce serverServce;

	private LoginDialog loginDialog;

	public LoginController() {
	}

	@PostConstruct
	@Override
	public void init() {
		loginDialog = new LoginDialog();
		loginDialog.setOkActionListener(this::handleButtonOk);
	}

	@Override
	public void show() {
		loginDialog.showDialog();
	}

	@Override
	public void dispose() {
		if (loginDialog != null) {
			loginDialog.dispose();
			loginDialog = null;
		}
	}

	private void handleButtonOk(ActionEvent e) {
		// todo async
		final LoginRequest loginRequest = loginDialog.getLoginRequest();
		boolean success;
		try {
			success = serverServce.login(loginRequest);
		} catch (Exception ex) {
			logger.error("Login error", ex);
			success = false;
		}

		if (success) {
			dispose();
		} else {
			JOptionPane.showMessageDialog(loginDialog, "Ошибка", "Ошибка", JOptionPane.ERROR_MESSAGE);
		}
	}
}
