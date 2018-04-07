package cjb.shop.order.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import cjb.shop.order.domain.Order;
import utils.PageHibernateCallback;

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
		//dao层我的订单的个数统计（根据用户id查询用户的订单个数）
		public Integer findCountByUid(Integer uid) {
			String hql="select count(*) from Order o where o.user.uid=?";
			List<Long> list=(List<Long>) hibernateTemplate.find(hql, uid);
			if(list!=null && list.size()>0){
				return list.get(0).intValue();
			}
			return null;
		}
		//dao层我的订单当前页的集合查询
		public List<Order> findPageByUid(Integer uid, int begin, int limit) {
			String hql="from Order o where o.user.uid=? order by ordertime desc";
			List<Order> list= hibernateTemplate.execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, begin, limit)); 
			return list;
		}

}
