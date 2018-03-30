package cjb.shop.user.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author chenjibao
 *@date2018年3月30日下午8:42:14
 *@description:用户模块Aciton
 */
public class UserAction extends ActionSupport {
	/**
	 * 跳转到注册页面的方法
	 */
	public String registPage(){
		return "registPage";
	}

}
