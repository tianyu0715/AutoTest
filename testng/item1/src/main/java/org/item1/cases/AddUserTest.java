package org.item1.cases;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.item1.config.TestConfig;
import org.item1.model.AddUserCase;
import org.item1.utils.DatabaseUtil;
import org.testng.annotations.Test;

public class AddUserTest {
	@Test(dependsOnGroups = "loginTrue",description = "添加用户接口测试")
	public void addUser() throws IOException {
		SqlSession session = DatabaseUtil.getSqlSession();
		AddUserCase addUserCase = session.selectOne("addUserCase", 1);
		System.out.println(addUserCase.toString());
		System.out.println(TestConfig.addUserUrl);
	}
	
}
