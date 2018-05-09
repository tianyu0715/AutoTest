package pri.study.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertLog {
	@Test
	public void test1() {
		Assert.assertEquals(1, 2);
	}
	@Test
	public void test2() {
		Assert.assertEquals(1, 1);
	}
	@Test
	public void test3() {
		Assert.assertEquals("test", "test");
	}
	@Test
	public void logDemo() {
		Reporter.log("report log output");
		throw new RuntimeException("运行时抛出异常");
	}
}
