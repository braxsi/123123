package braxxi.kursach.commons.model;

public class DictionaryItem {
	private Integer id;
	private String name;

	public DictionaryItem() {
	}

	public DictionaryItem(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("DictionaryItem{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
