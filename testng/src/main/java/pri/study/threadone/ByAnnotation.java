package pri.study.threadone;
/*
 * 多线程方式，注解方式实现
 */

import org.testng.annotations.Test;

public class ByAnnotation {
	@Test (invocationCount = 10,threadPoolSize = 3)
	public void test() {
		System.out.println("线程测试");
		System.out.printf("Thread Id:%s%n",Thread.currentThread().getId());
	}
}
