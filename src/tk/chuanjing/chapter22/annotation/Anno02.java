package tk.chuanjing.chapter22.annotation;
/**
 * @author ChuanJing
 * @date 2017年5月5日 上午11:29:58
 * @version 1.0
 */
public @interface Anno02 {

	/* 格式：修饰符  返回值类型  属性名() default 默认值
	 * 	* 修饰符：public abstract
	 * 	* 返回值类型：基本类型、String、Class、注解、枚举，以及以上类型的一位数组
	 *  * 属性名：自定义
	 *  * 默认值：可以省略
	 */
	
	public abstract String name() default "jack";
	
	public int age();
	
	public Class clazz();
	
	Anno01 anno01();
	
	Color color() default Color.RED;
	
	String password();
}

//枚举：相当于多例。Color.RED
enum Color1{
	RED, BLUE;
}

//自定义多例 
class Color2{
	private Color2(){
		
	}
	public static final Color2 RED = new Color2();
	public static final Color2 BLUE = new Color2();
}