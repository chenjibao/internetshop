package cjb.shop.user.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.user.domain.User;

/**
 * @author chenjibao
 *@date2018年3月30日下午9:44:37
 *@description:用户模块持久层类
 */
public class UserDao {
	//得到hibernateTemplate对象
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		

	   public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}


	/**
	 * 按用户名查询是否有该用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username){
		String hql="from User where username=?";
		List<User> list=(List<User>)hibernateTemplate.find(hql, username);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	/**
	 * 向user表汇总插入一条记录
	 * @param user
	 */
	// 注册用户存入数据库代码实现
	public void save(User user) {
		
		hibernateTemplate.save(user);
	}


	public User findByCode(String code) {
		String hql="from User where code=?";
		List<User> list=(List<User>) hibernateTemplate.find(hql, code);
		if(list!=null && list.size()>=0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 修改用户状态的方法
	 * @param existUser
	 */
	public void update(User existUser) {
		hibernateTemplate.update(existUser);
	}
}
