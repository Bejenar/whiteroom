package com.whiteroom.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whiteroom.demo.entity.LoginUser;
import com.whiteroom.demo.service.ILoginUserService;

@RestController
@RequestMapping("/api")
public class TestRestController {

	@Autowired
	private ILoginUserService userService;
	
	@GetMapping("/users")
	public List<LoginUser> getCustomers(){
		return userService.findAll();
	}
}
