package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstateRequest {

	private Estate estate;

	public EstateRequest() {
	}

	public EstateRequest(Estate estate) {
		this.estate = estate;
	}

	public Estate getEstate() {
		return this.estate;
	}

	public void setEstate(Estate estate) {
		this.estate = estate;
	}
}
