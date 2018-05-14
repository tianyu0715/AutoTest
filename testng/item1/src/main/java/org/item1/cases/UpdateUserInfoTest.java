package org.item1.cases;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.item1.config.TestConfig;
import org.item1.model.UpdateUserInfoCase;
import org.item1.utils.DatabaseUtil;
import org.testng.annotations.Test;


public class UpdateUserInfoTest {
	@Test(dependsOnGroups = "loginTrue",description = "更改用户信息")
	public void updateUserInfo() throws IOException {
		SqlSession session = DatabaseUtil.getSqlSession();
		UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase", 1);
		System.out.println(updateUserInfoCase.toString());
		System.out.println(TestConfig.updateUserInfoUrl);
	}
	@Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
	public void deleteUser() throws IOException {
		SqlSession session = DatabaseUtil.getSqlSession();
		UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase", 2);
		System.out.println(updateUserInfoCase.toString());
		System.out.println(TestConfig.updateUserInfoUrl);
	}
	
}
