package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    private static ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Red", 3, 0);
        Horse horse2 = new Horse("Black", 3, 0);
        Horse horse3 = new Horse("White", 3, 0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run(){
        try
        {
            for (int i = 1; i <= 100; i++)
            {
                move();
                print();
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public void move(){
        for(Horse pony: horses){
            pony.move();
        }
    }
    public void print(){
        for(Horse pony: horses){
            pony.print();
            System.out.println();
            System.out.println();
        }

    }
    public Horse getWinner(){
        Horse winner = horses.get(0);
        double maxDist = 0;
        for(Horse pony: horses){
            if (pony.getDistance() > maxDist){
                maxDist = pony.getDistance();
                winner = pony;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
