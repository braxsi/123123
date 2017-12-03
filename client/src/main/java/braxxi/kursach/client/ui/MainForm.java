package braxxi.kursach.client.ui;

import braxxi.kursach.client.model.DefaultAction;
import braxxi.kursach.client.model.DefaultTableModel;
import braxxi.kursach.client.model.EstateTableModel;
import braxxi.kursach.commons.model.Estate;
import braxxi.kursach.commons.model.SearchResponse;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

	private final MainView mainView;
	private DefaultAction searchEstateAction = new DefaultAction("Поиск");
	private DefaultAction addEstateAction = new DefaultAction("Добавить");
	private DefaultAction editEstateAction = new DefaultAction("Изменить");

	public MainForm() {
		mainView = new MainView();
		setContentPane(mainView.getRootPanel());

		setJMenuBar(createMenubar());

		mainView.getSearchEstatesButton().setAction(searchEstateAction);
		mainView.getAddEstateButton().setAction(addEstateAction);
		mainView.getEditEstateButton().setAction(editEstateAction);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private JMenuBar createMenubar() {
		JMenu menu = new JMenu();
		menu.add(createMenuItem(searchEstateAction));
		menu.add(createMenuItem(addEstateAction));
		menu.add(createMenuItem(editEstateAction));

		final JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);

		return menuBar;
	}

	private JMenuItem createMenuItem(Action action) {
		return new JMenuItem(action);
	}

	public void showDisabledForm() {
		mainView.getRootPanel().setVisible(false);
		pack();
		setVisible(true);
	}

	public void enableForm() {
		mainView.getRootPanel().setVisible(true);
	}

	public void setSearchResponse(SearchResponse searchResponse) {
		mainView.getMainTable().setModel(new EstateTableModel(searchResponse.getEstates()));
	}

	public void setSearchActionListener(ActionListener actionListener) {
		this.searchEstateAction.setActionListener(actionListener);
	}

	public void setAddActionListener(ActionListener actionListener) {
		this.addEstateAction.setActionListener(actionListener);
	}

	public void setEditActionListener(ActionListener actionListener) {
		this.editEstateAction.setActionListener(actionListener);
	}

	public Estate getCurrentEstate() {
		final int selectedRow = mainView.getMainTable().getSelectedRow();
		final DefaultTableModel<Estate> model = (DefaultTableModel<Estate>) mainView.getMainTable().getModel();
		return model.getEntityByRow(selectedRow);
	}
}
