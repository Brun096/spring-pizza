package org.generation.italy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {

	
	
	
		
		@GetMapping
		private String Index() {
			return "redirect:/pizza"; //rimando 8080 a /books
		}
}
