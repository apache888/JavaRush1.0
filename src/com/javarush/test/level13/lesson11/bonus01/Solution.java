package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inputStream = new BufferedReader(new FileReader(reader.readLine()));
        List<Integer> list = new ArrayList<Integer>();
        int dig;
        while (inputStream.ready())
        {
            dig = Integer.parseInt(inputStream.readLine());
            if (dig % 2 == 0){
                list.add(dig);
            }
        }
        reader.close();
        inputStream.close();
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }
}
