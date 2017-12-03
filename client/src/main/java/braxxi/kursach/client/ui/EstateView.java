package braxxi.kursach.client.ui;

import braxxi.kursach.commons.model.Estate;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class EstateView {
	private JTextField textFieldDistrict;
	private JFormattedTextField formattedTextFieldTotalArea;
	private JFormattedTextField formattedTextFieldLivingArea;
	private JFormattedTextField formattedTextFieldFloor;
	private JFormattedTextField formattedTextFieldDistanceToMetro;
	private JTextArea textAreaDescription;
	private JPanel rootPanel;

	public void init() {
		DefaultFormatterFactory bigDecimalFormatter = createBigDecimalFormatter();
		formattedTextFieldTotalArea.setFormatterFactory(bigDecimalFormatter);
		formattedTextFieldLivingArea.setFormatterFactory(bigDecimalFormatter);

		DefaultFormatterFactory intFormatter = createIntFormatter();
		formattedTextFieldFloor.setFormatterFactory(intFormatter);
		formattedTextFieldDistanceToMetro.setFormatterFactory(intFormatter);
	}

	private DefaultFormatterFactory createBigDecimalFormatter() {
		DefaultFormatter fmt = new NumberFormatter(new DecimalFormat("#.0"));
		fmt.setValueClass(BigDecimal.class);
		return new DefaultFormatterFactory(fmt, fmt, fmt);
	}

	private DefaultFormatterFactory createIntFormatter() {
		DefaultFormatter fmt = new NumberFormatter(new DecimalFormat("0"));
		fmt.setValueClass(Integer.class);
		return new DefaultFormatterFactory(fmt, fmt, fmt);
	}

	public JPanel getRootPanel() {
		return this.rootPanel;
	}

	public void setData(Estate data) {
		textFieldDistrict.setText(data.getDistrict());

		formattedTextFieldTotalArea.setValue(data.getTotalArea());
		formattedTextFieldLivingArea.setValue(data.getLivingArea());

		formattedTextFieldFloor.setValue(data.getFloor());
		formattedTextFieldDistanceToMetro.setValue(data.getDistanceToMetro());

		textAreaDescription.setText(data.getDescription());
	}

	public void getData(Estate data) {
		data.setDistrict(textFieldDistrict.getText());

		data.setTotalArea((BigDecimal) formattedTextFieldTotalArea.getValue());
		data.setLivingArea((BigDecimal) formattedTextFieldLivingArea.getValue());

		data.setFloor((Integer) formattedTextFieldFloor.getValue());
		data.setDistanceToMetro((Integer) formattedTextFieldDistanceToMetro.getValue());

		data.setDescription(textAreaDescription.getText());
	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		rootPanel = new JPanel();
		rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
		final JLabel label1 = new JLabel();
		label1.setText("До метро");
		rootPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		formattedTextFieldDistanceToMetro = new JFormattedTextField();
		rootPanel.add(formattedTextFieldDistanceToMetro, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		formattedTextFieldFloor = new JFormattedTextField();
		rootPanel.add(formattedTextFieldFloor, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label2 = new JLabel();
		label2.setText("Этаж");
		rootPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		formattedTextFieldLivingArea = new JFormattedTextField();
		rootPanel.add(formattedTextFieldLivingArea, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label3 = new JLabel();
		label3.setText("Жилая площадь");
		rootPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		formattedTextFieldTotalArea = new JFormattedTextField();
		rootPanel.add(formattedTextFieldTotalArea, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label4 = new JLabel();
		label4.setText("Общая площадь");
		rootPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JLabel label5 = new JLabel();
		label5.setText("Район");
		rootPanel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, new Dimension(150, -1), null, null, 0, false));
		textFieldDistrict = new JTextField();
		rootPanel.add(textFieldDistrict, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
		final JLabel label6 = new JLabel();
		label6.setText("Описание");
		rootPanel.add(label6, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
		final JScrollPane scrollPane1 = new JScrollPane();
		rootPanel.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		textAreaDescription = new JTextArea();
		textAreaDescription.setLineWrap(false);
		textAreaDescription.setMinimumSize(new Dimension(0, 50));
		textAreaDescription.setWrapStyleWord(true);
		scrollPane1.setViewportView(textAreaDescription);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return rootPanel;
	}

	/*
	public boolean isModified(Estate data) {
		if (textFieldDistrict.getText() != null ? !textFieldDistrict.getText().equals(data.getDistrict()) : data.getDistrict() != null) {
			return true;
		}
		if (textAreaDescription.getText() != null ? !textAreaDescription.getText().equals(data.getDescription()) : data.getDescription() != null) {
			return true;
		}
		return false;
	}
*/
}