package braxxi.kursach.client.ui;

import braxxi.kursach.commons.model.DictionaryItem;

import javax.swing.*;

public class UIUtils {

	public static Integer getSelectedDictionaryItemId(JComboBox comboBox) {
		final DictionaryItem dictionaryItem = (DictionaryItem) comboBox.getSelectedItem();
		return dictionaryItem == null ? null : dictionaryItem.getId();
	}

}
