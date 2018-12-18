/**
 * 
 */
package com.lzf.service;

import java.util.List;

import com.lzf.entity.Goods;

/**
 * @author MJCoder
 *
 */
public interface IServiceGoods {
	int insert(Goods goods);

	List<Goods> select();

	int update(Goods goods);

	int delete(int id);
}
