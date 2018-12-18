/**
 * 
 */
package com.lzf.service;

import java.util.List;

import com.lzf.entity.UserType;

/**
 * @author MJCoder
 *
 */
public interface IServiceUserType {

	List<UserType> selectUser();

	List<UserType> selectAdmin();

	int insert(UserType userType);
}
