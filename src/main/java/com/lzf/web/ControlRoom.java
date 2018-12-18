/**
 * 
 */
package com.lzf.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.entity.Room;
import com.lzf.service.IServiceRoom;

/**
 * 控制层
 * 
 * @author MJCoder
 *
 */

@Controller
@RequestMapping("room") // url:/模块/资源/{id}/细分 /seckill/list
public class ControlRoom {
	// 注入Service
	@Autowired
	private IServiceRoom serviceRoom;

	/**
	 * 
	 */
	public ControlRoom() {
		// TODO Auto-generated constructor stub
	}

	// @RequestMapping(value = "sysConfigs")
	// @ResponseBody // 返回json
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	private Object insert(HttpServletRequest request) {
		String room = request.getParameter("room");
		String price = request.getParameter("price");
		String fewHuman = request.getParameter("fewHuman");
		String type = request.getParameter("type");
		int result = serviceRoom.insert(
				new Room(0, room, Float.parseFloat(price), Integer.parseInt(fewHuman), 0, 0, null, null, type, null));
		List<Room> rooms = serviceRoom.select();
		request.setAttribute("room", room);
		request.setAttribute("price", price);
		request.setAttribute("fewHuman", fewHuman);
		request.setAttribute("type", type);
		request.setAttribute("rooms", rooms);
		if (result == -6003) {
			request.setAttribute("errorMsg", "系统中已有该房间，无需重复录入；如果需要可以在原有房间数据上进行修改。");
		} else {
			request.setAttribute("errorMsg", "添加成功");
		}
		return "jsp/room";
	}

	@RequestMapping(value = "select", method = RequestMethod.GET)
	private Object select(HttpServletRequest request) {
		List<Room> rooms = serviceRoom.select();
		request.setAttribute("rooms", rooms);
		return "jsp/room";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	private Object update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String price = request.getParameter("price");
		String fewHuman = request.getParameter("fewHuman");
		String status = request.getParameter("status");
		String type = request.getParameter("type");
		String errorMsg = "";
		if (serviceRoom.update(new Room(Integer.parseInt(id), null, Float.parseFloat(price), Integer.parseInt(fewHuman),
				Integer.parseInt(status), 31, null, null, type, null)) == -6003) {
			errorMsg = "修改失败";
		} else {
			errorMsg = "修改成功";
		}
		return errorMsg;
	}

	// @RequestMapping(value = "sysConfigs")
	// @ResponseBody // 返回json
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@ResponseBody
	private Object delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		int result = serviceRoom.delete(Integer.parseInt(id));
		String errorMsg = "";
		if (result == -6003) {
			errorMsg = "删除失败";
		} else {
			errorMsg = "删除成功";
		}
		return errorMsg;
	}
}
