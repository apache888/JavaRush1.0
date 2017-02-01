package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName1 = args[0];
        String fileName2 = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

        String string;
        while (reader.ready())
        {
            string = reader.readLine();
            String[] stringParts = string.split(" ");
            for (int i = 0; i < stringParts.length; i++)
            {
                char[] chars = stringParts[i].toCharArray();
                for (int j = 0; j < chars.length; j++)
                {
                    if(Character.isDigit(chars[j])){
                        writer.write(stringParts[i]);
                        writer.write(" ");
                        break;
                    }
                }
            }
        }
        reader.close();
        writer.flush();
        writer.close();

    }
}
