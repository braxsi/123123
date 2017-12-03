package braxxi.kursach.client.controller;

import braxxi.kursach.commons.model.EstateRequest;
import braxxi.kursach.commons.model.EstateResponse;
import org.springframework.stereotype.Component;

@Component
public class AddEstateController extends BaseEstateController {

	protected EstateResponse executeRequest() {
		return serverServce.addEstate(new EstateRequest(estate));
	}

}
