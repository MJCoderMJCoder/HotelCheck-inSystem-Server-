/**
 * 
 */
package com.lzf.dao;

import java.util.List;

import com.lzf.entity.Room;
import com.lzf.entity.User;

/**
 * @author MJCoder
 *
 */
public interface IDaoRoom {
	int insert(Room room);

	List<Room> select();

	User selectUser(int id);

	int update(Room room);

	int delete(int id);

	List<Room> selectVacantRoom();

	List<Room> selectUserRoom(int userId);
}
