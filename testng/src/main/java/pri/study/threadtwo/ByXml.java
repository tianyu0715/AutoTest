package pri.study.threadtwo;

import org.testng.annotations.Test;

/*
 * 多线程测试，xml文件实现
 */
public class ByXml {
	@Test 
	public void test1() {
		System.out.printf("Thread Id:%s%n",Thread.currentThread().getId());
	}
	
	@Test 
	public void test2() {
		System.out.printf("Thread Id:%s%n",Thread.currentThread().getId());
	}
	
	@Test 
	public void test3() {
		System.out.printf("Thread Id:%s%n",Thread.currentThread().getId());
	}
}
