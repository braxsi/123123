package braxxi.kursach.client.controller;

import braxxi.kursach.client.service.ServerServce;
import braxxi.kursach.client.ui.DefaultDialog;
import braxxi.kursach.client.ui.EstateView;
import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.SystemConfigurationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class BaseEstateController implements UIControlller {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected ServerServce serverServce;
	protected DefaultDialog dialog;
	protected EstateView estateView;
	protected EstateEntity estate;
	protected SystemConfigurationResponse systemConfiguration;

	@PostConstruct
	@Override
	public void init() {
		systemConfiguration = serverServce.getSystemConfiguration();

		estateView = new EstateView();
		estateView.init(systemConfiguration.getDistricts());

		dialog = new DefaultDialog();
		dialog.setContent(estateView.getRootPanel());
		dialog.setActionListener(this::processEstateAction);
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

	public void setEstate(EstateEntity estate) {
		this.estate = estate;
		estateView.setData(estate);
	}

	private void processEstateAction(ActionEvent event) {
		estateView.getData(estate);

		boolean closeDialog;
		try {
			closeDialog = processEstate();
		} catch (Exception ex) {
			logger.error("Error", ex);
			closeDialog = false;
			JOptionPane.showMessageDialog(dialog, "Ошибка", "Ошибка", JOptionPane.ERROR_MESSAGE);
		}

		if (closeDialog) {
			dispose();
		}
	}

	protected abstract boolean processEstate();

}
