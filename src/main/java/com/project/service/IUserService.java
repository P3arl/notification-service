package com.project.service;

import java.util.List;

import com.project.model.User;

public interface IUserService {

	User getUser(String userId);

	List<User> getUsers();

}
