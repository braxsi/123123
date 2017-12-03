package braxxi.kursach.server.controller;

import braxxi.kursach.server.model.AddUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message}")
	private String message;

	@GetMapping("/")
	public String welcome(Model model) {
		model.addAttribute("time", LocalDateTime.now());
		model.addAttribute("message", this.message);
		return "welcome";
	}

	@GetMapping("/addUser")
	public String addUserForm(Model model) {
		model.addAttribute("addUser", new AddUser());
		return "addUser";
	}

	@PostMapping("/addUser")
	public String addUserSubmit(@Valid @ModelAttribute AddUser addUser, Model model) {
		//model.addAttribute("user", addUser);
		return "userAdded";
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String/*MyRestResponse*/ handleMyRuntimeException(Throwable exception) {
		return "Some data I want to send back to the client.";//new MyRestResponse("Some data I want to send back to the client.");
	}
}
