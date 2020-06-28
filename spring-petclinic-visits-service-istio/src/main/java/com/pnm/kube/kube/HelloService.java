package com.pnm.kube.kube;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {	
		 @RequestMapping("/hellovisit")
	    public String hello() {		 
		      return String.format(" visits-service This is hello from version 1");	     
	    }	
}

