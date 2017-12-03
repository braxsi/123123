package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchRequest {

	private Estate estate;

	public SearchRequest() {
	}

	public SearchRequest(Estate estate) {
		this.estate = estate;
	}

	public Estate getEstate() {
		return this.estate;
	}
}
