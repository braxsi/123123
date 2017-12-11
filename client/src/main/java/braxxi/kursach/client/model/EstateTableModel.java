package braxxi.kursach.client.model;

import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.DictionaryItem;
import braxxi.kursach.commons.model.SystemDictionary;

import java.math.BigDecimal;
import java.util.List;

public class EstateTableModel extends DefaultTableModel<EstateEntity> {

	public static final String[] COLUMN_NAMES = {
			"Район",
			"Общая площадь",
			"Жилая площадь",
			"Площадь кухни",
			"Этаж",
			"Всего этажей",
			"До метро, метров",
			"Стоимость",
			"Описание",
			"Контакты",
	};
	public static final Class[] COLUMN_TYPES = {
			String.class,
			BigDecimal.class,
			BigDecimal.class,
			BigDecimal.class,
			Integer.class,
			Integer.class,
			Integer.class,
			BigDecimal.class,
			String.class,
			String.class,
	};
	private SystemDictionary districts;

	public EstateTableModel(SystemDictionary districts, List<EstateEntity> estates) {
		this.districts = districts;
		entities.addAll(estates);
	}

	@Override
	public String[] getColumnLabels() {
		return COLUMN_NAMES;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return COLUMN_TYPES[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EstateEntity estate = entities.get(rowIndex);

		switch (columnIndex) {
			case 0:
				return DictionaryItem.getName(districts.findById(estate.getDistrictId()));
			case 1:
				return estate.getTotalArea();
			case 2:
				return estate.getLivingArea();
			case 3:
				return estate.getKitchenArea();
			case 4:
				return estate.getFloor();
			case 5:
				return estate.getFloors();
			case 6:
				return estate.getDistanceToMetro();
			case 7:
				return estate.getPrice();
			case 8:
				return estate.getDescription();
			case 9:
				return estate.getContacts();
			default:
				return "";
		}
	}

	public List<EstateEntity> getEntities() {
		return entities;
	}

}