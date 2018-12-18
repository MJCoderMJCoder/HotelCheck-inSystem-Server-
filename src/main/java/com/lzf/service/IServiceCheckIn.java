/**
 * 
 */
package com.lzf.service;

import java.util.List;

import com.lzf.entity.Room;

/**
 * @author MJCoder
 *
 */
public interface IServiceCheckIn {
	List<Room> select(String name, String identity);
}
