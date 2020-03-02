package com.example.basedemo.javaTest;

public class man extends mHuman
{
    /**
     * volatile关键字
     */
    private static volatile man instance;

    public man()
    {

    }

    public static man getInstance()
    {
        if (instance == null)
        {
            synchronized (man.class)
            {
                if (instance == null)
                {
                    instance = new man();
                }
            }
        }
        return instance;
    }

    @Override
    public void eat()
    {

    }


}
