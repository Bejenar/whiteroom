package com.whiteroom.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index(Authentication authentication) {
		try {
			System.out.println(authentication.getAuthorities().toString());
			
		}
		catch (Exception ex){
			System.out.println("fuck you");
		}
		return "index";
	}
	
}
