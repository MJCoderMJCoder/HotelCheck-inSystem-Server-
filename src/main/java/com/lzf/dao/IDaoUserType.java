/**
 * 
 */
package com.lzf.dao;

import java.util.List;

import com.lzf.entity.UserType;

/**
 * @author MJCoder
 *
 */
public interface IDaoUserType {
	List<UserType> selectUser();

	List<UserType> selectAdmin();

	int insert(UserType userType);
}
