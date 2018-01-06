package tk.chuanjing.chapter22.annotation;

@Anno1
@Anno2(a=1,s="aa",c=AnnotationDemo.class,anno1=@Anno1,color=Color.RED,arrs={"dsds","kkk"})
@Anno3("ggg")
public class AnnotationDemo {

}

/**
 * 定义一个注解:名称是Anno1
 */
@interface Anno1 {
	
}

@interface Anno2 {
	int a();
	boolean b() default false;
	String s();
//	Date d();
	Class c();
	Anno1 anno1();
	Color color();
	String[] arrs();
}

enum Color {
	RED,BLUE,BLACK,YELLOW;
}

@interface Anno3 {
	String value();
	int a() default 1;
}