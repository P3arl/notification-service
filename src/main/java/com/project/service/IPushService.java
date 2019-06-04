package com.project.service;

import com.project.exception.PushException;
import com.project.model.User;

public interface IPushService {

	public void pushNotification(User user, String message) throws PushException;
}
