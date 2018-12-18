/**
 * 
 */
package com.lzf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoFee;
import com.lzf.entity.Fee;
import com.lzf.service.IServiceFee;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceFee implements IServiceFee {

	@Autowired
	private IDaoFee daoFee;

	/**
	 * 
	 */
	public ServiceFee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Fee> select() {
		// TODO Auto-generated method stub
		return daoFee.select();
	}

	@Override
	public float selectSum() {
		// TODO Auto-generated method stub
		float sum = 0.0f;
		try {
			sum = daoFee.selectSum();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sum;
	}

	@Override
	public int insert(float fee, String memo) {
		// TODO Auto-generated method stub
		int temp = -6003;
		try {
			temp = daoFee.insert(fee, memo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}
}
