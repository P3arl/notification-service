package com.project.service;

import java.util.List;

import com.project.dto.NotificationDTO;
import com.project.exception.BaseException;
import com.project.model.Notification;

public interface INotificationService {

	public void notify(String userId, NotificationDTO notification) throws BaseException;

	public List<Notification> getNotifications(String userId) throws BaseException;
}