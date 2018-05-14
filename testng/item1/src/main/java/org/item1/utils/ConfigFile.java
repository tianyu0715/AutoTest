package org.item1.utils;
/*
 * 工具类使用静态方法，不用new对象
 */
import java.util.Locale;
import java.util.ResourceBundle;

import org.item1.model.InterFaceName;

public class ConfigFile {
	private static ResourceBundle bundle = ResourceBundle.getBundle("application",Locale.CHINA);
	public static String getUrl(InterFaceName name) {
		String address = bundle.getString("test.url");
		String uri = "";
		String testUrl;
		
		if (name ==InterFaceName.LOGIN) {
			uri = bundle.getString("login.uri");
		}
		if (name == InterFaceName.GETUSERLIST) {
			uri = bundle.getString("getUserList.uri");
		}
		if (name == InterFaceName.GETUSERINFO) {
			uri = bundle.getString("getUserInfo.uri");
		}
		if (name == InterFaceName.ADDUSERINFO) {
			uri = bundle.getString("addUser.uri");
		}
		if (name == InterFaceName.UPDATEUSERINFO) {
			uri = bundle.getString("updateUserInfo.uri");
		}
		
		testUrl = address + uri;
		return testUrl;
	}
}
