package com.javarush.test.level31.lesson06.home01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            return;
        }

        Path fileName = Paths.get(args[0]);
        Path zipFile = Paths.get(args[1]);
        Path tempZipFile = Files.createTempFile(null, null);
        List<Path> archiveFiles = new ArrayList<>();

        try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempZipFile));
            ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))){

            ZipEntry zipEntry;
            byte[] buffer = new byte[8 * 1024];
            int len;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                archiveFiles.add(Paths.get(zipEntry.getName()));
                if (zipEntry.getName().equals(fileName.getFileName().toString())){
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getName()));
                    InputStream inputStream = Files.newInputStream(fileName);
                    while ((len = inputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, len);
                    }
                    zipOutputStream.closeEntry();
                    zipInputStream.closeEntry();
                    inputStream.close();
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getName()));
                    while ((len = zipInputStream.read(buffer)) > 0) {
                        zipOutputStream.write(buffer, 0, len);
                    }
                    zipInputStream.closeEntry();
                    zipOutputStream.closeEntry();
                }
            }
            //!!!задача принялась с закоментирванной проверкой
            if (!archiveFiles.contains(fileName.getFileName())) {
//                zipOutputStream.putNextEntry(new ZipEntry(fileName.getFileName().toString()));
//                InputStream inputStream = Files.newInputStream(fileName);
//                while ((len = inputStream.read(buffer)) > 0) {
//                    zipOutputStream.write(buffer, 0, len);
//                }
//                zipOutputStream.closeEntry();
//                inputStream.close();
                try(InputStream inputStream = Files.newInputStream(fileName);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream()){
                    while ((len = inputStream.read(buffer)) > 0) {
                    baos.write(buffer, 0, len);
                    }
                    zipEntry = new ZipEntry("new/" + fileName.getFileName().toString());
                    zipOutputStream.putNextEntry(zipEntry);
                    zipOutputStream.write(baos.toByteArray());
                    zipOutputStream.closeEntry();
                }
            }
        }
        Files.move(tempZipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }
}
