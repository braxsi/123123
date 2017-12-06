package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchRequest {

	private SearchEstate searchEstate;

	public SearchRequest() {
	}

	public SearchRequest(SearchEstate searchEstate) {
		this.searchEstate = searchEstate;
	}

	public SearchEstate getSearchEstate() {
		return this.searchEstate;
	}
}
