package org.item1.cases;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.item1.config.TestConfig;
import org.item1.model.GetUserListCase;
import org.item1.utils.DatabaseUtil;
import org.testng.annotations.Test;

public class GetUserListTest {
	@Test(dependsOnGroups = "loginTrue", description = "获取性别为男的用户信息")
	public void getUserList() throws IOException {
		SqlSession session = DatabaseUtil.getSqlSession();
		GetUserListCase getUserListCase = session.selectOne("getUserListCase", 1);
		System.out.println(getUserListCase.toString());
		System.out.println(TestConfig.getUserListUrl);

	}
}
