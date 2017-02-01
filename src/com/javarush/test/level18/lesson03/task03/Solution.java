package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int[] bytes = new int[256];
        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            bytes[data]++;
        }
        reader.close();
        inputStream.close();
        int max = 0;
        for (int i = 0; i < bytes.length; i++)
        {
            if (bytes[i] > max) max = bytes[i];
        }
        for (int i = 0; i < bytes.length; i++)
        {
            if (bytes[i] == max) System.out.print(i + " ");
        }
    }
}
