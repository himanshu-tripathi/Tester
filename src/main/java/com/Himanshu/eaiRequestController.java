package com.Himanshu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
@Controller
public class eaiRequestController {

	@GetMapping("/eaiRequest")
	public String eaiReq(Model model) {
		model.addAttribute("eaiRequest", new eaiRequest());
		return "eaiRequest";
	}

	@PostMapping("/eaiRequest")
	public String eaiSubmit(@ModelAttribute eaiRequest eaiRequest) {
		return "result";
	}


	public static void main(String[] args) {
		SpringApplication.run(eaiRequestController.class, args);
	}


}
