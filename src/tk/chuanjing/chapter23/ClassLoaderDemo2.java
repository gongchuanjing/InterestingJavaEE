package tk.chuanjing.chapter23;

import org.junit.Test;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @author ChuanJing
 * @date 2017年5月5日 下午3:54:00
 * @version 1.0

	获得所有属性配置
	Properties properties = System.getProperties();
	for (String string : properties.stringPropertyNames()) {
		System.out.println(string);
	}
	
	引导：sun.boot.class.path
	扩展：java.ext.dirs
	应用：java.class.path
 */
public class ClassLoaderDemo2 {
	
	@Test
	public void demo01() {
		// 确定引导类加载器，加载内容：rt.jar  （Runtime ）
		// * JDK固定配置信息，sun.boot.class.path 用于表示 引导类加载器所加载的内容
//		Properties properties = System.getProperties();
//		String string = properties.getProperty("sun.boot.class.path");
		String string = System.getProperty("sun.boot.class.path");
		
		String[] split = string.split(";");
		for (String str : split) {
			System.out.println(str);
		}
	}
	
	@Test
	public void demo02() {
		// 确定引导类加载器，类型：null
		Class<String> clazz = String.class;
		ClassLoader classLoader = clazz.getClassLoader();
		System.out.println(classLoader);
	}
	
	
	
	@Test
	public void demo03() {
		// 确定扩展类加载器，加载内容： jre/lib/ext
		// * JDK固定配置信息，java.ext.dirs 用于表示 扩展类加载器所加载的内容
		String string = System.getProperty("java.ext.dirs");
		
		String[] split = string.split(";");
		for (String str : split) {
			System.out.println(str);
		}
	}
	
	@Test
	public void demo04() {
		// 确定扩展类加载器，类型：Launcher$ExtClassLoader
		ClassLoader classLoader = DNSNameService.class.getClassLoader();
		System.out.println(classLoader);
	}
	
	@Test
	public void demo05() {
		// 确定应用类加载器，加载内容： 项目/bin (编译后内容) ，自己编写类由应用类加载加载
		// * JDK固定配置信息，java.class.path 用于表示应用类加载器所加载的内容
		String string = System.getProperty("java.class.path");
		
		String[] split = string.split(";");
		for (String str : split) {
			System.out.println(str);
		}
	}
	
	@Test
	public void demo06() {
		// 确定应用类加载器，类型：Launcher$AppClassLoader
		ClassLoader classLoader = ClassLoaderDemo2.class.getClassLoader();
		System.out.println(classLoader);
	}
	
	@Test
	public void demo07() {
		//3个类加载的关系
		
		//应用 (AppClassLoader)
		ClassLoader classLoader = ClassLoaderDemo2.class.getClassLoader();
		System.out.println(classLoader);
		
		//扩展(ExtClassLoader)
		ClassLoader classLoaderParent = classLoader.getParent();
		System.out.println(classLoaderParent);
		
		//引导(null)
		ClassLoader classLoaderParentParent = classLoaderParent.getParent();
		System.out.println(classLoaderParentParent);
	}
}
