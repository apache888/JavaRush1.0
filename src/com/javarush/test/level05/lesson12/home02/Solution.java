package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution2 создай public static классы Man и Woman.
2. У классов должны быть поля: name(MyString), age(int), address(MyString).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Tom", 22, "New York");
        Man man2 = new Man("Bill", 28, "Boston");

        Woman girl1 = new Woman("Anna", 18, "London");
        Woman girl2 = new Woman("Olga", 23, "Kiev");


        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(man2.name + " " + man2.age + " " + man2.address);
        System.out.println(girl1.name + " " + girl1.age + " " + girl1.address);
        System.out.println(girl2.name + " " + girl2.age + " " + girl2.address);
    }

    public static class Man{
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman{
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
