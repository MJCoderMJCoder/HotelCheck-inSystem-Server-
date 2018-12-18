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
public interface IServiceRoom {
	int insert(Room room);

	List<Room> select();

	int update(Room room);

	int delete(int id);

	List<Room> selectVacantRoom();

	List<Room> selectUserRoom(int userId);
}
