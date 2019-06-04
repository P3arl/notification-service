package com.project.utility.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.project.exception.PushException;
import com.project.model.User;
import com.project.service.IPushService;

@Service("androidService")
public class AndroidPushService implements IPushService {

	private static final Logger LOG = LoggerFactory.getLogger(AndroidPushService.class);
	
	private static final String FIREBASE_SERVER_KEY = "Your Server Key here!";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

	@Override
	@Async
	public void pushNotification(User user, String message) throws PushException {

	}
}
