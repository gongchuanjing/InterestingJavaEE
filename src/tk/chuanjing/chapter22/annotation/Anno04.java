package tk.chuanjing.chapter22.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ChuanJing
 * @date 2017年5月5日 上午11:29:25
 * @version 1.0
 */

/* 元注解：jdk提供一套注解，元注解用于修饰自定义注解。
 * 	用于控制自定义注解 使用位置、生命周期等基本信息。
 * 
 * @Target 用于限定自定义注解使用位置
 * 		@Target(ElementType.CONSTRUCTOR) 只能在构造方法使用
 * 		@Target(ElementType.METHOD) 只能在普通方法使用
 * 		@Target(ElementType.FIELD) 只能在字段使用
 * 		@Target(ElementType.TYPE) 只能在类、接口使用
 * @Retention 用于确定自定义注解生命周期
 * 		@Retention(RetentionPolicy.SOURCE)	自定义注解只在源码有效，编译之后将删除(class文件没有)。提供编译器使用
 * 		@Retention(RetentionPolicy.CLASS)	自定义注解只在源码和字节码有效，编译之后有，运行时内存没有。提供JVM使用
 * 		@Retention(RetentionPolicy.RUNTIME)	自定义注解在源码、字节码和内存都有效。【】提供程序使用，用于取代xml配置文件
 * 
 */
@Target(value = {ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Anno04 {
	String value() default "有默认值";
}
