package tk.chuanjing.chapter22.annotation;

/**
 * @author ChuanJing
 * @date 2017年5月5日 下午12:50:24
 * @version 1.0
 */
public class MyTestDemo {

	@MyTest
	public void demo1() {
		System.out.println("demo1");
	}
	
	@MyTest
	public void demo2() {
		System.out.println("demo2");
	}
	
	public void demo3() {
		System.out.println("demo3");
	}
}
