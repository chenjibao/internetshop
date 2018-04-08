package cjb.shop.adminuser.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 *@author chenjibao
 *@date2018年4月8日上午9:56:00
 *@description:后台用户dao层的类
 */

public class AdminUserDao {
			//得到hibernateTemplate对象
			private HibernateTemplate hibernateTemplate;
			public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
				this.hibernateTemplate = hibernateTemplate;
			}

}
