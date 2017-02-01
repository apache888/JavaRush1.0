package com.javarush.test.level05.lesson05.task01;

/* Создать класс Cat
Создать класс Cat. У кота должно быть имя (name, MyString), возраст (age, int), вес (weight, int), сила (strength, int).
*/

public class Cat
{
    String name;
    int age;
    int weight;
    int strength;

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.name = "Tom";
        cat.age = 2;
        cat.weight = 4;
        cat.strength = 10;
    }


}
