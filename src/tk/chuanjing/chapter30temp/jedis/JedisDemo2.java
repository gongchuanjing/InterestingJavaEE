package tk.chuanjing.chapter30temp.jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class JedisDemo2 {
	
	private Jedis jedis;
	
	private void before() {
		jedis = new Jedis("192.168.183.128");
		
		// 设置密码
		jedis.auth("12345");
	}
	
	public static void main(String[] args) {
		JedisDemo2 jd = new JedisDemo2();
		jd.before();
		// ------------------------string操作
//		jd.test1();
//		jd.test2();
//		jd.test3();
		
		//-------------------------list操作
//		jd.test4();
//		jd.test5();
//		jd.test6();
//		jd.test7();
		
		//-------------------------hash操作
//		jd.test8();
//		jd.test9();
//		jd.test10();
//		jd.test11();
		
		//-------------------------set操作
//		jd.test12();
//		jd.test13();
//		jd.test14();
//		jd.test15();
//		jd.test16();
		
		//-------------------------sortedset操作
//		jd.test17();
//		jd.test18();
//		jd.test19();
//		jd.test20();
//		jd.test21();
		
		//-------------------------key的通用操作
		jd.test22();
//		jd.test23();
//		jd.test24();
	}

	// -----------------------------------------------string操作
	
	/** 演示  append  setrange  getrange */
	private void test3() {
//		jedis.append("username", " is boy");
		
//		jedis.setrange("username", 7, "girl");
		
		System.out.println(jedis.get("username"));
		
		System.out.println(jedis.getrange("username", 7, -1));
	}

	/** 演示mset  mget */
	private void test2() {
		jedis.mset("password","123","age","20");
		List<String> list = jedis.mget("password", "age");
		System.out.println(list);
	}

	/** 演示 set get */
	public void test1() {
		jedis.set("username", "tom");
		String value = jedis.get("username");
		System.out.println(value);
	}

	// -----------------------------------------------list操作
	/** 演示lpush lrange */
	public void test4() {
		jedis.lpush("names", "tom","张三");
		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
	}
	
	/** 演示lset */
	public void test5() {
		jedis.lset("names", 1, "jack");
		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
	}
	
	/** 演示linsert */
	public void test6() {
		jedis.linsert("names", LIST_POSITION.BEFORE, "张三", "王五");
		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
	}
	
	/** 演示lrem */
	public void test7() {
		jedis.lrem("names", 1, "王五");
		List<String> names = jedis.lrange("names", 0, -1);
		System.out.println(names);
	}
	
	// --------------------------------------hash操作
	/** 演示hset hget */
	public void test8() {
		jedis.hset("user", "username", "tom");
		String value = jedis.hget("user", "username");
		System.out.println(value);
	}
	
	/** 演示hmset hmget */
	public void test9() {
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("password", "123");
		hash.put("sex", "male");
		jedis.hmset("user", hash);
		
		List<String> list = jedis.hmget("user", "username","password","sex");
		System.out.println(list);
	}
	
	/** 演示  hgetall hkeys  kvals */
	public void test10() {
		Map<String, String> map = jedis.hgetAll("user");
		for (String key : map.keySet()) {
			System.out.println(key +"   "+map.get(key));
		}
		
		Set<String> hkeys = jedis.hkeys("user");
		System.out.println(hkeys);
		
		List<String> hvals = jedis.hvals("user");
		System.out.println(hvals);
	}
	
	/** 演示hdel */
	public void test11() {
		jedis.hdel("user", "username", "password");
		
		Map<String, String> map = jedis.hgetAll("user");
		for (String key : map.keySet()) {
			System.out.println(key +"   "+map.get(key));
		}
	}
	
	// --------------------------------------set操作
	/** 演示sadd smembers */
	public void test12() {
		jedis.sadd("language1", "java","c++","ruby","python");
		
		Set<String> smembers = jedis.smembers("language1");
		System.out.println(smembers);
	}
	
	/** 演示srem */
	public void test13() {
		jedis.srem("language1", "java");
		
		Set<String> smembers = jedis.smembers("language1");
		System.out.println(smembers);
	}
	
	/** 差集 sdiff */
	public void test14() {
		jedis.sadd("language1","java","c++","ruby","python");
		jedis.sadd("language2","ios","c++","c#","android");
		
		Set<String> sdiff = jedis.sdiff("language1","language2");
		System.out.println(sdiff);
	}
	
	/** 交集 */
	public void test15() {
		jedis.sadd("language1","java","c++","ruby","python");
		jedis.sadd("language2","ios","c++","c#","android");
		
		Set<String> sinter = jedis.sinter("language1","language2");
		System.out.println(sinter);
	}
	
	/** 并集 */
	public void test16() {
		jedis.sadd("language1","java","c++","ruby","python");
		jedis.sadd("language2","ios","c++","c#","android");
		
		Set<String> sunion = jedis.sunion("language1","language2");
		System.out.println(sunion);
	}
	
	// --------------------------------------sortedset操作
	/** 演示zadd zrange zrangeByScore */
	public void test17() {
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);
		
		Set<String> set = jedis.zrange("zkey", 0, -1);
		System.out.println(set);
		
		// 根据分数获取
		Set<String> set1 = jedis.zrangeByScore("zkey", 70.0, 90.0);
		System.out.println(set1);
	}
	
	/** 获取分数元素 zrangeWithScores */
	public void test18() {
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);
		
		Set<Tuple> zws = jedis.zrangeWithScores("zkey", 0, -1);
		for (Tuple t : zws) {
			System.out.println(t.getScore() +"   "+t.getElement());
		}
	}
	
	/** zrank */
	public void test19() {
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);
		
		Long zrank = jedis.zrank("zkey", "赵六");
		System.out.println(zrank);
	}
	
	/** zscore */
	public void test20() {
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);
		
		Double zrank = jedis.zscore("zkey", "张三");
		System.out.println(zrank);
	}
	
	/** zrem */
	public void test21() {
		Map<String, Double> sm = new HashMap<String, Double>();
		sm.put("张三", 70.0);
		sm.put("李四", 80.0);
		sm.put("王五", 90.0);
		sm.put("赵六", 60.0);
		jedis.zadd("zkey", sm);
		
		jedis.zrem("zkey", "李四");
		
		Set<Tuple> zws = jedis.zrangeWithScores("zkey", 0, -1);
		for (Tuple t : zws) {
			System.out.println(t.getScore() +"   "+t.getElement());
		}
	}
	
	// --------------------------------------key的通用操作
	/** keys patten */
	public void test22() {
		Set<String> keys = jedis.keys("*");
		System.out.println(keys);
	}
	
	/** del key */
	public void test23() {
		Long del = jedis.del("user");
		System.out.println(del);
	}
	
	/** 关于key时间设置 */
	public void test24() {
		//设置生命周期为200秒
//		jedis.expire("username", 200);
		
		jedis.persist("username");
		
		Long ttl = jedis.ttl("username");//获取生命周期值
		System.out.println(ttl);
	}
}
