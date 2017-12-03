package braxxi.kursach.server.controller;

import braxxi.kursach.commons.model.*;
import com.google.common.base.Preconditions;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MainController {

	AtomicLong atomicLong = new AtomicLong();
	List<Estate> estates = new CopyOnWriteArrayList<>(Arrays.asList(
			Estate.generateRandom(atomicLong.incrementAndGet()),
			Estate.generateRandom(atomicLong.incrementAndGet())));

	@PostMapping("/login")
	public LoginResponse login(String login, String password) {
		// todo
		return new LoginResponse(true);
	}

	@PostMapping("/estate/search")
	public SearchResponse searchEstate(@RequestBody SearchRequest request) {
		// todo
		return new SearchResponse(estates);
	}

	@PostMapping("/estate/add")
	public EstateResponse addEstate(@RequestBody EstateRequest request) {
		// todo
		final Estate requestEstate = Preconditions.checkNotNull(request.getEstate());
		requestEstate.setId(atomicLong.incrementAndGet());
		estates.add(requestEstate);
		return new EstateResponse(requestEstate);
	}

	@PostMapping("/estate/update")
	public EstateResponse updateEstate(@RequestBody EstateRequest request) {
		// todo
		final Estate requestEstate = request.getEstate();
		final Estate dbEstate = estates.stream().filter(estate -> estate.getId().equals(requestEstate.getId())).findFirst().orElseThrow(IllegalArgumentException::new);
		estates.remove(dbEstate);
		estates.add(requestEstate);
		return new EstateResponse(requestEstate);
	}

}
