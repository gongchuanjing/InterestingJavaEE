package tk.chuanjing.chapter17.introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import tk.chuanjing.chapter12.login.User;

public class IntrospectorDemo {

	/**
	 * @param args
	 * @throws IntrospectionException 
	 */
	public static void main(String[] args) throws IntrospectionException {
		demo();
	}

	/**
	 * 获得某个类中的属性:
	 * * 一个JavaBean属性由get或set方法确定的
	 * @throws IntrospectionException 
	 */
	private static void demo() throws IntrospectionException {
		// 获得了Bean的信息
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
		
		// 获得Bean的属性描述了
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
	
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
//			pd.getReadMethod(); // 获得get方法
//			pd.getWriteMethod();// 获得set方法.
			Method readMethod = pd.getReadMethod();
			System.out.println(readMethod);
			Method writeMethod = pd.getWriteMethod();// 获得set方法.
		}
	}

}
