package tk.chuanjing.chapter30temp.jedis;

import redis.clients.jedis.Jedis;

/**
 * 快速入门
 * @author ChuanJing
 *
 */
public class JedisDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.183.128");
		
		//设置密码
		jedis.auth("12345");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
	}

}
