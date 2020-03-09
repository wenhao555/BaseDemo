package com.example.basedemo.javaTest;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Mapp
{
    public static void main(String[] args)
    {

    }

    private void test()
    {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("as", new man());
        map.get("as");
    }
}
