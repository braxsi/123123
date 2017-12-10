package braxxi.kursach.server.controller;

import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.*;
import braxxi.kursach.server.service.DbService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MainController {

	@Autowired
	DbService dbService;

	@PostMapping("/getSystemConfiguration")
	public SystemConfigurationResponse getSystemConfiguration() {
		return new SystemConfigurationResponse(dbService.getDistricts());
	}

	@PostMapping("/login")
	public LoginResponse login(String login, String password) {
		return new LoginResponse(dbService.isLoginValid(login, password));
	}

	@PostMapping("/estate/search")
	public SearchResponse searchEstate(@RequestBody SearchRequest request) {
		return new SearchResponse(dbService.searchEstate(request.getSearchEstate()));
	}

	@PostMapping("/estate/add")
	public EstateResponse addEstate(@RequestBody EstateRequest request) {
		// todo Security
		final EstateEntity requestEstate = Preconditions.checkNotNull(request.getEstate());
		// todo user
		requestEstate.setUserId(1L);
		Long estateId = dbService.addEstate(requestEstate);
		return new EstateResponse(dbService.getEstate(estateId));
	}

	@PostMapping("/estate/update")
	public EstateResponse updateEstate(@RequestBody EstateRequest request) {
		final EstateEntity requestEstate = request.getEstate();
		// todo user
		requestEstate.setUserId(1L);
		dbService.updateEstate(requestEstate);
		return new EstateResponse(dbService.getEstate(requestEstate.getId()));
	}

}
