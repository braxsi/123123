package braxxi.kursach.client.service;

import braxxi.kursach.commons.model.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ServerServce {

	private RestTemplate restTemplate;
	private ServerSession serverSession;

	public ServerServce(RestTemplateBuilder restTemplateBuilder, ServerSession serverSession) {
		restTemplate = restTemplateBuilder.rootUri("http://localhost:8080/kursach/").build();
		this.serverSession = serverSession;
	}

	public boolean isLoggedIn() {
		return serverSession.getCookie() != null;
	}

	public boolean login(LoginRequest loginRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("login", loginRequest.getLogin());
		map.add("password", loginRequest.getPassword());

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		ResponseEntity<LoginResponse> response = restTemplate.postForEntity("/login", request, LoginResponse.class);
		if (response.getBody().isSuccess()) {
			// TODO final List<String> cookie = response.getHeaders().get("Cookie");
			serverSession.setCookie("unknown");
			return true;
		} else {
			return false;
		}
	}

	public SearchResponse searchEstates(SearchRequest searchRequest) {
		HttpEntity<SearchRequest> request = createRequest(searchRequest);
		ResponseEntity<SearchResponse> response = restTemplate.postForEntity("/estate/search", request, SearchResponse.class);
		return response.getBody();
	}

	public EstateResponse addEstate(EstateRequest estateRequest) {
		HttpEntity<EstateRequest> request = createRequest(estateRequest);
		ResponseEntity<EstateResponse> response = restTemplate.postForEntity("/estate/add", request, EstateResponse.class);
		return response.getBody();
	}

	public EstateResponse updateEstate(EstateRequest estateRequest) {
		HttpEntity<EstateRequest> request = createRequest(estateRequest);
		ResponseEntity<EstateResponse> response = restTemplate.postForEntity("/estate/update", request, EstateResponse.class);
		return response.getBody();
	}

	private <T> HttpEntity<T> createRequest(T request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Cookie", serverSession.getCookie());

		return new HttpEntity<T>(request, headers);
	}
}
