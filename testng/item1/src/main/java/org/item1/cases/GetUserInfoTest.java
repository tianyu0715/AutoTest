package org.item1.cases;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.item1.config.TestConfig;
import org.item1.model.GetUserInfoCase;
import org.item1.utils.DatabaseUtil;
import org.testng.annotations.Test;

public class GetUserInfoTest {
	@Test(dependsOnGroups = "loginTrue",description = "获取useriId为1的用户")
	public void getUserInfo() throws IOException {
		SqlSession session = DatabaseUtil.getSqlSession();
		GetUserInfoCase getUserInfoCase = session.selectOne("getUserInfoCase", 1);
		System.out.println(getUserInfoCase.toString());
		System.out.println(TestConfig.getUserInfoUrl);
	}
}
