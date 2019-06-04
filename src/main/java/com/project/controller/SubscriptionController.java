package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.UserDTO;
import com.project.model.User;
import com.project.service.ISubscriptionService;

@RestController
@RequestMapping("subscribe")
public class SubscriptionController {

	@Autowired
	private ISubscriptionService subscriptionService;

	@PostMapping("plan")
	public ResponseEntity<User> subscribe(@RequestBody UserDTO userDTO) {
		if (!ObjectUtils.isEmpty(userDTO)) {
			User user = subscriptionService.subsribe(userDTO);
			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
