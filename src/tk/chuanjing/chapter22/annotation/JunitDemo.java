package tk.chuanjing.chapter22.annotation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ChuanJing
 * @date 2017年5月1日 下午9:08:48
 * @version 1.0
 */
public class JunitDemo {

	@Test
	public void demo01() {
		System.out.println("demo01");
	}
	
	@Test
	public void demo02() {
		System.out.println("demo02");
	}
	
	@Before
	public void demo03() {
		System.out.println("demo03");
	}
	
	@After
	public void demo04() {
		System.out.println("demo04");
	}
}