package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse {

	private List<Estate> estates;

	public SearchResponse() {
	}

	public SearchResponse(List<Estate> estates) {
		this.estates = estates;
	}

	public List<Estate> getEstates() {
		return this.estates;
	}
}
