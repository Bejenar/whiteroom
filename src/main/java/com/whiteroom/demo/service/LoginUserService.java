package com.whiteroom.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whiteroom.demo.entity.LoginUser;
import com.whiteroom.demo.repository.LoginUserRepository;

@Service
public class LoginUserService implements ILoginUserService {

	@Autowired
	LoginUserRepository repos;
	
	@Override
	public List<LoginUser> findAll() {
		return repos.findAll();
	}

}
