package braxxi.kursach.client.controller;

import braxxi.kursach.commons.model.EstateResponse;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseModifyEstateController extends BaseEstateController {

	public BaseModifyEstateController() {
	}

	protected abstract EstateResponse executeRequest();

	protected boolean processEstate() {
		final EstateResponse response = executeRequest();
		estate = response.getEstate();
		return true;
	}

}
