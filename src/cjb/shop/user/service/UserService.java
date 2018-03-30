package cjb.shop.user.service;

import org.springframework.transaction.annotation.Transactional;

import cjb.shop.user.dao.UserDao;
import cjb.shop.user.domain.User;

/**
 * @author chenjibao
 *@date2018年3月30日下午9:45:07
 *@description;用户模块业务层类
 */
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}

}
