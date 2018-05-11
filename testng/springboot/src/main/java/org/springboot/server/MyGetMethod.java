package org.springboot.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/",description = "这是接口的GET方法")
public class MyGetMethod {
	@RequestMapping(value = "/getCookies", method = RequestMethod.GET)
	@ApiOperation(value = "获取cookies方法",httpMethod = "GET")
	public String getCookies(HttpServletResponse response) {
		/*
		 * HttpServerletRequest 装请求信息的类 HttpServerletResponse 装响应信息的类
		 */
		Cookie cookie = new Cookie("token", "hello");
		response.addCookie(cookie);
		return "cookies信息获取成功";
	}
	
	/*
	 * 要求客户端携带cookies访问
	 * 这是一个需要携带cookies信息才能访问的get请求
	 */

	@RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
	@ApiOperation(value = "校验客户端请求是否带cookies方法",httpMethod = "GET")
	public String getWithCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			return "未获取到请求中的cookies信息或cookies信息错误";
		} 
		for (Cookie cookie:cookies) {
			if (cookie.getName().equals("token") && cookie.getValue().equals("me")){
				return "cookies信息验证通过";
			}
		}
		return "未获取到请求中的cookies信息或cookies信息错误";
	}
	
	/*
	 * 一个需要携带参数才能访问的get请求
	 * 第一种实现方式 url:key=value&key=value
	 * http://localhost:8080/get/commodity/list?start=1&end=10
	 * 模拟商品列表实例
	 */
	@RequestMapping(value = "/get/commodity/list1",method = RequestMethod.GET)
	@ApiOperation(value = "需带参访问实现的get方法一",httpMethod = "GET")
	public Map<String, Integer> getList1(@RequestParam Integer start,@RequestParam Integer end){
		Map<String, Integer> hs = new HashMap<String,Integer>();
		hs.put("短袖", 50);
		hs.put("长袖", 70);
		hs.put("衬衫", 80);
		hs.put("外套", 120);
		hs.put("棉衣", 200);
/*		
		if (end < start && start > hs.size() && end > hs.size()) {
			System.out.printf("错误");
		}*/
		return hs;
		
	}
	/*
	 * 第一种实现方式 url
	 * http://localhost:8080/get/commodity/list/star/end
	 */
	@RequestMapping(value = "/get/commodity/list2/{start}/{end}",method = RequestMethod.GET)
	@ApiOperation(value = "需带参访问实现的get方法二",httpMethod = "GET")
	public Map<String, Integer> getList2(@PathVariable Integer start,@PathVariable Integer end){
		Map<String, Integer> hs = new HashMap<String,Integer>();
		hs.put("短袖", 50);
		hs.put("长袖", 70);
		hs.put("衬衫", 80);
		hs.put("外套", 120);
		return hs;
	}
	
	
	

}
