package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
 Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        private String name;
        private int age;
        private boolean sex;
        private int height;
        private int weight;
        private boolean merriage;

        public Human(String name){
            this.name = name;
        }
        public Human(String name, int age){
            this.name = name;
            this.age =age;
        }
        public Human(String name, int age, boolean sex){
            this.name = name;
            this.age =age;
            this.sex = sex;
        }
        public Human(String name, int age, boolean sex, boolean merriage){
            this.name = name;
            this.age =age;
            this.sex = sex;
            this.merriage = merriage;
        }
        //5
        public Human(String name, int age, int height, int weight){
            this.name = name;
            this.age =age;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, boolean sex, int height, int weight){
            this.name = name;
            this.sex =sex;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, boolean sex, boolean merriage){
            this.name = name;
            this.sex = sex;
            this.merriage = merriage;
        }
        public Human(String name, int height, int weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
       //9
        public Human(String name, int age, boolean merriage, int height){
            this.name = name;
            this.age = age;
            this.merriage = merriage;
            this.height = height;
        }
        public Human(String name, int age, boolean sex, int height, int weight, boolean merriage){
            this.name = name;
            this.age =age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.merriage = merriage;
        }
    }
}
