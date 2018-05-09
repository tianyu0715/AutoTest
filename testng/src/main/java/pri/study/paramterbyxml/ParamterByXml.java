package pri.study.paramterbyxml;
/*
 * xml文件参数化
 */

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ParamterByXml {
	@Test
	@Parameters ({"name","age"})
	public void test(String name,int age) {
		System.out.println("name: " + name + "\tage: " + age);
	}
	
}
