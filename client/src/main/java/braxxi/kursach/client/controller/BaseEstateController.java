package braxxi.kursach.client.controller;

import braxxi.kursach.client.service.ServerServce;
import braxxi.kursach.client.ui.DefaultDialog;
import braxxi.kursach.client.ui.EstateView;
import braxxi.kursach.commons.model.Estate;
import braxxi.kursach.commons.model.EstateRequest;
import braxxi.kursach.commons.model.EstateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;

@Component
public abstract class BaseEstateController implements UIControlller {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected ServerServce serverServce;

	protected DefaultDialog dialog;
	protected EstateView estateView;
	protected Estate estate;

	public BaseEstateController() {
	}

	@PostConstruct
	@Override
	public void init() {
		estateView = new EstateView();
		estateView.init();

		dialog = new DefaultDialog();
		dialog.setContent(estateView.getRootPanel());
		dialog.setActionListener(this::processEstate);
	}

	@Override
	public void show() {
		dialog.showDialog();
	}

	@Override
	public void dispose() {
		if (dialog != null) {
			dialog.dispose();
			dialog = null;
		}
	}

	protected abstract EstateResponse executeRequest();

	public void setEstate(Estate estate) {
		this.estate = estate;
		estateView.setData(estate);
	}

	private void processEstate(ActionEvent event) {
		estateView.getData(estate);

		boolean success;
		try {
			final EstateResponse response = executeRequest();
			estate = response.getEstate();
			success = true;
		} catch (Exception ex) {
			logger.error("Login error", ex);
			success = false;
		}

		if (success) {
			dispose();
		} else {
			JOptionPane.showMessageDialog(dialog, "Ошибка", "Ошибка", JOptionPane.ERROR_MESSAGE);
		}
	}

}
