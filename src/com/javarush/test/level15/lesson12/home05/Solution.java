package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution2 создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution2.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они
 соответствовали конструкторам класса Solution2.
*/

public class Solution {
    int a;
    double b;
    String s;


    Solution(int a){
        this.a = a;
    }
    Solution(int a, double b){}
    Solution(int a, double b, String s){}

    protected Solution(double b, int a){

    }
    protected Solution(double b, String s){}
    protected Solution(double b, String s, int a){}

    public Solution(){

    }
    public Solution(String s, double b, int a){}
    public Solution(String s, int a){

    }

    private Solution(int a, int i){}
    private Solution(double b){}
    private Solution(double b, String s, String m){}
}

