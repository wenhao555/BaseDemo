package com.example.routerlib;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建的注解是实现Annotation接口
 * 非标识注解，通过反射方式调用这个方法的时候才有意义
 * <p>
 * RetentionPolicy的策略
 */


@Target(ElementType.FIELD)//代表这个注解可以放在在哪里    有  构造器（Co） 包 方法 类(type) 属性 (Fled)等分别可以指定多个 用{ 1 , 2 }
@Retention(RetentionPolicy.SOURCE)//  cLASS 和 Source在运行时无效
public @interface RouterAnnotation //非标识性注解
{
    /**
     * 这里的值既不是属性也不是方法
     * 语法 数局类型+值得名+（）；
     *
     * @return
     */
    String value();

//    Class[] location();
//
//    /**
//     * 枚举中没有方法没有属性 只有项
//     */
//    enum ASD
//    {
//        ASD,
//
//        DD,
//
//        AAA
//    }
//
//    ASD as();
}
