package braxxi.kursach;

import braxxi.kursach.server.ServerApplication;
import org.springframework.boot.SpringApplication;

public class TestServerApplication extends ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestServerApplication.class, args);
	}
}
