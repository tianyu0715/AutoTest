package org.httpclient.post;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PostTest {
	private String url;
	private ResourceBundle bundle;
	private CookieStore store;

	@BeforeTest
	public void beforetest() {
		bundle = ResourceBundle.getBundle("application", Locale.CHINA);
		url = bundle.getString("test.url");
	}

	@Test
	public void testGetCookies() throws IOException, IOException {
		String result;
		String uri = bundle.getString("getCookies.uri");
		String testurl = this.url + uri;

		HttpGet get = new HttpGet(testurl);
		// HttpClient client = HttpClientBuilder.create().build();
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(get);
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(result);

		// 获取cookies信息
		this.store = client.getCookieStore();
		List<Cookie> cookieList = store.getCookies();
		// 增强遍历
		for (Cookie cookie : cookieList) {
			String key = cookie.getName();
			String value = cookie.getValue();
			System.out.println("key: " + key + "\tvalue: " + value);
			System.out.println("---------------------------------------");
		}
	}

	@Test(dependsOnMethods = { "testGetCookies" })
	public void testPostMethod() throws IOException {
		String uri = bundle.getString("test.post.with.cookies");
		String testurl = this.url + uri;
		System.out.println("打印：" + testurl);

		// 声明一个client对象,用来进行方法执行
		DefaultHttpClient client = new DefaultHttpClient();
		// 声明一个post方法
		HttpPost post = new HttpPost(testurl);
		// 设置请求头部信息
		post.setHeader("content-type", "application/json");
		// 添加参数
		JSONObject param = new JSONObject();
		param.put("name", "huhansan");
		param.put("age", "18");

		// 将参数添加到方法中
		StringEntity entity = new StringEntity(param.toString(), "utf-8");
		post.setEntity(entity);
		
		// 声明一个对象来进行响应结果的存储
		String result;
		// 设置cookies信息
		client.setCookieStore(this.store);
		// 执行post方法
		HttpResponse response = client.execute(post);
		
		// 获取响应结果
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println("打印响应结果: " + result);
		// 将返回结果的字符串转换成json对象
		JSONObject resultJson = new JSONObject(result);
		System.out.println("打印转成json对象的结果: " + resultJson);
		
		// 根据响应字段获取到结果值
		String key1 = (String) resultJson.get("comment");
		String key2 = (String) resultJson.get("status");

		// 判断结果值，是否符合预期结果
		Assert.assertEquals("success", key1);
		Assert.assertEquals("000000", key2);
	}
}
