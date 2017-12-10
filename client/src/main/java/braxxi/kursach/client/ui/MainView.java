package braxxi.kursach.client.ui;

import javax.swing.*;
import java.awt.*;

public class MainView {
	private JTabbedPane tabbedPane;
	private JPanel rootPanel;
	private JTable mainTable;
	private JButton searchEstatesButton;
	private JButton addEstateButton;
	private JButton editEstateButton;
	private JButton deleteEstateButton;
	private JPanel searchPanel;

	public JPanel getRootPanel() {
		return this.rootPanel;
	}

	public JTable getMainTable() {
		return this.mainTable;
	}

	public JButton getSearchEstatesButton() {
		return this.searchEstatesButton;
	}

	public JButton getAddEstateButton() {
		return this.addEstateButton;
	}

	public JButton getEditEstateButton() {
		return this.editEstateButton;
	}

	public JButton getDeleteEstateButton() {
		return this.deleteEstateButton;
	}

	public void setSearchEstateView(SearchEstateView searchEstateView) {
		this.searchPanel.add(searchEstateView.getRootPanel());
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
		rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
		tabbedPane = new JTabbedPane();
		rootPanel.add(tabbedPane, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
		tabbedPane.addTab("Search", panel1);
		final JScrollPane scrollPane1 = new JScrollPane();
		panel1.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		mainTable = new JTable();
		scrollPane1.setViewportView(mainTable);
		final JToolBar toolBar1 = new JToolBar();
		rootPanel.add(toolBar1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(-1, 20), null, 0, false));
		searchEstatesButton = new JButton();
		searchEstatesButton.setText("Поиск");
		toolBar1.add(searchEstatesButton);
		final JToolBar.Separator toolBar$Separator1 = new JToolBar.Separator();
		toolBar1.add(toolBar$Separator1);
		addEstateButton = new JButton();
		addEstateButton.setText("Добавить");
		toolBar1.add(addEstateButton);
		editEstateButton = new JButton();
		editEstateButton.setText("Изменить");
		toolBar1.add(editEstateButton);
		deleteEstateButton = new JButton();
		deleteEstateButton.setText("Удалить");
		toolBar1.add(deleteEstateButton);
		searchPanel = new JPanel();
		searchPanel.setLayout(new BorderLayout(0, 0));
		rootPanel.add(searchPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return rootPanel;
	}
}
