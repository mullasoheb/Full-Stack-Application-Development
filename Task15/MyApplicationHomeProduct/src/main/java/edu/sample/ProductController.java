package edu.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@GetMapping("product")
	public String productService() {
		return "Product services page can be loaded here";
	}
}
