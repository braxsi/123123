package braxxi.kursach.client.controller;

import braxxi.kursach.commons.model.EstateRequest;
import braxxi.kursach.commons.model.EstateResponse;
import org.springframework.stereotype.Component;

@Component
public class EditEstateController extends BaseModifyEstateController {

	protected EstateResponse executeRequest() {
		return serverServce.updateEstate(new EstateRequest(estate));
	}

}
