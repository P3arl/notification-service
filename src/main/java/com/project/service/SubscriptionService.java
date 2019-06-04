package com.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.UserDTO;
import com.project.model.Plan;
import com.project.model.User;
import com.project.repository.IUserRepository;

@Service
public class SubscriptionService implements ISubscriptionService {

	private static final Logger LOG = LoggerFactory.getLogger(SubscriptionService.class);

	@Autowired
	private IUserRepository userRepo;

	@Override
	public User subsribe(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		setNotificationLimit(user, Enum.valueOf(Plan.class, userDTO.getSubscriptionPlan().toUpperCase()));
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setPhoneType(userDTO.getPhoneType());
		user.setSubscriptionPlan(userDTO.getSubscriptionPlan());
		try {
			return userRepo.save(user);
		} catch (Exception ex) {
			LOG.error("Error saving user object. Error={}", ex.getMessage());
		}
		return null;

	}

	private void setNotificationLimit(User user, Plan plan) {
		switch (plan) {
		case SILVER:
			user.setNotificationLimit("1M");
			break;
		case GOLD:
			user.setNotificationLimit("10M");
			break;
		case PLATINUM:
			user.setNotificationLimit("unlimited");
			break;
		default:
			LOG.error("Incorrect Plan name: {}", plan);
		}
	}

}
