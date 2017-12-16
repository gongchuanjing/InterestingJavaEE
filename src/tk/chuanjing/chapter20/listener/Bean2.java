package tk.chuanjing.chapter20.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * HttpSessionActivationListener:监听HttpSession中的JavaBean的钝化和活化的
 * 
 * @author ChuanJing
 */
public class Bean2 implements HttpSessionActivationListener,Serializable{

	public Bean2() {
		super();
	}

	public Bean2(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println(se.getSession().getId()+"Bean2被钝化了...");
	}

	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println(se.getSession().getId()+"Bean2被活化了...");
	}
}
