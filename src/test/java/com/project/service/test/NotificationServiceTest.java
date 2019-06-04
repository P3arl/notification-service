package com.project.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.project.dto.NotificationDTO;
import com.project.exception.BaseException;
import com.project.exception.UserNotFoundException;
import com.project.model.User;
import com.project.repository.INofiticationRepository;
import com.project.service.IUserService;
import com.project.service.NotificationService;
import com.project.utility.service.AndroidPushService;
import com.project.utility.service.ApplePushService;
import com.project.utility.service.EmailService;
import com.project.utility.service.SmsService;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {

	@Mock
	private IUserService userService;

	@Mock
	private EmailService emailService;

	@Mock
	private INofiticationRepository notifRepo;

	@Mock
	private SmsService smsService;

	@Mock
	private AndroidPushService androidService;

	@Mock
	private ApplePushService appleService;

	@InjectMocks
	private NotificationService service;

	@Test
	public void notifyTest_Success() throws BaseException {
		NotificationDTO notification = new NotificationDTO();
		notification.setMessage("Hi test message");
		String userId = "1";
		User user = new User();
		user.setSubscriptionPlan("SILVER");
		Mockito.when(userService.getUser(userId)).thenReturn(user);
		service.notify(userId, notification);
	}

	@Test(expected = UserNotFoundException.class)
	public void notifyTest_UserNotFound() throws BaseException {
		NotificationDTO notification = new NotificationDTO();
		String userId = "1";
		service.notify(userId, notification);
	}
}
