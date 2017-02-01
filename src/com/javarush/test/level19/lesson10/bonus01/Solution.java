package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        //init
        Scanner sc = new Scanner(System.in);
        BufferedReader reader1 = new BufferedReader(new FileReader(sc.nextLine()));
        BufferedReader reader2 = new BufferedReader(new FileReader(sc.nextLine()));
        sc.close();

        //read
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        while (reader1.ready()) {
            list1.add(reader1.readLine());
        }
        while (reader2.ready()) {
            list2.add(reader2.readLine());
        }
        //process
        if (list2.size() == 0){
            for (int i = 0; i < list1.size(); i++)
            {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            }
        }

            for (int i = 0; i < list1.size(); i++)
            {
                if(list2.size() > 0 && list1.get(i).equals(list2.get(0))){
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    list2.remove(0);
                }else
                    if(list2.size() > 1 && list1.get(i).equals(list2.get(1))){
                        lines.add(new LineItem(Type.ADDED, list2.get(0)));
                        list2.remove(0);
                        i--;
                    }else{
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    }
            }
        if(list2.size() != 0){
            for (int i = 0; i < list2.size(); i++)
            {
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
            }
        }

        //close files
        reader1.close();
        reader2.close();
        for (LineItem it: lines)
        System.out.println(it.type + " " + it.line);
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
