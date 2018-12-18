/**
 * 
 */
package com.lzf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoCheckIn;
import com.lzf.entity.Room;
import com.lzf.service.IServiceCheckIn;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceCheckIn implements IServiceCheckIn {

	@Autowired
	private IDaoCheckIn daoCheckIn;

	/**
	 * 
	 */
	public ServiceCheckIn() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Room> select(String name, String identity) {
		// TODO Auto-generated method stub
		List<Room> rooms = daoCheckIn.select(name, identity);
		for (Room room : rooms) {
			daoCheckIn.update(name, identity, room.getId());
		}
		return rooms;
	}
}
