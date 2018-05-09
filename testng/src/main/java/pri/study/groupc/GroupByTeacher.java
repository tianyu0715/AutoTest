package pri.study.groupc;

import org.testng.annotations.Test;

@Test (groups = "teacher")
public class GroupByTeacher {
	public void test() {
		System.out.println("老师类1");
	}
}
