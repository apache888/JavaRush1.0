package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.Observer;

public class Restaurant {

    public static void main(String[] args) {

        Tablet tablet = new Tablet(5);
        Cook firstCook = new Cook("Amigo");
        Observer firstWaitor = new Waitor();
        tablet.addObserver(firstCook);
        firstCook.addObserver(firstWaitor);
        tablet.createOrder();


    }
}
