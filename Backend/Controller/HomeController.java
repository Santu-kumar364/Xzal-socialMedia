package com.socialMedia.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping
	public String homeControllerHandler() {
		return "this is home controller santu";
	}
	
	@GetMapping("/home")
	public String homeControllerHandler2() {
		return "Praanzal, this is home controller ";
	}


	

	@GetMapping("/codeWithSantu")
	public String homeControllerHandler3() {
		return " Let's begin your journey with Santu ";
	}

}
 
