package pri.study.timeout;
/*
 * 超时测试
 */

import org.testng.annotations.Test;

public class Timeout {
	@Test (timeOut = 3000)
	public void testSuccess() throws InterruptedException {
		Thread.sleep(2000);
	}
	@Test (timeOut = 2000)
	public void testFailed() throws InterruptedException {
		Thread.sleep(3000);
	}
}
