package tk.chuanjing.chapter20.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 第一类监听器：监听Request的创建和销毁的监听器
 * @author ChuanJing
 *
 */
public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest被销毁了...");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest被创建了...");
	}

}
