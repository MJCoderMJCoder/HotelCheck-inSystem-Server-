/**
 * 
 */
package com.lzf.web.mobile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzf.entity.Goods;
import com.lzf.service.IServiceFee;
import com.lzf.service.IServiceGoods;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("mGoods")
public class ControlMobileGoods {

	@Autowired
	private IServiceGoods serviceGoods;
	@Autowired
	private IServiceFee serviceFee;

	/**
	 * 
	 */
	public ControlMobileGoods() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 查询所有商品
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "select", method = RequestMethod.GET)
	@ResponseBody
	private Object select(HttpServletRequest request) {
		List<Goods> goods = serviceGoods.select();
		DtoPackaging dtoPackaging = null;
		if (goods != null) {
			dtoPackaging = new DtoPackaging(true, "找到额外服务", goods);
		} else {
			dtoPackaging = new DtoPackaging(false, "未找到额外服务", null);
		}
		return dtoPackaging;
	}

	@RequestMapping(value = "fee", method = RequestMethod.GET)
	@ResponseBody
	private Object fee(HttpServletRequest request) {
		String fee = request.getParameter("fee");
		String memo = request.getParameter("memo");
		int temp = serviceFee.insert(Float.parseFloat(fee), memo);
		DtoPackaging dtoPackaging = null;
		if (temp != -6003) {
			dtoPackaging = new DtoPackaging(true, "购买成功", null);
		} else {
			dtoPackaging = new DtoPackaging(false, "购买失败", null);
		}
		return dtoPackaging;
	}
}
