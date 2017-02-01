package com.javarush.test.level08.lesson06.task01;

import java.util.*;

/* Создать два списка LinkedList и ArrayList
Нужно создать два списка – LinkedList и ArrayList.
*/

public class Solution
{
    public static Object createArrayList()
    {
        ArrayList<Object> al = new ArrayList<Object>();
        return al;

    }

    public static Object createLinkedList()
    {
        LinkedList<Object> ll = new LinkedList<Object>();
        return ll;
    }

    public static void main(String[] args) {
        createArrayList();
        createLinkedList();
    }
}
