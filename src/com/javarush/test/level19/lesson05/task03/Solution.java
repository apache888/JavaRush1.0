package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader nameReader =  new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = nameReader.readLine();
        String fileName2 = nameReader.readLine();
        nameReader.close();

        BufferedReader reader =  new BufferedReader(new FileReader(fileName1));
        FileWriter writer = new FileWriter(fileName2);

        while (reader.ready()){
            String nextString = reader.readLine();
            String[] words = nextString.split(" ");
            for (int i = 0; i < words.length; i++)
            {
                try{
                int num = Integer.parseInt(words[i]);
                    writer.write(words[i]);
                    writer.write(" ");
                }catch (NumberFormatException e){

                }
            }
        }
        reader.close();
        writer.close();
    }
}
