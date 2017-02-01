package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedInputStream reader = null;
        try{
            if (args.length < 1){
                return;
            } else{
                reader = new BufferedInputStream(new FileInputStream(args[0]));
                int data;
                int count = 0;
                while ((data = reader.read()) != -1){
                    if (data > 64 && data < 91){
                        count++;
                    }
                    if (data > 96 && data < 123){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
        finally{
            if (reader != null){
                reader.close();
            }
        }
    }
}
