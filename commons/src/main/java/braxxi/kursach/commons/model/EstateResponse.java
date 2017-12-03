package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstateResponse {

	private Estate estate;

	public EstateResponse() {
	}

	public EstateResponse(Estate estate) {
		this.estate = estate;
	}

	public Estate getEstate() {
		return this.estate;
	}
}
