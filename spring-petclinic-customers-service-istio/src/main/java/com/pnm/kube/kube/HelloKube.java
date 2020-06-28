package com.pnm.kube.kube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloKube {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/welcome-vets")
	public String welcome() {
		String message = "response from customer-service";
		try {
			System.err.println("1Hello in welcome");
			message = restTemplate.getForObject("http://vets-service:8888/hello", String.class)
					+ "vets-service response";
			System.err.println("2Hello in welcome");

		} catch (Exception e) {
			try {

				System.out.println("1 Exception " + e.getMessage());

				message = restTemplate.getForObject("http://localhost:8888/hello", String.class) + "localhost response";
				System.out.println("3 Exception " + e.getMessage());

			} catch (Exception e2) {
				System.out.println("2 Exception " + e2.getMessage());
			}
		}
		System.out.println("5 Exception " );

		return message;
	}

	@RequestMapping("/dear")
	@ResponseBody
	public String welcome1() {
		return "dear.....";
	}

	@RequestMapping("/")
	@ResponseBody
	public String welcome2() {
		return "2dear.....";
	}

	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}


	@RequestMapping("/welcome-visits")
	public String welcomeVisits() {
		String message = "response from visits-service";
		try {
			System.err.println("11Hello in welcome");
			message = restTemplate.getForObject("http://visits-service:9999/hellovisit", String.class)
					+ "visits-service response";
			System.err.println("22Hello in welcome");

		} catch (Exception e) {
			try {

				System.out.println("11 Exception " + e.getMessage());

				message = restTemplate.getForObject("http://localhost:9999/hellovisit", String.class) + "localhost response";
				System.out.println("32 Exception " + e.getMessage());

			} catch (Exception e2) {
				System.out.println("22 Exception " + e2.getMessage());
			}
		}
		System.out.println("55 Exception " );

		return message;
	}



}
