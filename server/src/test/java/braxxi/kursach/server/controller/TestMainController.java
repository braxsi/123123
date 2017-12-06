package braxxi.kursach.server.controller;

import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.*;
import braxxi.kursach.server.service.DbService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

//@RestController
public class TestMainController {

	@Autowired
	DbService dbService;

	AtomicLong atomicLong = new AtomicLong();
	List<EstateEntity> estates = new CopyOnWriteArrayList<>(Arrays.asList(
			EstateEntity.generateRandom(atomicLong.incrementAndGet()),
			EstateEntity.generateRandom(atomicLong.incrementAndGet())));

	@PostMapping("/login")
	public LoginResponse login(String login, String password) {
		return new LoginResponse(true);
	}

	@PostMapping("/estate/search")
	public SearchResponse searchEstate(@RequestBody SearchRequest request) {
		return new SearchResponse(estates);
	}

	@PostMapping("/estate/add")
	public EstateResponse addEstate(@RequestBody EstateRequest request) {
		final EstateEntity requestEstate = Preconditions.checkNotNull(request.getEstate());
		requestEstate.setId(atomicLong.incrementAndGet());
		estates.add(requestEstate);
		return new EstateResponse(requestEstate);
	}

	@PostMapping("/estate/update")
	public EstateResponse updateEstate(@RequestBody EstateRequest request) {
		final EstateEntity requestEstate = request.getEstate();
		final EstateEntity dbEstate = estates.stream().filter(estate -> estate.getId().equals(requestEstate.getId())).findFirst().orElseThrow(IllegalArgumentException::new);
		estates.remove(dbEstate);
		estates.add(requestEstate);
		return new EstateResponse(requestEstate);
	}

}
