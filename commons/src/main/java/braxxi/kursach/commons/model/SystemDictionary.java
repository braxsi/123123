package braxxi.kursach.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.Map;

public class SystemDictionary {
	private String name;
	private Map<Integer, DictionaryItem> itemMap;

	public SystemDictionary() {
	}

	public SystemDictionary(String name, Map<Integer, DictionaryItem> itemMap) {
		this.name = name;
		this.itemMap = itemMap;
	}

	public String getName() {
		return name;
	}

	public Map<Integer, DictionaryItem> getItemMap() {
		return itemMap;
	}

	@JsonIgnore
	public Collection<DictionaryItem> getItems() {
		return itemMap.values();
	}

	public DictionaryItem findById(int districtId) {
		return itemMap.get(districtId);
	}
}
