package braxxi.kursach.client.ui;

import braxxi.kursach.client.model.DefaultAction;
import braxxi.kursach.client.model.DefaultTableModel;
import braxxi.kursach.client.model.EstateTableModel;
import braxxi.kursach.commons.entity.EstateEntity;
import braxxi.kursach.commons.entity.UserEntity;
import braxxi.kursach.commons.model.SearchEstate;
import braxxi.kursach.commons.model.SearchResponse;
import braxxi.kursach.commons.model.SystemDictionary;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class MainForm extends JFrame {

	private MainView mainView;
	private SearchEstateView searchEstateView;
	private DefaultAction searchEstateAction = new DefaultAction("Поиск");
	private DefaultAction addEstateAction = new DefaultAction("Добавить");
	private DefaultAction editEstateAction = new DefaultAction("Изменить");
	private DefaultAction deleteEstateAction = new DefaultAction("Удалить");
	private DefaultAction estimateEstateAction = new DefaultAction("Оценка стоимости");
	private DefaultAction generateEstateAction = new DefaultAction("Сгенерировать записи");
	private DefaultAction saveEstatesAction = new DefaultAction("Сохранить в файл");
	private SystemDictionary districts;
	private UserEntity user;

	public MainForm() {
	}

	public void init(SystemDictionary districts) {
		this.districts = districts;
		searchEstateView = creatSearchEstateView(this.districts);
		mainView = createMainView(searchEstateView);

		setSize(700, 480);
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

		setJMenuBar(createMenubar());

		mainView.setSearchEstateView(searchEstateView);

		mainView.getSearchEstatesButton().setAction(searchEstateAction);
		mainView.getAddEstateButton().setAction(addEstateAction);
		mainView.getEditEstateButton().setAction(editEstateAction);
		mainView.getDeleteEstateButton().setAction(deleteEstateAction);
		mainView.getEstimateEstateButton().setAction(estimateEstateAction);
		mainView.getGenerateEstateButton().setAction(generateEstateAction);
		mainView.getSaveEstatesButton().setAction(saveEstatesAction);

		final JTable mainTable = mainView.getMainTable();
		mainTable.setAutoCreateRowSorter(true);
		mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		mainTable.setRowSelectionAllowed(true);
		mainTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				updateOnTableSelectionChange(getCurrentEstate());
			}
		});
		updateOnTableSelectionChange(null);
		return mainView;
	}

	private void updateOnTableSelectionChange(EstateEntity entity) {
		final boolean canEnable = entity != null && Objects.equals(user.getId(), entity.getUserId());
		editEstateAction.setEnabled(canEnable);
		deleteEstateAction.setEnabled(canEnable);
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

	public void enableForm(UserEntity user) {
		this.user = user;
		mainView.getUserLabel().setText(user.getLogin());
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

	public void setDeleteActionListener(ActionListener actionListener) {
		this.deleteEstateAction.setActionListener(actionListener);
	}

	public void setEstimateActionListener(ActionListener actionListener) {
		this.estimateEstateAction.setActionListener(actionListener);
	}

	public void setGenerateActionListener(ActionListener actionListener) {
		this.generateEstateAction.setActionListener(actionListener);
	}

	public void setSaveActionListener(ActionListener actionListener) {
		this.saveEstatesAction.setActionListener(actionListener);
	}

	public EstateEntity getCurrentEstate() {
		final JTable mainTable = mainView.getMainTable();
		int selectedRow = mainTable.getSelectedRow();
		if (selectedRow >= 0) {
			selectedRow = mainTable.convertRowIndexToModel(selectedRow);
			final DefaultTableModel<EstateEntity> model = (DefaultTableModel<EstateEntity>) mainTable.getModel();
			return model.getEntityByRow(selectedRow);
		} else {
			return null;
		}
	}

	public List<EstateEntity> getEstates() {
		EstateTableModel model = (EstateTableModel) mainView.getMainTable().getModel();
		return model.getEntities();
	}

	public SearchEstate getSearchEstate() {
		return searchEstateView.getData(new SearchEstate());
	}
}
