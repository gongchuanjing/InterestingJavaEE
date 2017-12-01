package tk.chuanjing.chapter17.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

public class MyBeanUtils {

	public static void populate(Object obj, Map<String, String[]> map) throws Exception {
		// 获得类的所有的属性的名称
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		
		// 获得类中所有的属性
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
	
		for (PropertyDescriptor pd : pds) {
			if (map.containsKey(pd.getName())) {
				Method method = pd.getWriteMethod();
				
				// 执行set方法
				method.invoke(obj, map.get(pd.getName())[0]);
			}
		}
	}
}
