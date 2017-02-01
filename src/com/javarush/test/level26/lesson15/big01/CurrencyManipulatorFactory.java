package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory{

    private static CurrencyManipulatorFactory ourInstance = new CurrencyManipulatorFactory();
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    public static CurrencyManipulatorFactory getInstance(){
        return ourInstance;
    }

    private CurrencyManipulatorFactory(){}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        for (Map.Entry<String, CurrencyManipulator> manipulator : map.entrySet()) {
            if (manipulator.getValue().getCurrencyCode().equals(currencyCode)) {
                return manipulator.getValue();
            }
        }
        CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
        map.put(currencyCode, manipulator);
        return manipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }
}
