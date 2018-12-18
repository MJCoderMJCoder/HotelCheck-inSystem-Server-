/**
 * 
 */
package com.lzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lzf.entity.Room;

/**
 * @author MJCoder
 *
 */
public interface IDaoCheckIn {
	List<Room> select(@Param(value = "name") String name, @Param(value = "identity") String identity);

	int update(@Param(value = "name") String name, @Param(value = "identity") String identity,
			@Param(value = "id") int id);
}
