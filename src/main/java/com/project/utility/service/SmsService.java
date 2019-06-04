package com.project.utility.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.project.exception.SmsException;
import com.project.model.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	private static final Logger LOG = LoggerFactory.getLogger(SmsService.class);
	
	public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	public static final String AUTH_TOKEN = "your_auth_token";
	private static final String SENDER_NUMBER = "+4345356464";

	@PostConstruct
	public void init() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}

	@Async
	public void sendSMS(User user, String message) throws SmsException {
		Message msg;
		try {
			PhoneNumber toNumber = new com.twilio.type.PhoneNumber(user.getPhoneNumber());
			PhoneNumber fromNumber = new com.twilio.type.PhoneNumber(SENDER_NUMBER);
			msg = Message.creator(toNumber, fromNumber, message).create();
			LOG.info("Message sent with sid: {}", msg.getSid());
		} catch (Exception ex) {
			LOG.error("SMS sending failed. Error={}", ex.getMessage());
		} catch(Throwable ex) {
			throw new SmsException(ex.getMessage());
		}
	}
}
