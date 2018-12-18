/**
 * 
 */
package com.lzf.entity;

import java.sql.Timestamp;

/**
 * @author MJCoder
 *
 *         房间信息：名称、价格、几人间、状态（0为空、1预订入住、2暂停使用）。
 */
public class Room {
	private int id;
	private String name;
	private float price;
	private int fewHuman; // 几人间
	private int status; // 状态（0为空、1预订入住、2暂停使用）。
	private int userId;
	private User user;
	private Timestamp checkinTime; // 入住时间
	private String type; // 大床房、总统套房
	private Timestamp checkoutTime; // 退房时间

	/**
	 * 
	 */
	public Room() {
	}

	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param fewHuman
	 * @param status
	 * @param userId
	 * @param user
	 * @param checkinTime
	 * @param type
	 * @param checkoutTime
	 */
	public Room(int id, String name, float price, int fewHuman, int status, int userId, User user,
			Timestamp checkinTime, String type, Timestamp checkoutTime) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.fewHuman = fewHuman;
		this.status = status;
		this.userId = userId;
		this.user = user;
		this.checkinTime = checkinTime;
		this.type = type;
		this.checkoutTime = checkoutTime;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the fewHuman
	 */
	public int getFewHuman() {
		return fewHuman;
	}

	/**
	 * @param fewHuman
	 *            the fewHuman to set
	 */
	public void setFewHuman(int fewHuman) {
		this.fewHuman = fewHuman;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the checkinTime
	 */
	public Timestamp getCheckinTime() {
		return checkinTime;
	}

	/**
	 * @param checkinTime
	 *            the checkinTime to set
	 */
	public void setCheckinTime(Timestamp checkinTime) {
		this.checkinTime = checkinTime;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the checkoutTime
	 */
	public Timestamp getCheckoutTime() {
		return checkoutTime;
	}

	/**
	 * @param checkoutTime
	 *            the checkoutTime to set
	 */
	public void setCheckoutTime(Timestamp checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", price=" + price + ", fewHuman=" + fewHuman + ", status="
				+ status + ", userId=" + userId + ", user=" + user + ", checkinTime=" + checkinTime + ", type=" + type
				+ ", checkoutTime=" + checkoutTime + "]";
	}

}
