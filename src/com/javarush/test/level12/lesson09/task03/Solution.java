package com.javarush.test.level12.lesson09.task03;

/* Fly, Move, Eat для классов Dog, Car, Duck, Airplane
Есть public интерфейсы Fly(летать), Move(передвигаться), Eat(есть).
Добавь эти интерфейсы классам Dog(собака), Car(автомобиль), Duck(утка), Airplane(самолет).
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        public void fly();
    }

    public interface Move
    {
        public void move();
    }

    public interface Eat
    {
        public void eat();
    }

    public class Dog implements Move, Eat
    {
        @Override
        public void eat()
        {
            System.out.println("eat meet");
        }

        @Override
        public void move()
        {
            System.out.println("move on 4 legs");
        }
    }

    public class Duck implements Fly, Eat, Move
    {
        @Override
        public void eat()
        {
            System.out.println("eat zerno");
        }

        @Override
        public void fly()
        {
            System.out.println("it can fly");
        }

        @Override
        public void move()
        {
            System.out.println("move on 2 legs");
        }
    }

    public class Car implements Move
    {
        @Override
        public void move()
        {
            System.out.println("move by engine");
        }
    }

    public class Airplane implements Fly, Move
    {
        @Override
        public void fly()
        {
            System.out.println("fly by engine");
        }

        @Override
        public void move()
        {

        }
    }
}
