/**
 * 
 */
package com.lzf.web.mobile;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("userRoom")
public class ControlUserRoom {

	@Autowired
	private IServiceRoom serviceRoom;

	/**
	 * 
	 */
	public ControlUserRoom() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 查询空房间和用户的房间
	 * 
	 * @return
	 */
	@RequestMapping(value = "vacantOrUserRoom", method = RequestMethod.GET)
	@ResponseBody
	private Object selectVacantOrUserRoom(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		System.out.println(userId);
		List<Room> vacantRooms = serviceRoom.selectVacantRoom();
		List<Room> userRooms = serviceRoom.selectUserRoom(Integer.parseInt(userId));
		DtoPackaging dtoPackaging = null;
		if (vacantRooms != null || userRooms != null) {
			dtoPackaging = new DtoPackaging(true, "找到房间", new Object[] { vacantRooms, userRooms });
		} else {
			dtoPackaging = new DtoPackaging(false, "未找到房间", null);
		}
		return dtoPackaging;
	}

	/**
	 * 预订入住
	 * 
	 * @return
	 */
	@RequestMapping(value = "userHandleRoom", method = RequestMethod.GET)
	@ResponseBody
	private Object userHandleRoom(HttpServletRequest request) {
		int temp = -6003;
		try {
			String price = request.getParameter("price");
			String fewHuman = request.getParameter("fewHuman");
			String status = request.getParameter("status");
			String userId = request.getParameter("userId");
			String type = request.getParameter("type");
			String roomId = request.getParameter("roomId");
			String checkinTime = request.getParameter("checkinTime");
			String checkoutTime = request.getParameter("checkoutTime");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			temp = serviceRoom.update(new Room(Integer.parseInt(roomId), "", Float.parseFloat(price),
					Integer.parseInt(fewHuman), Integer.parseInt(status), Integer.parseInt(userId), null,
					new Timestamp(simpleDateFormat.parse(checkinTime).getTime()), type,
					new Timestamp(simpleDateFormat.parse(checkoutTime).getTime())));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DtoPackaging dtoPackaging = null;
		if (temp == -6003) {
			dtoPackaging = new DtoPackaging(false, "失败", null);
		} else {
			dtoPackaging = new DtoPackaging(true, "成功", null);
		}
		return dtoPackaging;
	}

}
