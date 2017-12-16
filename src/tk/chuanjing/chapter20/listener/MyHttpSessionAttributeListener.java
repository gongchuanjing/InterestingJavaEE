package tk.chuanjing.chapter20.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 第二类监听器
 * 
 * @author ChuanJing
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("Session中添加属性了...");
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("从Session中移除属性了...");
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("替换了Session中的属性...");
	}

}
