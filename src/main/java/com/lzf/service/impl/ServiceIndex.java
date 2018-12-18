/**
 * 
 */
package com.lzf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lzf.dao.IDaoIndex;
import com.lzf.entity.User;
import com.lzf.service.IServiceIndex;

/**
 * @author MJCoder
 *
 */
@Service
public class ServiceIndex implements IServiceIndex {

	// 注入dao@Autowired
	@Resource
	private IDaoIndex daoIndex;

	/**
	 * 
	 */
	public ServiceIndex() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(String identity, String password, int type) {
		// TODO Auto-generated method stub
		return daoIndex.login(identity, password, type);
	}

	@Override
	public List<User> select(int type) {
		// TODO Auto-generated method stub
		return daoIndex.select(type);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		int temp = -6003;
		try {
			temp = daoIndex.insert(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		int temp = -6003;
		try {
			temp = daoIndex.update(user);
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
			temp = daoIndex.delete(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

}
