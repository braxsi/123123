package braxxi.kursach.client.ui;

import braxxi.kursach.commons.model.DictionaryItem;

import javax.swing.*;
import java.awt.*;

public class DictionaryItemDefaultListCellRenderer extends DefaultListCellRenderer {
	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

		if (value instanceof DictionaryItem) {
			value = ((DictionaryItem) value).getName();
		}
		return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	}
}
