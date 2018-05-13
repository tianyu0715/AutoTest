package org.mybatis.controller;

import org.mybatis.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@Api(value = "v1",description = "第一个版本demo")
@RequestMapping("v1")
public class Demo {
	@Autowired
	private SqlSessionTemplate template;
	
	@RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
	@ApiOperation(value = "获取用户数",httpMethod = "GET")
	public int getUserCount() {
		return template.selectOne("getusercount");
	}
	@RequestMapping(value = "/addUser",method = RequestMethod.POST)
	@ApiOperation(value = "添加用户",httpMethod = "POST")
	public int addUser(@RequestBody User user) {
		return template.insert("addUser",user);
	}
	@RequestMapping(value = "/updateUser",method = RequestMethod.POST)
	@ApiOperation(value = "更新用户",httpMethod = "POST")
	public int updateUser(@RequestBody User user) {
		return template.update("updateUser",user);
	}
	
	@RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
	@ApiOperation(value = "删除用户",httpMethod = "GET")
	public int delUser(@RequestParam int id) {
		return template.delete("deleteUser",id);
	}
}
