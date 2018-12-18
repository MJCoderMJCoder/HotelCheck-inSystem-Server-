/**
 * 
 */
package com.lzf.entity;

/**
 * @author MJCoder
 *
 */
public class UserType {
	private int id;
	private int type; // 用户类型：（大于0是旅客）旅客类型：普通、会员。（小于0是管理员）管理员类型：超级管理员
	private String memo;

	/**
	 * 
	 */
	public UserType() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param type
	 * @param memo
	 */
	public UserType(int id, int type, String memo) {
		this.id = id;
		this.type = type;
		this.memo = memo;
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
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserType [id=" + id + ", type=" + type + ", memo=" + memo + "]";
	}

}
