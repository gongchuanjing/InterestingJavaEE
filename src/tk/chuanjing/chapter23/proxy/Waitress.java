package tk.chuanjing.chapter23.proxy;
/**
 * 服务器的实现类
 * @author admin
 *
 */
public class Waitress implements Waiter {

	public void server() {
		System.out.println("服务中...");
	}

	public String sayHello(String name) {
		return "Hello "+name;
	}

}