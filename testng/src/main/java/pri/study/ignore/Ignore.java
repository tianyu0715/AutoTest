package pri.study.ignore;
/*
 * 忽略测试
 */

import org.testng.annotations.Test;

public class Ignore {
	@Test
	public void test1() {
		System.out.println("常规案例");
	}
	@Test (enabled = true)
	public void test2() {
		System.out.println("enabled = true 用例");
	}
//	该方法就被忽略执行了
	@Test (enabled = false)
	public void test3() {
		System.out.println("enabled = false 用例");
	}
}
