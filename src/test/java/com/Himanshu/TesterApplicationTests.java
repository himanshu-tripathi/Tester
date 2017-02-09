package com.Himanshu;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesterApplicationTests {
	
	public String callRestAPI(String eai){
		/*Map<String, Long> vars = new HashMap<String, Long>();
		vars.put("eai", Long.parseLong(eai));*/
		RestTemplate restTemplate = new RestTemplate();
		String countryCode="IND";
		ResponseEntity<String> response = restTemplate.getForEntity(
		        "http://services.groupkt.com/state/get/IND/all",
		        String.class);

		System.out.println(response);
		return null;
	}

	@Test
	public void contextLoads() {
		getEmployees();
	}

	private static void getEmployees()
	{
	    final String uri = "http://jms-eai-query.apps.cf.pa.fedex.com/topic/FDXMI.CLIENT.AUDIT";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	}
	
	public static void main(String[] args) {
		
		
		/* final String uri = "http://services.groupkt.com/state/get/IND/all";
		    RestTemplate restTemplate = new RestTemplate();
		     
		    HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		     
		    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		     
		    System.out.println(result);*/
		getEmployees();
	}
}
