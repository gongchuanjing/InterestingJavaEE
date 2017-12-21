package tk.chuanjing.chapter23.proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author ChuanJing
 * @date 2017年5月6日 上午12:48:51
 * @version 1.0
 */
public class MyCollectionsTest {

	@Test
	public void demo01() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		System.out.println(list);
		
		List<String> list2 = Collections.unmodifiableList(list);
		System.out.println(list2);
		list2.add("bb");
		System.out.println(list2);
		
		//不支持操作异常，当前list2不允许修改。
		//java.lang.UnsupportedOperationException
	}
	
	@Test
	public void demo02() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		System.out.println(list);
		
		List<String> list2 = MyCollections.unmodifiableList(list);
		System.out.println(list2);
		list2.add("bb");			//不允许
		System.out.println(list2);
	}
}
