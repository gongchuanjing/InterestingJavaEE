package tk.chuanjing.chapter23;

import sun.net.spi.nameservice.dns.DNSNameService;

public class ClassLoaderDemo1 {

	public static void main(String[] args) {
		demo1();
		demo2();
		demo3();
	}
	
	/**
	 * 应用类加载器:
	 */
	public static void demo1(){
		ClassLoader loader = ClassLoaderDemo1.class.getClassLoader();
		System.out.println(loader);
	}
	
	/**
	 * 扩展类加载器:
	 */
	public static void demo2(){
		ClassLoader loader = DNSNameService.class.getClassLoader();
		System.out.println(loader);
	}
	
	/**
	 * 引导类加载器:
	 */
	public static void demo3(){
		ClassLoader loader = String.class.getClassLoader();
		System.out.println(loader);// 不让挖祖坟，所以打印不出来
	}
}
