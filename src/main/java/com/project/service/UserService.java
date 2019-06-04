package com.project.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private IUserRepository userRepo;

	@Override
	public User getUser(String userId) {
		short id = Short.parseShort(userId);
		Optional<User> user = userRepo.findById(id);
		return user.orElse(null);
	}

	@Override
	public List<User> getUsers() {
		try {
			return userRepo.findAll();
		} catch (Exception ex) {
			LOG.error("Error getting users. Error={}", ex.getMessage());
		}
		return Collections.emptyList();
	}

}
