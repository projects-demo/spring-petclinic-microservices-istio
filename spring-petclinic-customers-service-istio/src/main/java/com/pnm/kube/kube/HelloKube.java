package com.pnm.kube.kube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloKube {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/welcome")
	public String welcome() {
		String message = "response from customer-service";
		try {
			message = restTemplate.getForObject("http://vets-service:8888/hello", String.class)
					+ "vets-service response";

		} catch (Exception e) {
			try {

				System.out.println("1 Exception " + e.getMessage());

				message = restTemplate.getForObject("http://localhost:8888/hello", String.class) + "localhost response";
			} catch (Exception e2) {
				System.out.println("2 Exception " + e2.getMessage());
			}
		}
		return message;
	}

	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
}
