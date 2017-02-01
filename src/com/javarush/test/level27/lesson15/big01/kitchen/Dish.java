package com.javarush.test.level27.lesson15.big01.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString(){
        Dish [] dishes = Dish.values();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dishes.length - 1; i++) {
            builder.append(dishes[i].toString());
            builder.append(", ");
        }
        builder.append(dishes[dishes.length - 1].toString());

        return builder.toString();
    }
}
