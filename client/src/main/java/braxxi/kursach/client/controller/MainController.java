package braxxi.kursach.client.controller;

import braxxi.kursach.client.service.ServerServce;
import braxxi.kursach.client.ui.MainForm;
import braxxi.kursach.commons.model.Estate;
import braxxi.kursach.commons.model.SearchRequest;
import braxxi.kursach.commons.model.SearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.event.ActionEvent;

@Component
//@Scope(scopeName = SCOPE_PROTOTYPE)
public class MainController implements UIControlller {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ServerServce serverServce;
	@Autowired
	private LoginController loginController;
	@Autowired
	private AddEstateController addEstateController;
	@Autowired
	private EditEstateController editEstateController;

	private MainForm mainForm;

	public MainController() {
	}

	@PostConstruct
	@Override
	public void init() {
		mainForm = new MainForm();
		mainForm.setSearchActionListener(this::searchEstates);
		mainForm.setAddActionListener(this::addEstate);
		mainForm.setEditActionListener(this::updateEstate);
	}

	public void searchEstates(ActionEvent event) {
		final SearchResponse searchResponse = serverServce.searchEstates(new SearchRequest(new Estate()));
		mainForm.setSearchResponse(searchResponse);
	}

	public void addEstate(ActionEvent event) {
		addEstateController.init();
		addEstateController.setEstate(new Estate());
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
		if (mainForm != null) {
			mainForm.dispose();
			mainForm = null;
		}
	}

}
