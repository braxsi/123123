package braxxi.kursach.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "braxxi.kursach")
public class ClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApplication.class).headless(false).web(false).run(args);
	}
}
