package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
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

        while (reader.ready())
        {
            String nextString = reader.readLine();
//            nextString = nextString.replaceAll(".", "!");
            writer.write(nextString.replaceAll("\\.", "!") + "\n");
        }
        reader.close();
        writer.close();
    }
}
