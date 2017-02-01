package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader nameReader =  new BufferedReader(new InputStreamReader(System.in));
        String fileName = nameReader.readLine();
        nameReader.close();

        BufferedReader reader =  new BufferedReader(new FileReader(fileName));
        int count = 0;
        while (reader.ready()){
            String nextString = reader.readLine();
            String[] words = nextString.split("[,.!? ;:]");
            for (int i = 0; i < words.length; i++)
            {
                if(words[i].equalsIgnoreCase("world")){
                    count++;
                }
            }
        }
        reader.close();
        System.out.println(count);
    }
}
