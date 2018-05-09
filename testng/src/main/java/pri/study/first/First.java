package pri.study.first;
/*
 * 初识testng注解
 */

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class First {
	@Test
	public void test1() {
		System.out.println("运行@Test一测试用例");
	}
	@Test
	public void test2() {
		System.out.println("运行@Test二测试用例");
	}
	
	@BeforeMethod
	public void test3() {
		System.out.println("运行@BeforeMethod");
	}
	@AfterMethod
	public void test4() {
		System.out.println("运行@AfterMethod");
	}
	
	@BeforeClass
	public void test5() {
		System.out.println("运行@BeforeClass");
	}
	@AfterClass
	public void test6() {
		System.out.println("运行@AfterClass");
	}
	
	@BeforeSuite
	public void test7() {
		System.out.println("运行@BeforeSuite");
	}
	@AfterSuite
	public void test8() {
		System.out.println("运行@AfterSuite");
	}
}
