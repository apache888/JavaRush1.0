package com.javarush.test.level15.lesson12.home04;

public class Kid
{
    private static Kid ourInstance = new Kid();

    public static Kid getInstance()
    {
        return ourInstance;
    }

    private Kid()
    {
    }
}
