package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String sourcePath = args[0];
        String fileName = args[1];
        final File fileTarget = new File(fileName);
        final File newFileTarget = new File(fileTarget.getParent() + File.separator + "allFilesContent.txt");
        final List<File> list = new LinkedList<>();
        FileOutputStream out = null;
        FileInputStream input = null;

        Files.walkFileTree(Paths.get(sourcePath), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (!file.equals(fileTarget.toPath()) && !file.equals(newFileTarget.toPath())) {
                    if (Files.size(file) > 50) {
                        Files.delete(file);
                    }else {
                        list.add(file.toFile());
                    }
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

//                if (exc == null) {
//                    Files.delete(dir);
//                    return FileVisitResult.CONTINUE;
//                } else {
//                    // directory iteration failed
//                    throw exc;
//                }
                if(dir.toFile().listFiles().length == 0)
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });

//        list.remove(fileTarget);
//        list.remove(newFileTarget);
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        fileTarget.renameTo(newFileTarget);
        out = new FileOutputStream(newFileTarget);

        for (File pathFile : list) {
            int count = 0;
            input = new FileInputStream(pathFile);
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            out.write(buffer);
            count++;
            if (count < list.size()) {
//                out.write('\n');
                out.write(System.lineSeparator().getBytes());
            }
        }
        out.flush();
        out.close();
        input.close();
    }
}
