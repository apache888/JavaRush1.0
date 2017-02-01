package com.javarush.test.level04.lesson02.task04;

/* Реализовать метод setName
Реализовать метод setName, чтобы с его помощью можно было устанавливать
значение переменной private MyString fullName равное значению локальной переменной MyString fullName.
*/

public class Cat {
    private String fullName;

    public void setName(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;

        this.fullName=fullName;
    }
}
