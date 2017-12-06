package braxxi.kursach.commons.model;

import braxxi.kursach.commons.entity.EstateEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstateResponse {

	private EstateEntity estate;

	public EstateResponse() {
	}

	public EstateResponse(EstateEntity estate) {
		this.estate = estate;
	}

	public EstateEntity getEstate() {
		return this.estate;
	}
}
