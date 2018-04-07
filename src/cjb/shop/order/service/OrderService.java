package cjb.shop.order.service;

import cjb.shop.order.dao.OrderDao;

/**
 *@author chenjibao
 *@date2018年4月7日上午9:50:42
 *@description:订单模块的业务层
 */
public class OrderService {
	//注入持久层dao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	

}
