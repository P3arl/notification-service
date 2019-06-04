package com.project.dto;

public class NotificationDTO {

	String message;

	String noticationType;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the noticationType
	 */
	public String getNoticationType() {
		return noticationType;
	}

	/**
	 * @param noticationType the noticationType to set
	 */
	public void setNoticationType(String noticationType) {
		this.noticationType = noticationType;
	}

}