package com.whiteroom.demo.service;

import java.util.List;

import com.whiteroom.demo.entity.LoginUser;

public interface ILoginUserService {
	public List<LoginUser> findAll();
}
