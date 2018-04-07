package cjb.shop.order.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class OrderDao {
	//注入HibernateTemplate
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}

}
