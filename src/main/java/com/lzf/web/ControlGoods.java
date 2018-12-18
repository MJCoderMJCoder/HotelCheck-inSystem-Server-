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

import com.lzf.entity.Goods;
import com.lzf.entity.Room;
import com.lzf.service.IServiceGoods;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("goods")
public class ControlGoods {

	@Autowired
	private IServiceGoods serviceGoods;

	/**
	 * 
	 */
	public ControlGoods() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "select", method = RequestMethod.GET)
	private Object select(HttpServletRequest request) {
		List<Goods> goods = serviceGoods.select();
		request.setAttribute("goods", goods);
		return "jsp/goods";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	private Object insert(HttpServletRequest request) {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int insert = serviceGoods.insert(new Goods(0, name, Float.parseFloat(price)));
		List<Goods> goods = serviceGoods.select();
		request.setAttribute("goods", goods);
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		if (insert == -6003) {
			request.setAttribute("errorMsg", "添加失败");
		} else {
			request.setAttribute("errorMsg", "添加成功");
		}
		return "jsp/goods";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	private Object update(HttpServletRequest request) {
		String id = request.getParameter("id");
		String price = request.getParameter("price");
		String errorMsg = "";
		if (serviceGoods.update(new Goods(Integer.parseInt(id), null, Float.parseFloat(price))) == -6003) {
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
		int result = serviceGoods.delete(Integer.parseInt(id));
		String errorMsg = "";
		if (result == -6003) {
			errorMsg = "删除失败";
		} else {
			errorMsg = "删除成功";
		}
		return errorMsg;
	}

}
