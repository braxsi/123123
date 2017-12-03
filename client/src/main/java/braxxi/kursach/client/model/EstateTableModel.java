package braxxi.kursach.client.model;

import braxxi.kursach.commons.model.Estate;

import java.util.List;

public class EstateTableModel extends DefaultTableModel<Estate> {

	public EstateTableModel() {
		entities.addAll(entities);
	}

	public EstateTableModel(List<Estate> estates) {
		entities.addAll(estates);
	}

	@Override
	public String[] getColumnLabels() {
		return new String[]{
				"Район",
				"Общая площадь",
				"Жилая площадь",
				"Этаж",
				"До метро, метров",
				"Описание"
		};
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Estate estate = entities.get(rowIndex);

		switch (columnIndex) {
			case 0:
				return estate.getDistrict();
			case 1:
				return estate.getTotalArea();
			case 2:
				return estate.getLivingArea();
			case 3:
				return estate.getFloor();
			case 4:
				return estate.getDistanceToMetro();
			case 5:
				return estate.getDescription();
			default:
				return "";
		}
	}

}