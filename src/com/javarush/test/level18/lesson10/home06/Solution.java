package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        CharArrayWriter writer = new CharArrayWriter();
        Map<Character, Integer> map = new TreeMap<>();
        Set<Character> set = new TreeSet<>();
        int data;
        while ((data = reader.read()) != -1){
            writer.write((char) data);
        }
        char[] chars = writer.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            set.add(chars[i]);
        }
        for (Character ch: set){
            int count = 0;
            for (int i = 0; i < chars.length; i++)
            {
                if (chars[i] == ch){
                    count++;
                }
            }
            map.put(ch, count);
        }

        for (Map.Entry<Character, Integer> pair: map.entrySet()){
            Character ch = pair.getKey();
            Integer count = pair.getValue();
            System.out.println(ch + " " + count);
        }
        writer.close();
        reader.close();
    }
}
