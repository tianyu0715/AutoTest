package org.item1.cases;

import java.io.IOException;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.item1.config.TestConfig;
import org.item1.model.InterFaceName;
import org.item1.model.LoginCase;
import org.item1.utils.ConfigFile;
import org.item1.utils.DatabaseUtil;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	@BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpclient对象")
	public void beforeTest() {
		TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterFaceName.GETUSERINFO);
		TestConfig.getUserListUrl = ConfigFile.getUrl(InterFaceName.GETUSERLIST);
		TestConfig.addUserUrl = ConfigFile.getUrl(InterFaceName.ADDUSERINFO);
		TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterFaceName.UPDATEUSERINFO);
		TestConfig.loginUrl = ConfigFile.getUrl(InterFaceName.LOGIN);
		
		TestConfig.defaultHttpClient = new DefaultHttpClient();
	}
	
	@Test(groups = "loginTrue",description = "用户登录成功接口测试")
	public void loginTrue() throws IOException {
		SqlSession session = DatabaseUtil.getSqlSession();
		//id=loginCase,id为1
		LoginCase loginCase = session.selectOne("loginCase",1);
		System.out.println(loginCase.toString());
		System.out.println(TestConfig.loginUrl);
	}
	@Test(groups = "loginFalse",description = "用户登录失败接口测试")
	public void loginFalse() throws IOException {
		SqlSession session = DatabaseUtil.getSqlSession();
		LoginCase loginCase = session.selectOne("loginCase",2);
		System.out.println(loginCase.toString());
		System.out.println(TestConfig.loginUrl);
	}
	
}
