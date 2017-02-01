package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        String resultFileName = args[0];
        FileOutputStream fos = new FileOutputStream(resultFileName, true);
        FileInputStream fis = null;
        ZipInputStream zis;
        ZipEntry ze;
        byte[] buffer = new byte[4096];
        int count;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        for (int i = 1; i < args.length; i++) {
            list.add(args[i]);
        }
        Collections.sort(list);

        for (String filePart : list) {
            fis = new FileInputStream(filePart);
            while ((count = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            baos.flush();
        }

        zis = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()));
        while ((ze = zis.getNextEntry()) != null) {
            while ((count = zis.read(buffer)) != -1) {
                fos.write(buffer, 0, count);
            }
            fos.flush();
        }
        fos.close();
        zis.close();
        baos.close();
        fis.close();
    }
}
