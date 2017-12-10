package braxxi.kursach.client.model;

import braxxi.kursach.commons.entity.EstateEntity;

import java.util.List;

public class EstateTableModel extends DefaultTableModel<EstateEntity> {

	public EstateTableModel() {
		entities.addAll(entities);
	}

	public EstateTableModel(List<EstateEntity> estates) {
		entities.addAll(estates);
	}

	@Override
	public String[] getColumnLabels() {
		return new String[]{
				"Район",
				"Общая площадь",
				"Жилая площадь",
				"Площадь кухни",
				"Этаж",
				"Всего этажей",
				"До метро, метров",
				"Описание",
				"Контакты",
		};
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EstateEntity estate = entities.get(rowIndex);

		switch (columnIndex) {
			case 0:
				return estate.getDistrictId();
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
				return estate.getDescription();
			case 8:
				return estate.getContacts();
			default:
				return "";
		}
	}

}