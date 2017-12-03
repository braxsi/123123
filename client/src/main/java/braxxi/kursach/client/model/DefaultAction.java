package braxxi.kursach.client.model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultAction extends AbstractAction {
	private ActionListener actionListener;

	public DefaultAction(String text) {
		super(text);
	}

	public ActionListener getActionListener() {
		return this.actionListener;
	}

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (actionListener != null) {
			actionListener.actionPerformed(e);
		}
	}
}
