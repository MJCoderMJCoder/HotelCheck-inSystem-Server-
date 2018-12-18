/**
 * 
 */
package com.lzf.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoFee;
import com.lzf.dao.IDaoRoom;
import com.lzf.entity.Room;
import com.lzf.service.IServiceRoom;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceRoom implements IServiceRoom {

	@Autowired
	private IDaoRoom daoRoom;
	@Autowired
	private IDaoFee daoFee;

	/**
	 * 
	 */
	public ServiceRoom() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(Room room) {
		// TODO Auto-generated method stub
		int temp = -6003;
		try {
			temp = daoRoom.insert(room);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public List<Room> select() {
		// TODO Auto-generated method stub
		List<Room> rooms = daoRoom.select();
		for (Room room : rooms) {
			room.setUser(daoRoom.selectUser(room.getUserId()));
		}
		System.out.println(rooms);
		return rooms;
	}

	@Override
	public int update(Room room) {
		// TODO Auto-generated method stub
		int temp = -6003;
		try {
			if (room.getStatus() == 1) {
				daoFee.insert(
						room.getPrice() * (Integer
								.parseInt(room.getCheckoutTime().getYear() + "" + room.getCheckoutTime().getMonth() + ""
										+ room.getCheckoutTime().getDay())
								- Integer.parseInt(room.getCheckinTime().getYear() + ""
										+ room.getCheckinTime().getMonth() + "" + room.getCheckinTime().getDay())),
						room.getType() + "：" + (room.getName() == null ? "" : room.getName()));
			}
			temp = daoRoom.update(room);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		int temp = -6003;
		try {
			temp = daoRoom.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public List<Room> selectVacantRoom() {
		// TODO Auto-generated method stub
		return daoRoom.selectVacantRoom();
	}

	@Override
	public List<Room> selectUserRoom(int userId) {
		// TODO Auto-generated method stub
		System.out.println(daoRoom.selectUserRoom(userId));
		return daoRoom.selectUserRoom(userId);
	}

}
