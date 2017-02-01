package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ...,
 в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedOutputStream writer = null;
        BufferedInputStream reader = null;
        List<String> fileParts = new ArrayList<>();

        BufferedReader readerName = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = readerName.readLine()).equalsIgnoreCase("end")){
            if (!fileName.equals("")){
                fileParts.add(fileName);
            }
        }
        Collections.sort(fileParts);
        readerName.close();
        try{
            if (fileParts.size() > 0){
                String dstFileName = fileParts.get(0);
                dstFileName = dstFileName.substring(0, dstFileName.lastIndexOf('.'));
                File file = new File(dstFileName);
                writer = new BufferedOutputStream(new FileOutputStream(file));

                for (String name : fileParts)
                {
                    reader = new BufferedInputStream(new FileInputStream(name));
                    byte[] buff = new byte[reader.available()];
                    while (reader.available() > 0)
                    {
                        reader.read(buff);
                        writer.write(buff);
                    }
                    writer.flush();
                    reader.close();
                }
            }
        } finally{
            if (writer != null){
                writer.flush();
                writer.close();
            }
            if (reader != null){
                reader.close();
            }
        }
    }
}
