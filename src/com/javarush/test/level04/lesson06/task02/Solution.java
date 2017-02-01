package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader= new BufferedReader((new InputStreamReader(System.in)));

        String sa = reader.readLine();
        int a = Integer.parseInt(sa);

        String sb = reader.readLine();
        int b = Integer.parseInt(sb);

        String sc = reader.readLine();
        int c = Integer.parseInt(sc);

        String sd = reader.readLine();
        int d = Integer.parseInt(sd);

        if (a > b && a > c  && a>d) {
            System.out.println(a);
        }else if(b>c && b>d){
            System.out.println(b);
        }else if (c>d){
            System.out.println(c);
        }else
            System.out.println(d);

    }
}
