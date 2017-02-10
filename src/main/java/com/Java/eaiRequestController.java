package com.Java;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

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
	private JSONObject result;

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	@GetMapping("/eaiRequest")
	public String eaiReq(Model model) {
		model.addAttribute("eaiRequest", new eaiRequest());
		return "eaiRequest";
	}

	@PostMapping("/eaiRequest")
	public String eaiSubmit(@ModelAttribute eaiRequest eaiRequest){
		try {
			String uri = "http://jms-eai-query.apps.cf.pa.fedex.com/topic/"+eaiRequest.getEAI();
			System.err.println("URL: "+uri);
			RestTemplate restTemplate = new RestTemplate();

			//Getting the String result
			String temp = restTemplate.getForObject(uri, String.class);

			//Parsing the result to JSON object
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(temp);

			eaiRequest.setResult(json);
			setEAI(eaiRequest.getEAI());
			return "result";
		}
		catch (Exception e) {
			return "error";
		}
	}

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(eaiRequestController.class, args);

		String uri = "http://jms-eai-query.apps.cf.pa.fedex.com/topic/FDXMI.CLIENT.AUDIT";
		RestTemplate restTemplate = new RestTemplate();
		String resultString;
		System.out.println(restTemplate.getForObject(uri, String.class));
		resultString = restTemplate.getForObject(uri, String.class);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(resultString);
		System.out.println(json);

	}


}
