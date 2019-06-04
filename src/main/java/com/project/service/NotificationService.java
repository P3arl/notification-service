package com.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.project.config.Application;
import com.project.dto.NotificationDTO;
import com.project.exception.BaseException;
import com.project.exception.EmailException;
import com.project.exception.NotificationException;
import com.project.exception.PushException;
import com.project.exception.SmsException;
import com.project.exception.UserNotFoundException;
import com.project.model.Notification;
import com.project.model.PhoneType;
import com.project.model.Plan;
import com.project.model.User;
import com.project.repository.INofiticationRepository;
import com.project.utility.service.EmailService;
import com.project.utility.service.SmsService;

@Service
public class NotificationService implements INotificationService {

	private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private INofiticationRepository notifRepo;

	@Autowired
	private SmsService smsService;

	@Autowired
	@Qualifier("androidService")
	private IPushService androidService;

	@Autowired
	@Qualifier("appleService")
	private IPushService appleService;

	@Override
	public void notify(String userId, NotificationDTO notification) throws BaseException {
		User user = userService.getUser(userId);
		if (user != null) {
			createNotification(notification, user);
			String plan = user.getSubscriptionPlan();
			sendNotification(user, Enum.valueOf(Plan.class, plan), notification.getMessage());
		} else {
			LOG.error("User not found in database");
			throw new UserNotFoundException("User not found in database");
		}
	}

	private void createNotification(NotificationDTO notification, User user) throws BaseException {
		try {
			Notification notif = new Notification();
			notif.setMessage(notification.getMessage());
			notif.setUser(user);
			notifRepo.save(notif);
		} catch (Exception ex) {
			throw new NotificationException(ex.getMessage());
		}
	}

	private void sendNotification(User user, Plan plan, String message)
			throws BaseException {
		switch (plan) {
		case SILVER:
			sendEmail(user, message);
			break;
		case GOLD:
			sendEmail(user, message);
			sendSMS(user, message);
			break;
		case PLATINUM:
			sendEmail(user, message);
			sendSMS(user, message);
			sendPush(user, message);
			break;
		default:
			LOG.error("Incorrect Plan name: {}", plan);
		}
	}

	private void sendPush(User user, String message) throws PushException {
		if (user.getPhoneType().equalsIgnoreCase(PhoneType.APPLE.toString())) {
			appleService.pushNotification(user, message);
		} else if (user.getPhoneType().equalsIgnoreCase(PhoneType.ANDROID.toString())) {
			androidService.pushNotification(user, message);
		}
	}

	private void sendSMS(User user, String message) throws SmsException {
		smsService.sendSMS(user, message);
	}

	private void sendEmail(User user, String message) throws EmailException {
		emailService.sendEmail(user, message);
	}

	@Override
	public List<Notification> getNotifications(String userId) throws NotificationException {
		try {
			return notifRepo.findAllByUserId(Short.valueOf(userId));
		} catch (NumberFormatException ex) {
			throw new NotificationException(ex.getMessage());
		}
	}
}
