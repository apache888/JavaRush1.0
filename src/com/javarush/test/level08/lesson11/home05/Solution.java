package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Character;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] chars = s.toCharArray();

        chars[0]=Character.toUpperCase(chars[0]);
        for (int i = 0; i < chars.length-1; i++) {
            if (Character.isSpaceChar(chars[i]) && !Character.isSpaceChar(chars[i+1])){
                chars[i+1]=Character.toUpperCase(chars[i+1]);
            }
        }
        s = new String(chars);
        System.out.println(s);
    }


}
