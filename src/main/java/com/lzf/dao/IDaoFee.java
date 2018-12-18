/**
 * 
 */
package com.lzf.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lzf.entity.Fee;

/**
 * @author MJCoder
 *
 */
public interface IDaoFee {
	List<Fee> select();

	float selectSum();

	int insert(@Param(value = "fee") float fee, @Param(value = "memo") String memo);
}
