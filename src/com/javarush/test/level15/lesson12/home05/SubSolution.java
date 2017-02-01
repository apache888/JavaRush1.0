package com.javarush.test.level15.lesson12.home05;

public class SubSolution extends Solution
{
     SubSolution(int a)
    {
        super(a);
    }

     SubSolution(int a, double b)
    {
        super(a, b);
    }

     SubSolution(int a, double b, String s)
    {
        super(a, b, s);
    }


    protected SubSolution(double b, int a)
    {
        super(b, a);
    }

    protected SubSolution(double b, String s)
    {
        super(b, s);
    }

    protected SubSolution(double b, String s, int a)
    {
        super(b, s, a);
    }


    public SubSolution()
    {
        super();
    }

    public SubSolution(String s, double b, int a)
    {
        super(s, b, a);
    }

    public SubSolution(String s, int a)
    {
        super(s, a);
    }

    private SubSolution(int a, int i){}
    private SubSolution(double b){}
    private SubSolution(double b, String s, String m){}
}
