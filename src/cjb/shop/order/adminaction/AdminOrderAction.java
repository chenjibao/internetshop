package cjb.shop.order.adminaction;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.order.domain.Order;
import cjb.shop.order.service.OrderService;
import cjb.shop.utils.PageBean;
/**
 *@author chenjibao
 *@date2018年4月9日下午9:17:04
 *@description:后台订单管理的acton
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	//模型
	private Order order=new Order();
	//注入订单的service
	private OrderService orderService;
	//注入page参数
	private Integer page;
	
	public void setPage(Integer page) {
		this.page = page;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Override
	public Order getModel() {
		return order;
	}
	//带分页的查询所有订单的方法
	public String findAll(){
		PageBean<Order> pageBean=orderService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAllSuccess";
	}
	
}
