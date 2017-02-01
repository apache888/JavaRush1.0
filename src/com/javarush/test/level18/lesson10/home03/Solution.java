package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream is2 = new FileInputStream(fileName2);
        FileInputStream is3 = new FileInputStream(fileName3);
        FileOutputStream out1 = new FileOutputStream(fileName1, false);

        byte[] buff = new byte[1024];
        int count = 0;

        reader.close();

        while ((count = is2.read(buff)) != -1){
            out1.write(buff,0,count);
        }
        out1.flush();
        out1.close();
        is2.close();

        BufferedOutputStream out2 = new BufferedOutputStream(new FileOutputStream(fileName1, true));

        while ((count = is3.read(buff)) != -1){
            out2.write(buff,0,count);
        }
        out2.flush();
        out2.close();
        is3.close();

    }
}
