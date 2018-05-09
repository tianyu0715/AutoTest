package pri.study.paramterbydata;
/*
 * dataprovider参数化
 */

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ByData {
	@Test (dataProvider = "data1")
	public void test1(String name,int age) {
		System.out.println("name: " + name + "\tage: " + age);
	}
	@Test (dataProvider = "data2")
	public void test2(String name,int age) {
		System.out.println("test2>name: " + name + "\tage: " + age);
	}
	@Test (dataProvider = "data2")
	public void test3(String name,int age) {
		System.out.println("test3>name: " + name + "\tage: " + age);
	}
	
	
	@DataProvider (name = "data1")
	public Object[][] dataTranser1(){
		Object[][] ob1 = new Object[][]{
			{"张三",20},
			{"李四",21}
		};
		return ob1;
	}
	@DataProvider (name = "data2")
	public Object[][] dataTranser2(Method method){
		Object[][] result = null;
		if (method.getName().equals("test2")) {
			result = new Object[][] {
				{"小王",40},
				{"小李",41}
			};
		}else if (method.getName().equals("test3")) {
			result = new Object[][] {
				{"小王媳妇",36},
				{"小李媳妇",33}
			};
		}
		return result;
	
	
	}
	
}
