package cjb.shop.user.action;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cjb.shop.user.domain.User;
import cjb.shop.user.service.UserService;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;
/**
 * @author chenjibao
 *@date2018年3月30日下午8:42:14
 *@description:用户模块Aciton
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	// 注入UserService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	//模型驱动要使用的对象
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	
	/**
	 * 跳转到注册页面的方法
	 */
	public String registPage() {
		return "registPage";
	}
	
	/**
	 * AJAX进行异步校验用户名的执行方法
	 * 
	 * @throws IOException
	 */
	public String findByUsername() throws IOException {
		// 调用Service进行查询:
		User existUser = userService.findByUsername(user.getUsername());
		// 获得response对象,项页面输出:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (existUser != null) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	/**
	 * 用户注册的方法
	 * @return
	 * @throws IOException 
	 */
	public String regist() {
		userService.save(user);
		
		return NONE;
	}

}
