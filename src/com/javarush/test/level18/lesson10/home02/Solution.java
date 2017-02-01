package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
//        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter());
        FileInputStream is = new FileInputStream(args[0]);
        int data;
        int count = 0;
        int totalCount = 0;
        while((data = is.read()) != -1){
            if(data == 32){count++;}
            totalCount++;
        }
        System.out.println(String.format("%.2f", count/(double)totalCount*100));
        is.close();
    }
}
