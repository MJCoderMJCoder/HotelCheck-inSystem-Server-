/**
 * 
 */
package com.lzf.web.mobile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.entity.User;
import com.lzf.service.IServiceIndex;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("user")
public class ControlUser {

	@Autowired
	private IServiceIndex serviceIndex;

	/**
	 * 
	 */
	public ControlUser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 注册
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	private Object register(HttpServletRequest request) {
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String password = request.getParameter("password");
		int result = serviceIndex.insert(new User(0, name, identity, password, 15, null));
		DtoPackaging dtoPackaging = null;
		if (result == -6003) {
			dtoPackaging = new DtoPackaging(false, "注册失败", null);
		} else {
			User user = serviceIndex.login(identity, password, 1);
			if (user == null) {
				user = serviceIndex.login(identity, password, -1);
			}
			dtoPackaging = new DtoPackaging(true, "注册成功", user);
		}
		return dtoPackaging;
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	private Object login(HttpServletRequest request) {
		String identity = request.getParameter("identity");
		String password = request.getParameter("password");
		System.out.println(identity + "；" + password);
		DtoPackaging dtoPackaging = null;
		User user = serviceIndex.login(identity, password, 1);
		if (user == null) {
			user = serviceIndex.login(identity, password, -1);
			if (user == null) {
				dtoPackaging = new DtoPackaging(false, "登录失败", null);
			} else {
				dtoPackaging = new DtoPackaging(true, "登录成功", user);
			}
		} else {
			dtoPackaging = new DtoPackaging(true, "登录成功", user);
		}
		return dtoPackaging;
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	private Object test() {
		return new DtoPackaging(false, "测试", null);
	}

}
