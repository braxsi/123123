package braxxi.kursach.client.controller;

import braxxi.kursach.commons.model.EstateRequest;
import braxxi.kursach.commons.model.EstimateEstateResponse;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class EstimateEstateController extends BaseEstateController {

	@Override
	protected boolean processEstate() {
		final EstimateEstateResponse response = serverServce.estimateEstate(new EstateRequest(estate));
		JOptionPane.showMessageDialog(dialog,
				"Минимальная стоимость: " + response.getMinPrice() +
				"\nСредняя стоимость: " + response.getAvrPrice() +
				"\nМаксимальная стоимость: " + response.getMaxPrice());
		return false;
	}
}
