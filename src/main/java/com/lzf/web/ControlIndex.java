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

import com.lzf.entity.User;
import com.lzf.entity.UserType;
import com.lzf.service.IServiceIndex;
import com.lzf.service.IServiceUserType;

/**
 * 控制层
 * 
 * @author MJCoder
 *
 */

@Controller
@RequestMapping("controller") // url:/模块/资源/{id}/细分 /seckill/list
public class ControlIndex {
	// 注入Service
	@Autowired
	private IServiceIndex serviceIndex;
	@Autowired
	private IServiceUserType serviceUserType;

	/**
	 * 
	 */
	public ControlIndex() {
		// TODO Auto-generated constructor stub
	}

	// @RequestMapping(value = "sysConfigs")
	// @ResponseBody //返回json
	@RequestMapping(value = "login", method = RequestMethod.POST)
	private Object login(HttpServletRequest request) {
		String identity = request.getParameter("identity");
		String password = request.getParameter("password");
		User user = serviceIndex.login(identity, password, -1);
		System.out.println(user);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			return "jsp/main";
		} else {
			request.setAttribute("identity", identity);
			request.setAttribute("password", password);
			request.setAttribute("errorMsg", "身份证和密码不匹配（PC端只允许管理员登录哦）");
			return "index";
		}
	}

	@RequestMapping(value = "selectStaff", method = RequestMethod.GET)
	private Object selectStaff(HttpServletRequest request) {
		List<User> users = serviceIndex.select(-1);
		request.setAttribute("users", users);
		List<UserType> userTypes = serviceUserType.selectAdmin();
		request.setAttribute("userTypes", userTypes);
		return "jsp/staff";
	}

	@RequestMapping(value = "selectUser", method = RequestMethod.GET)
	private Object selectUser(HttpServletRequest request) {
		List<User> users = serviceIndex.select(1);
		request.setAttribute("users", users);
		List<UserType> userTypes = serviceUserType.selectUser();
		request.setAttribute("userTypes", userTypes);
		return "jsp/user";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	private Object insert(HttpServletRequest request) {
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String type = request.getParameter("type");
		String password = request.getParameter("password");
		int result = serviceIndex.insert(new User(0, name, identity, password, Integer.parseInt(type), null));
		if (result == -6003) {
			request.setAttribute("errorMsg", "添加失败");
		} else {
			request.setAttribute("errorMsg", "添加成功");
		}
		request.setAttribute("name", name);
		request.setAttribute("identity", identity);
		request.setAttribute("type", type);
		request.setAttribute("password", password);
		List<User> users = serviceIndex.select(-1);
		request.setAttribute("users", users);
		List<UserType> userTypes = serviceUserType.selectAdmin();
		request.setAttribute("userTypes", userTypes);
		return "jsp/staff";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	private Object update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String password = request.getParameter("password");
		int result = serviceIndex
				.update(new User(Integer.parseInt(id), null, null, password, Integer.parseInt(type), null));
		if (result == -6003) {
			return "修改失败";
		} else {
			return "修改成功";
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@ResponseBody
	private Object delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		int result = serviceIndex.delete(Integer.parseInt(id));
		if (result == -6003) {
			return "修改失败";
		} else {
			return "修改成功";
		}
	}
}
