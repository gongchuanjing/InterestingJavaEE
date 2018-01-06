package tk.chuanjing.chapter22.annotation;

import java.lang.reflect.Method;

/**
 * 核心运行类
 * 
 * 获得测试类的Class.
 * 获得Class中的所有的方法.
 * 遍历每个方法,查看每个方法上是否有MyTest注解.
 * 有MyTest注解,这个方法就执行.
 * 
 * @author ChuanJing
 * @date 2017年5月5日 下午12:52:36
 * @version 1.0
 */
public class MyTestAPP {

	public static void main(String[] args) throws Exception {
		// 模拟 右键运行
		// 当前指定类，所有的方法，是否有@MyTest注解，如果有将运行
		
		// 1.获得测试类的Class
		Class<MyTestDemo> clazz = MyTestDemo.class;
		
		// 2.获得Class中的所有的方法: 规定了测试的方法必须是public.
		Method[] methods = clazz.getMethods();
		
		// 3.遍历每个方法
		for (Method method : methods) {
			
			// 4 判断方法上是否有指定的注解
			if (method.isAnnotationPresent(MyTest.class)) {
				// 5 说明方法上有MyTest注解，运行
				method.invoke(clazz.newInstance());
			}
		}
	}
}