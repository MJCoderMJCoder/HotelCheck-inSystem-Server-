/**
 * 
 */
package com.lzf.service;

import java.util.List;

import com.lzf.entity.User;

/**
 * 业务层
 * 
 * @author MJCoder
 *
 */
public interface IServiceIndex {
	User login(String identity, String password, int type);

	List<User> select(int type);

	int insert(User user);

	int update(User user);

	int delete(int id);
}
