package com.example.routerlib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

//@RouterAnnotation(value = "sad")//, location = {MyClass.class}, as = RouterAnnotation.ASD.AAA)
public class MyClass
{
    @Deprecated//过时注解
    private void method()
    {

    }

    public MyClass()
    {
        this.method();
    }

    /**
     *
     */
//    @SuppressWarnings({"unchecked", "rawtypes"})//压制警告注解 1 不检查 2 压制泛型的警告
    private void listS()
    {
        List list = new ArrayList();
        list.add("asd");
    }

    private void testAnn()
    {

    }

    public static void main(String[] args)
    {

    }
}
