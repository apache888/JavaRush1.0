package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader= new BufferedReader((new InputStreamReader(System.in)));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        int [] m={a,b,c};
        for(int i = 0; i < m.length-1; i++) {
            for(int j = 0; j < m.length - i - 1; j++)
                if(m[j] < m[j + 1]){
                    int temp = m[j];
                    m[j] = m[j+1];
                    m[j+1] = temp;
                }
        }
        for(int i = 0; i < m.length; i++){
            System.out.println(m[i]);
        }

    }
}
