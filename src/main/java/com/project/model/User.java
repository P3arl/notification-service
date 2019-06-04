package com.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9182526415261141967L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private short id;

	@Column
	private String email;

	@Column
	private String phoneNumber;

	@Column
	private String subscriptionPlan;

	@Column
	private String notificationLimit;

	@Column
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
	 * @return the id
	 */
	public short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(short id) {
		this.id = id;
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

	/**
	 * @return the notificationLimit
	 */
	public String getNotificationLimit() {
		return notificationLimit;
	}

	/**
	 * @param notificationLimit the notificationLimit to set
	 */
	public void setNotificationLimit(String notificationLimit) {
		this.notificationLimit = notificationLimit;
	}
}
