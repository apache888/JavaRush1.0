package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
//    public static final int LIMIT_WORDS = 2;

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader readName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readName.readLine();
        readName.close();

        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileName));
            String string;
            while (reader.ready()){
                int count = 0;
                string = reader.readLine();
                String[] stringParts = string.replaceAll("\\p{Punct}", " ").split(" ");
                for (int i = 0; i < stringParts.length; i++)
                {
                    for (String str: words){
                        if(stringParts[i].equals(str)){
                            count++;
                        }
                    }
                }
                if(count == 2){
                    System.out.println(string);
                }
            }
        }
        finally
        {
            if (reader != null)
            {
                reader.close();
            }
        }

    }
}
