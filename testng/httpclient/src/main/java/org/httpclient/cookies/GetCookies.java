package org.httpclient.cookies;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetCookies {
	private String url;
	private ResourceBundle bundle;
	
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
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(get);
		result = EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(result);
	}
	
}
