package org.springboot.server;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springboot.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/", description = "这是接口的POST方法")
@RequestMapping(value = "/v1")
public class MyPostMethod {
	// 放置cookie信息
	private static Cookie cookie;

	// 用户登录成功获取到cookies,后在访问其他接口获取列表
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ApiOperation(value = "登录接口，成功后获取cookies信息",httpMethod = "POST")
	public String login(HttpServletResponse response,
//			required = true必填字段
			@RequestParam(value = "userName",required = true) String userName,
			@RequestParam(value = "passWord",required = true) String passWord) {
		if (userName.equals("admin") && passWord.equals("123456")){
			cookie = new Cookie("token", "like");
			response.addCookie(cookie);
			return "登录成功";
		}
		return "用户民或密码错误，请检查";
		
	}
	@RequestMapping(value = "/getUserList",method = RequestMethod.POST)
	@ApiOperation(value = "获取用户列表",httpMethod = "POST")
	public String getUserList(HttpServletRequest request,
			@RequestBody User u) {
		User user;
//		获取cookies
		Cookie[] cookies = request.getCookies();
	
		for (Cookie c:cookies) {
			if (c.getName().equals("token") && c.getValue().equals("like")
					&& u.getUserName().equals("admin")
					&& u.getPassWord().equals("123456")){
				user = new User();
				user.setName("乞丐");
				user.setAge("60");
				user.setSex("男");
				user.setUserName("13000000000");
				user.setPassWord("qwerty");
				return user.toString();			
			}
					
		}
		return "参数不合法";
	}
}
