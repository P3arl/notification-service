package com.project.dto;

public class UserDTO {

	private String email;

	private String phoneNumber;

	private String subscriptionPlan;
	
	private String phoneType;

	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}

	/**
	 * @param phoneType the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the subscriptionPlan
	 */
	public String getSubscriptionPlan() {
		return subscriptionPlan;
	}

	/**
	 * @param subscriptionPlan the subscriptionPlan to set
	 */
	public void setSubscriptionPlan(String subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}

}
