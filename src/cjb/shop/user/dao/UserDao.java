package cjb.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cjb.shop.user.domain.User;

/**
 * @author chenjibao
 *@date2018年3月30日下午9:44:37
 *@description:用户模块持久层类
 */
public class UserDao extends HibernateDaoSupport{
	/**
	 * 按用户名查询是否有该用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username){
		String hql="from User where username=?";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql, username);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
