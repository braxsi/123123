package braxxi.kursach.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "braxxi.kursach")
//@EnableJpaRepositories(basePackages = "pl.dmichalski.reservations.business.repository")
public class ClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApplication.class).headless(false).web(false).run(args);
		// todo 
//		MainMenuController mainMenuController = context.getBean(MainMenuController.class);
//		mainMenuController.prepareAndOpenFrame();
	}

//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			Quote quote = restTemplate.getForObject(
//					"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//			log.info(quote.toString());
//		};
//	}
}
