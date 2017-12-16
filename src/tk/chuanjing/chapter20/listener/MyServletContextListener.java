package tk.chuanjing.chapter20.listener;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 第一类监听器：监听ServletContext对象的创建和销毁的监听器
 * @author ChuanJing
 *
 */
public class MyServletContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("ServletContext对象被创建了...");
		
		Timer t = new Timer();
		
		/*
		Calendar c = Calendar.getInstance();
		c.set(2017, 5, 13, 23, 42);
		Date firstTime = c.getTime();
		t.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("贵州茅台为您报时："+new Date().toLocaleString());
			}
			
		}, firstTime, 1000 * 10);
		*/
		
		t.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("贵州茅台为您报时："+new Date().toLocaleString());
			}
			
		}, 1000 * 20, 1000 * 10);//  1000 * 20之后开始执行任务，每间隔1000 * 10再执行一遍
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext对象被销毁了...");
	}

}
