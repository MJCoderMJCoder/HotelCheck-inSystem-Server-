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

import com.lzf.entity.Fee;
import com.lzf.entity.Goods;
import com.lzf.service.IServiceFee;

/**
 * @author MJCoder
 *
 */
@Controller
@RequestMapping("fee") // url:/模块/资源/{id}/细分 /seckill/list
public class ControlFee {

	@Autowired
	private IServiceFee serviceFee;

	/**
	 * 
	 */
	public ControlFee() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "select", method = RequestMethod.GET)
	private Object select(HttpServletRequest request) {
		List<Fee> fees = serviceFee.select();
		float sum = serviceFee.selectSum();
		request.setAttribute("fees", fees);
		request.setAttribute("sum", sum);
		return "jsp/fee";
	}

}
