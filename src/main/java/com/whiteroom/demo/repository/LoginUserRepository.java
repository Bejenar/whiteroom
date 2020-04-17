package com.whiteroom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whiteroom.demo.entity.LoginUser;

public interface LoginUserRepository extends JpaRepository<LoginUser, Integer> {

}
