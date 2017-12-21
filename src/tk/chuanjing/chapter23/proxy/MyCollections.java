package tk.chuanjing.chapter23.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author ChuanJing
 * @date 2017年5月6日 上午12:55:29
 * @version 1.0
 */
public class MyCollections {

	@SuppressWarnings("unchecked")
	public static List<String> unmodifiableList(final List<String> list) {
		//list 所有功能都有 (目标类)
		//proxyList 希望不能进行增删改，只能查询  (代理类)
		
		// 参数1：ClassLoader ，动态代理需要一个类加载器
		ClassLoader loader = MyCollections.class.getClassLoader();
		
		// 参数2：Class[] interfaces 需要与目标类接口保持一致
		Class<?>[] interfaces = list.getClass().getInterfaces();
		
		List<String> proxyList = (List<String>) Proxy.newProxyInstance(loader, interfaces, new InvocationHandler(){

			//代理类的每一个方法调用一次，处理类invoke方法都执行一次
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				//处理（增强）--不允许添加
				if ("add".equals(method.getName())) {
					throw new UnsupportedOperationException("不能操作！");
				}
				
				//处理类中直接执行目标类对应的方法
				return method.invoke(list, args);
			}
			
		});
		
		return proxyList;
	}

}
