package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;

/* 20 слов на букву «Л»
Создать множество строк (Set<MyString>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<String>();

        set.add("Ложь");
        set.add("Ложка");
        set.add("Лес");
        set.add("Лох");
        set.add("Лупа");
        set.add("Лук");
        set.add("Лужайка");
        set.add("Лень");
        set.add("Линька");
        set.add("Любовь");
        set.add("Лосось");
        set.add("Лунка");
        set.add("Левый");
        set.add("Луна");
        set.add("Лубянка");
        set.add("Лев");
        set.add("Лирика");
        set.add("Лист");
        set.add("Ламель");
        set.add("Лак");

        return set;
    }
}
