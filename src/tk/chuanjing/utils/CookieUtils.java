package tk.chuanjing.utils;

import javax.servlet.http.Cookie;

/**
 * Cookie的工具类
 * @author ChuanJing
 *
 */
public class CookieUtils {

	public static Cookie findCookie(Cookie[] Cookies, String cookieName) {
		if (Cookies == null || Cookies.length == 0) {
			return null;
			
		} else {
			
			for (Cookie cookie : Cookies) {
				if (cookieName.equals(cookie.getName())) {
					return cookie;
				}
			}
			
			return null;
		}
	}
}
