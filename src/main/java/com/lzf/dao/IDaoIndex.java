/**
 * 
 */
package com.lzf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lzf.entity.Goods;
import com.lzf.entity.User;

/**
 * *持久层
 * 
 * org.apache.ibatis.annotations.Param
 * 有两个或以上的参数，一定要给方法的参数添加@Param("")注解，不然mybatis识别不了。注解的参数会自动封装成map集合，括号内即为键。
 * 只有一个参数，可以不用加 @Param注解，当然加了也无所谓。
 * 
 * @author MJCoder
 *
 */
public interface IDaoIndex {
	User login(@Param(value = "identity") String identity, @Param(value = "password") String password,
			@Param(value = "type") int type);

	List<User> select(int type);

	int insert(User user);

	int update(User user);

	int delete(int id);
}
