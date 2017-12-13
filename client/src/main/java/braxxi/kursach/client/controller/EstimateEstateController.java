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
		final String message;
		if (response.getAvrPrice() == null) {
			message = "БД не содержит объектов недвижимости с аналогичными параметрами";
		} else {
			message = "Минимальная стоимость: " + response.getMinPrice() +
					"\nСредняя стоимость: " + response.getAvrPrice() +
					"\nМаксимальная стоимость: " + response.getMaxPrice();
		}

		JOptionPane.showMessageDialog(dialog,
				message);
		return false;
	}
}
