package com.javarush.test.level04.lesson02.task01;

/* Реализовать метод setName
Реализовать метод setName, чтобы с его помощью можно было устанавливать значение переменной private MyString name равное переданному параметру MyString name.
*/

public class Cat {
    private String name;

    public void setName(String name) {
        this.name=name;
    }
}
