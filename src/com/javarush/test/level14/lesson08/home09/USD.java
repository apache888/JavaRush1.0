package com.javarush.test.level14.lesson08.home09;

public class USD extends Money
{
    public USD(){
    super(1000);
}
    @Override
    public String getCurrencyName()
    {
        return "USD";
    }
}
