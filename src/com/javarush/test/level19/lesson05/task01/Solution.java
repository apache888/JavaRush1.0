package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName1));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName2));
        int count = 0;
        while (inputStream.available() > 0){
            int data = inputStream.read();
            count++;
            if (count%2 == 0){
                outputStream.write(data);
            }
        }
        inputStream.close();
        outputStream.close();
    }
}
