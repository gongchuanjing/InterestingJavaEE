package tk.chuanjing.chapter22.annotation;


/**
 * @author ChuanJing
 * @date 2017年5月5日 上午11:35:04
 * @version 1.0
 */
public class TestAnno {

//	@Anno01(hobbies="抽烟")
	@Anno01(hobbies={"抽烟", "喝酒"})
	
	@Anno02(age=20, anno01 = @Anno01(hobbies={"抽烟", "喝酒"}), password = "12345", clazz = String.class, color = Color.BLUE)

//	@Anno03(value = {"哈哈", "嘿嘿"})
//	@Anno03({"哈哈", "嘿嘿"})
//	@Anno03(value = "哈哈")
//	@Anno03("哈哈")
	@Anno03()
	public static void main(String[] args) {
		
	}
}
