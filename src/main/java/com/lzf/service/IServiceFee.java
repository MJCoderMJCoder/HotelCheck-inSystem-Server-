/**
 * 
 */
package com.lzf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lzf.entity.Fee;

/**
 * @author MJCoder
 *
 */
public interface IServiceFee {

	List<Fee> select();

	float selectSum();

	int insert(float fee, String memo);
}
