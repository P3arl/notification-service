package com.project.utility.service;

import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.service.IPushService;

@Service("appleService")
public class ApplePushService implements IPushService {

	@Override
	public void pushNotification(User user, String message) {

	}

}
