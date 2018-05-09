package pri.study.groupm;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupByMethod {
	@Test (groups = "server")
	public void test1() {
		System.out.println("server用例1");
	}
	@Test (groups = "server")
	public void test2() {
		System.out.println("server用例2");
	}
	
	@Test (groups = "client")
	public void test3() {
		System.out.println("client用例1");
	}
	@Test (groups = "client")
	public void test4() {
		System.out.println("client用例2");
	}
	
	@BeforeGroups ("server")
	public void groups1() {
		System.out.println("server组用例执行前");
	}
	@AfterGroups ("server")
	public void groups2() {
		System.out.println("server组用例执行后");
	}
	
	@BeforeGroups ("client")
	public void groups3() {
		System.out.println("client组用例执行前");
	}
	@AfterGroups ("client")
	public void groups() {
		System.out.println("client组用例执行后");
	}
}
