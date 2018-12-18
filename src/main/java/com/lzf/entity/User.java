/**
 * 
 */
package com.lzf.entity;

/**
 * @author MJCoder
 *
 */
public class User {
	private int id;
	private String name;
	private String identity;
	private String password;
	private int type; // 用户类型：（大于0是旅客）旅客类型：普通、会员。（小于0是管理员）管理员类型：超级管理员。
	private String memo; // 管理员、前台

	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param identity
	 * @param password
	 * @param type
	 * @param memo
	 */
	public User(int id, String name, String identity, String password, int type, String memo) {
		this.id = id;
		this.name = name;
		this.identity = identity;
		this.password = password;
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
	 * @return the identity
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * @param identity
	 *            the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
		return "User [id=" + id + ", name=" + name + ", identity=" + identity + ", password=" + password + ", type="
				+ type + ", memo=" + memo + "]";
	}

}
