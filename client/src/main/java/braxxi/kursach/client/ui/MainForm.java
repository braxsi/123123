package braxxi.kursach.client.ui;

import braxxi.kursach.client.model.DefaultAction;
import braxxi.kursach.client.model.DefaultTableModel;
import braxxi.kursach.client.model.EstateTableModel;
import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.model.SearchEstate;
import braxxi.kursach.commons.model.SearchResponse;
import braxxi.kursach.commons.model.SystemDictionary;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

	private MainView mainView;
	private SearchEstateView searchEstateView;
	private DefaultAction searchEstateAction = new DefaultAction("Поиск");
	private DefaultAction addEstateAction = new DefaultAction("Добавить");
	private DefaultAction editEstateAction = new DefaultAction("Изменить");
	private DefaultAction deleteEstateAction = new DefaultAction("Удалить");
	private SystemDictionary districts;

	public MainForm() {
	}

	public void init(SystemDictionary districts) {
		this.districts = districts;
		searchEstateView = creatSearchEstateView(this.districts);
		mainView = createMainView(searchEstateView);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private SearchEstateView creatSearchEstateView(SystemDictionary districts) {
		final SearchEstateView searchEstateView = new SearchEstateView();
		searchEstateView.init(districts);
		return searchEstateView;
	}

	private MainView createMainView(SearchEstateView searchEstateView) {
		MainView mainView = new MainView();
		setContentPane(mainView.getRootPanel());

		mainView.setSearchEstateView(searchEstateView);

		setJMenuBar(createMenubar());

		mainView.getSearchEstatesButton().setAction(searchEstateAction);
		mainView.getAddEstateButton().setAction(addEstateAction);
		mainView.getEditEstateButton().setAction(editEstateAction);
		mainView.getDeleteEstateButton().setAction(deleteEstateAction);

		mainView.getMainTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mainView.getMainTable().setRowSelectionAllowed(true);
		mainView.getMainTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel listSelectionModel = (ListSelectionModel)e.getSource();
				updateOnTableSelectionChange(!listSelectionModel.isSelectionEmpty());
			}
		});
		updateOnTableSelectionChange(false);
		return mainView;
	}

	private void updateOnTableSelectionChange(boolean hasSelection) {
		editEstateAction.setEnabled(hasSelection);
		deleteEstateAction.setEnabled(hasSelection);
	}

	private JMenuBar createMenubar() {
		JMenu menu = new JMenu();
		menu.add(createMenuItem(searchEstateAction));
		menu.add(createMenuItem(addEstateAction));
		menu.add(createMenuItem(editEstateAction));
		menu.add(createMenuItem(deleteEstateAction));

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
		mainView.getMainTable().setModel(new EstateTableModel(districts, searchResponse.getEstates()));
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

	public EstateEntity getCurrentEstate() {
		final int selectedRow = mainView.getMainTable().getSelectedRow();
		final DefaultTableModel<EstateEntity> model = (DefaultTableModel<EstateEntity>) mainView.getMainTable().getModel();
		return model.getEntityByRow(selectedRow);
	}

	public SearchEstate getSearchEstate() {
		return searchEstateView.getData(new SearchEstate());
	}
}
