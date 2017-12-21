package tk.chuanjing.chapter23.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用动态代理:Proxy.newProxyInstance();
 * ClassLoader :类加载器.
 * Class[]     :被增强的对象实现的所有接口
 * InvocationHandler	:处理类.
 * 
 * @author ChuanJing
 *
 */
public class WaitressProxy {

	public static void main(String[] args) {
		Waiter waiter = new Waitress();
//		waiter.server();
//		String sayHello = waiter.sayHello("张三");
//		System.out.println(sayHello);
		
		// 第一个参数
		ClassLoader loader = waiter.getClass().getClassLoader();
		// 第二个参数
		Class<?>[] interfaces = waiter.getClass().getInterfaces();
		
		Waiter waiterProxy = (Waiter) Proxy.newProxyInstance(loader, interfaces, new MyInvocationHandler(waiter));
		waiterProxy.server();
		String sayHelloProxy = waiterProxy.sayHello("张三");
		System.out.println(sayHelloProxy);
	}
}

//第三个参数
class MyInvocationHandler implements InvocationHandler {

	private final Waiter waiter;

	public MyInvocationHandler(Waiter waiter) {
		this.waiter = waiter;
	}

	/**
	 * 方法的参数:
	 * * proxy	:产生的代理对象.
	 * * method	:当前正在调用的目标类的方法.
	 * * args	:正在执行的方法中的参数.
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if ("server".equals(method.getName())) {
			System.out.println("微笑");
		}
		return method.invoke(waiter, args);
	}
	
}