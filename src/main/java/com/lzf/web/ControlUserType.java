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

import com.lzf.entity.Room;
import com.lzf.entity.UserType;
import com.lzf.service.IServiceUserType;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("userType")
public class ControlUserType {

	@Autowired
	private IServiceUserType serviceUserType;

	/**
	 * 
	 */
	public ControlUserType() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "select", method = RequestMethod.GET)
	private Object select(HttpServletRequest request) {
		List<UserType> users = serviceUserType.selectUser();
		List<UserType> admins = serviceUserType.selectAdmin();
		request.setAttribute("users", users);
		request.setAttribute("admins", admins);
		return "jsp/usertype";
	}

	@RequestMapping(value = "insertAdmin", method = RequestMethod.POST)
	private Object insertAdmin(HttpServletRequest request) {
		String memo = request.getParameter("memo");
		int result = serviceUserType.insert(new UserType(0, -1, memo));
		List<UserType> users = serviceUserType.selectUser();
		List<UserType> admins = serviceUserType.selectAdmin();
		request.setAttribute("memoAdmin", memo);
		request.setAttribute("users", users);
		request.setAttribute("admins", admins);
		if (result == -6003) {
			request.setAttribute("errorMsgAdmin", "添加失败");
		} else {
			request.setAttribute("errorMsgAdmin", "添加成功");
		}
		return "jsp/usertype";
	}

	@RequestMapping(value = "insertUser", method = RequestMethod.POST)
	private Object insertUser(HttpServletRequest request) {
		String memo = request.getParameter("memo");
		int result = serviceUserType.insert(new UserType(0, 1, memo));
		List<UserType> users = serviceUserType.selectUser();
		List<UserType> admins = serviceUserType.selectAdmin();
		request.setAttribute("memoUser", memo);
		request.setAttribute("users", users);
		request.setAttribute("admins", admins);
		if (result == -6003) {
			request.setAttribute("errorMsgUser", "添加失败");
		} else {
			request.setAttribute("errorMsgUser", "添加成功");
		}
		return "jsp/usertype";
	}
}
