package tk.chuanjing.chapter22.annotation;


/**
 * @author ChuanJing
 * @date 2017年5月5日 上午11:35:04
 * @version 1.0
 */
@Anno04("覆盖默认值")
public class TestAnno2 {

	public static void main(String[] args) {
		Class<TestAnno2> clazz = TestAnno2.class;
		
		boolean b = clazz.isAnnotationPresent(Anno04.class);
		if (b) {
			Anno04 anno04 = clazz.getAnnotation(Anno04.class);
			String value = anno04.value();
			System.out.println(value);
		} else {
			System.out.println("没有注解");
		}
	}
}
