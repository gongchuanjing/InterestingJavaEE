package tk.chuanjing.chapter20.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * HttpSessionBindingListener:监听HttpSession中的JavaBean的绑定和解除绑定的
 * 
 * @author ChuanJing
 */
public class Bean1 implements HttpSessionBindingListener{

	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("Bean1与Session绑定了...");
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Bean1与Session解除绑定了...");
	}

}
