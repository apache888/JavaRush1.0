package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        BufferedWriter outputStream = new BufferedWriter(new FileWriter(reader.readLine()));
        String str;
        while (true){
            str = reader.readLine();
            outputStream.write(str);
            if (str.equalsIgnoreCase("exit"))
            {
                break;
            }
            outputStream.newLine();
        }

        outputStream.close();
        inputStream.close();
    }
}