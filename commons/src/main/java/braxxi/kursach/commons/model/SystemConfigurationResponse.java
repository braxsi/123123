package braxxi.kursach.commons.model;

public class SystemConfigurationResponse {

	private SystemDictionary districts;

	public SystemConfigurationResponse() {
	}

	public SystemConfigurationResponse(SystemDictionary districts) {
		this.districts = districts;
	}

	public SystemDictionary getDistricts() {
		return this.districts;
	}
}
