package org.httpclient.cookies;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCookies {
	private String url;
	private ResourceBundle bundle;
	private CookieStore store;
	
	@BeforeTest
	public void beforetest() {
		bundle = ResourceBundle.getBundle("application",Locale.CHINA);
		url = bundle.getString("test.url");
	}
	
	@Test
	public void testGetCookies() throws IOException, IOException {
		String result;
		String uri = bundle.getString("getCookies.uri");
		String testurl = this.url + uri;
		
		HttpGet get = new HttpGet(testurl);
//		HttpClient client = HttpClientBuilder.create().build();
		DefaultHttpClient client = new DefaultHttpClient();  
		HttpResponse response = client.execute(get);
		result = EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(result);
		
//		获取cookies信息
		this.store = client.getCookieStore();
		List<Cookie> cookieList = store.getCookies();
//		增强遍历
		for (Cookie cookie:cookieList) {
			String key = cookie.getName();
			String value = cookie.getValue();
			System.out.println("key: " + key + "\tvalue: " + value);
		}
	}
	
	@Test (dependsOnMethods = {"testGetCookies"})
	public void testgetwithcookies() throws IOException, IOException {
		String uri = bundle.getString("test.get.with.cookies");
		String testurl = this.url + uri;
		HttpGet get = new HttpGet(testurl);
		DefaultHttpClient client = new DefaultHttpClient();
//		设置cookies信息
		client.setCookieStore(this.store);;
		HttpResponse response = client.execute(get);
		
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println("statuscode: " + statuscode);
		if (statuscode == 200) {
			String result = EntityUtils.toString(response.getEntity(),"utf-8");
			System.out.println(result);
		}
	}
	
}
