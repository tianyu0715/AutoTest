package pri.study.exception;
/*
 * 异常测试
 */

import org.testng.annotations.Test;

public class Exception {
	@Test (expectedExceptions = RuntimeException.class )
	public void RuntimeExceptionFailed() {
		System.out.println("这是一个失败的异常测试");;
	}
	@Test (expectedExceptions = RuntimeException.class )
	public void RuntimeExceptionSuccess() {
		System.out.println("这是一个成功的异常测试");
		throw new RuntimeException("");
	}
}
