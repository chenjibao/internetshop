package cjb.shop.order.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import cjb.shop.order.domain.Order;

public class OrderDao {
		//注入HibernateTemplate
		private HibernateTemplate hibernateTemplate;
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		//生成订单
		public void save(Order order) {
			hibernateTemplate.save(order);
		}

}
