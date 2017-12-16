package tk.chuanjing.chapter20.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 第一类监听器：监听HttpSession的创建和销毁的监听器
 * @author ChuanJing
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("HttpSession被创建了...");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("HttpSession被销毁了...");
	}

}
