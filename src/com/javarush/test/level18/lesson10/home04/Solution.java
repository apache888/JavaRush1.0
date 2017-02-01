package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        byte[] buff = new byte[1024];
        int count = 0;

        FileInputStream in = new FileInputStream(fileName1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        while ((count = in.read(buff)) != -1){
            out.write(buff,0,count);
        }
        out.flush();
        byte[]tmp = out.toByteArray();
        out.close();
        in.close();

        FileInputStream in1 = new FileInputStream(fileName2);
        FileOutputStream out1 = new FileOutputStream(fileName1, false);
        while ((count = in1.read(buff)) != -1){
            out1.write(buff,0,count);
        }
        out1.flush();
        out1.close();
        in1.close();

        ByteArrayInputStream in2 = new ByteArrayInputStream(tmp);
        FileOutputStream out2 = new FileOutputStream(fileName1, true);
        while ((count = in2.read(buff)) != -1){
            out2.write(buff,0,count);
        }
        out2.flush();
        out2.close();
        in2.close();
    }
}
