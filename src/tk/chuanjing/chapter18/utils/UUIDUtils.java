package tk.chuanjing.chapter18.utils;

import java.util.UUID;

/**
 * 生成随机的字符串的工具类
 * @author ChuanJing
 *
 */
public class UUIDUtils {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
//		String str = "12345";
//		changeStr(str);
//		System.out.println(str);
	}

//	private static void changeStr(String str) {
//		str = "welcome";
//	}
}
