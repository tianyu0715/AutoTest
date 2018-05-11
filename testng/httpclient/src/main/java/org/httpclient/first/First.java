package org.httpclient.first;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class First {
	@Test
	public void test1() throws ParseException, IOException {
//		存放结果
		String result;
		HttpGet get = new HttpGet("https://www.baidu.com/");
//		执行get方法
		HttpClient client = new DefaultHttpClient();
//		HttpClient client = HttpClientBuilder.create().build();
		
		HttpResponse response = client.execute(get);
		
		result = EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(result);
		
	}
}
