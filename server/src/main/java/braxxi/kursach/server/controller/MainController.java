package braxxi.kursach.server.controller;

import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.entity.UserEntity;
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
		final UserEntity user = dbService.isLoginValid(login, password);
		return new LoginResponse(user != null, user);
	}

	@PostMapping("/estate/search")
	public SearchResponse searchEstate(@RequestBody SearchRequest request) {
		return new SearchResponse(dbService.searchEstate(request.getSearchEstate()));
	}

	@PostMapping("/estate/add")
	public EstateResponse addEstate(@RequestBody EstateRequest request) {
		final EstateEntity requestEstate = Preconditions.checkNotNull(request.getEstate());
		Long estateId = dbService.addEstate(requestEstate);
		return new EstateResponse(dbService.getEstate(estateId));
	}

	@PostMapping("/estate/update")
	public EstateResponse updateEstate(@RequestBody EstateRequest request) {
		final EstateEntity requestEstate = request.getEstate();
		dbService.updateEstate(requestEstate);
		return new EstateResponse(dbService.getEstate(requestEstate.getId()));
	}

	@PostMapping("/estate/delete")
	public EstateResponse deleteEstate(@RequestBody EstateRequest request) {
		final EstateEntity requestEstate = request.getEstate();
		dbService.deleteEstate(requestEstate.getId());
		return new EstateResponse(null);
	}

	@PostMapping("/estate/estimate")
	public EstimateEstateResponse estimateEstate(@RequestBody EstateRequest request) {
		final EstateEntity requestEstate = request.getEstate();
		return dbService.estimateEstate(requestEstate);
	}

	@PostMapping("/estate/generate")
	public VoidResponse estimateEstate(@RequestBody GenerateEstatesRequest request) {
		dbService.generateEstate(request);
		return new VoidResponse();
	}

}
