package com.Himanshu;

import java.util.HashMap;
import java.util.Map;

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

	public String getEAI() {
		return EAI;
	}

	public void setEAI(String eAI) {
		EAI = eAI;
	}


	private String EAI;
	
	@GetMapping("/eaiRequest")
	public String eaiReq(Model model) {
		model.addAttribute("eaiRequest", new eaiRequest());
		return "eaiRequest";
	}

	@PostMapping("/eaiRequest")
	public String eaiSubmit(@ModelAttribute eaiRequest eaiRequest) {
		setEAI(eaiRequest.getEAI());
		return "result";
	}
	
	public String callRestAPI(String eai){
		Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("eai", Long.parseLong(eai));
		/*ReturnClass obj = restTemplate.getForObject(
		  "REST URL", ReturnClass.class, vars);*/
		return null;
	}

	public static void main(String[] args) {
		SpringApplication.run(eaiRequestController.class, args);
	}


}
