/**
 * 
 */
package com.lzf.dao;

import java.util.List;

import com.lzf.entity.Goods;
import com.lzf.entity.Room;

/**
 * @author MJCoder
 *
 */
public interface IDaoGoods {

	int insert(Goods goods);

	List<Goods> select();

	int update(Goods goods);

	int delete(int id);
}
