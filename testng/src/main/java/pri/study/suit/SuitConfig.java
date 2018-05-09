package pri.study.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuitConfig {
	@BeforeTest
	public void test1() {
		System.out.println("运行@BeforeTest");
	}
	@AfterTest
	public void test2() {
		System.out.println("运行@AfterTest");
	}
	
	@BeforeSuite
	public void test3() {
		System.out.println("运行@BeforeSuite");
	}
	@AfterSuite
	public void test4() {
		System.out.println("运行@AfterSuite");
	}
}
