package com.javarush.test.level14.lesson08.home09;

public class Hrivna extends Money
{
    public Hrivna(){
        super(10_000);
    }
    @Override
    public String getCurrencyName()
    {
        return "HRN";
    }
}
