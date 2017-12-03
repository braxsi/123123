package braxxi.kursach.client;

import braxxi.kursach.client.controller.MainController;
import braxxi.kursach.client.controller.UIControlller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class ClientStarter {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ApplicationContext applicationContext;

	private UIControlller currentControlller;

	private void showUI() {
		try {
			currentControlller = applicationContext.getBean(MainController.class);
			currentControlller.init();
			currentControlller.show();
		} catch (Throwable e) {
			logger.error("UI init error", e);
		}
	}

	private void disposeUI() {
		if (currentControlller != null) {
			currentControlller.dispose();
		}
	}

	@EventListener
	public void handleContextRefreshedEvent(ContextRefreshedEvent contextRefreshedEvent) {
		SwingUtilities.invokeLater(this::showUI);
	}

	@EventListener
	public void handleContextClosedEvent(ContextClosedEvent contextClosedEvent) {
		SwingUtilities.invokeLater(this::disposeUI);
	}
}
