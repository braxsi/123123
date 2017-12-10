package braxxi.kursach.client.controller;

import braxxi.kursach.client.service.ServerServce;
import braxxi.kursach.client.ui.MainForm;
import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;

@Component
public class MainController implements UIControlller {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ServerServce serverServce;
	@Autowired
	private LoginController loginController;
	@Autowired
	private BaseEstateController addEstateController;
	@Autowired
	private EditEstateController editEstateController;
	@Autowired
	private EstimateEstateController estimateEstateController;

	private MainForm mainForm;
	private SystemConfigurationResponse systemConfigurationResponse;

	public MainController() {
	}

	@PostConstruct
	@Override
	public void init() {
		systemConfigurationResponse = serverServce.getSystemConfiguration();

		mainForm = new MainForm();
		mainForm.init(systemConfigurationResponse.getDistricts());
		mainForm.setSearchActionListener(this::searchEstates);
		mainForm.setAddActionListener(this::addEstate);
		mainForm.setEditActionListener(this::updateEstate);
		mainForm.setDeleteActionListener(this::deleteEstate);
		mainForm.setEstimateActionListener(this::estimateEstate);
		mainForm.setGenerateActionListener(this::generateEstate);
	}

	public void searchEstates(ActionEvent event) {
		SearchEstate searchEstate = mainForm.getSearchEstate();
		final SearchResponse searchResponse = serverServce.searchEstates(new SearchRequest(searchEstate));
		mainForm.setSearchResponse(searchResponse);
	}

	public void addEstate(ActionEvent event) {
		addEstateController.init();
		addEstateController.setEstate(new EstateEntity());
		addEstateController.show();
		addEstateController.dispose();

		searchEstates(null);
	}

	public void updateEstate(ActionEvent event) {
		editEstateController.init();
		editEstateController.setEstate(mainForm.getCurrentEstate());
		editEstateController.show();
		editEstateController.dispose();

		// todo update the estate in the table only
		searchEstates(null);
	}

	public void deleteEstate(ActionEvent event) {
		if (JOptionPane.showConfirmDialog(mainForm, "Удалить?", "Удаление записи", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
			serverServce.deleteEstate(new EstateRequest(mainForm.getCurrentEstate()));
			// todo update the estate in the table only
			searchEstates(null);
		}
	}

	public void estimateEstate(ActionEvent event) {
		estimateEstateController.init();
		estimateEstateController.setEstate(new EstateEntity());
		estimateEstateController.show();
		estimateEstateController.dispose();
	}

	public void generateEstate(ActionEvent event) {
		serverServce.generateEstates(new GenerateEstatesRequest(10));
		searchEstates(null);
	}

	@Override
	public void show() {
		mainForm.showDisabledForm();

//		loginController = new LoginController();
//		loginController.init();
		loginController.show();
		loginController.dispose();

		if (serverServce.isLoggedIn()) {
			mainForm.enableForm();
			searchEstates(null);
		}
	}

	@Override
	public void dispose() {
		if (loginController != null) {
			loginController.dispose();
		}
		if (addEstateController != null) {
			addEstateController.dispose();
		}
		if (editEstateController != null) {
			editEstateController.dispose();
		}
		if (estimateEstateController != null) {
			estimateEstateController.dispose();
		}
		if (mainForm != null) {
			mainForm.dispose();
			mainForm = null;
		}
	}

}
