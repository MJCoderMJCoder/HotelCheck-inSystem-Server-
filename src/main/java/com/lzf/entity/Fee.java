/**
 * 
 */
package com.lzf.entity;

import java.sql.Timestamp;

/**
 * @author MJCoder
 *
 *         收费信息管理？？？
 */
public class Fee {
	private int id;
	private float fee; // 费用
	private String memo; // 描述：方便面+水+spa
	private Timestamp timestamp;

	/**
	 * 
	 */
	public Fee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param fee
	 * @param memo
	 * @param timestamp
	 */
	public Fee(int id, float fee, String memo, Timestamp timestamp) {
		this.id = id;
		this.fee = fee;
		this.memo = memo;
		this.timestamp = timestamp;
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
	 * @return the fee
	 */
	public float getFee() {
		return fee;
	}

	/**
	 * @param fee
	 *            the fee to set
	 */
	public void setFee(float fee) {
		this.fee = fee;
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

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fee [id=" + id + ", fee=" + fee + ", memo=" + memo + ", timestamp=" + timestamp + "]";
	}

}
