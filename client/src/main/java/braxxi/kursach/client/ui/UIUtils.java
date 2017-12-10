package braxxi.kursach.client.ui;

import braxxi.kursach.commons.model.DictionaryItem;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class UIUtils {

	public static Integer getSelectedDictionaryItemId(JComboBox comboBox) {
		final DictionaryItem dictionaryItem = (DictionaryItem) comboBox.getSelectedItem();
		return dictionaryItem == null ? null : dictionaryItem.getId();
	}

	public static DefaultFormatterFactory createBigDecimalFormatter() {
		DefaultFormatter fmt = new NumberFormatter(new DecimalFormat("#.0"));
		fmt.setValueClass(BigDecimal.class);
		return new DefaultFormatterFactory(fmt, fmt, fmt);
	}

	public static DefaultFormatterFactory createIntFormatter() {
		DefaultFormatter fmt = new NumberFormatter(new DecimalFormat("0"));
		fmt.setValueClass(Integer.class);
		return new DefaultFormatterFactory(fmt, fmt, fmt);
	}
}
