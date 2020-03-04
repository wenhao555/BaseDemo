package com.example.routerlib;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface RouterAnnotation
{
    String value();

//    Class[] location();
//
//    /**
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
