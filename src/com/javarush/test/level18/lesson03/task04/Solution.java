package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bytes.length; i++)
        {
            if (bytes[i] < min) min = bytes[i];
        }
        for (int i = 0; i < bytes.length; i++)
        {
            if (bytes[i] == min) System.out.print(i + " ");
        }
    }
}
