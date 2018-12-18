/**
 * 
 */
package com.lzf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoGoods;
import com.lzf.entity.Goods;
import com.lzf.service.IServiceGoods;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceGoods implements IServiceGoods {

	@Autowired
	private IDaoGoods daoGoods;

	/**
	 * 
	 */
	public ServiceGoods() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Goods> select() {
		// TODO Auto-generated method stub
		return daoGoods.select();
	}

	@Override
	public int insert(Goods goods) {
		// TODO Auto-generated method stub
		int temp = -6003;
		try {
			temp = daoGoods.insert(goods);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int update(Goods goods) {
		// TODO Auto-generated method stub
		int temp = -6003;
		try {
			temp = daoGoods.update(goods);
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
			temp = daoGoods.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

}
