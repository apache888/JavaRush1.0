package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SolutionDraft
{
    private static String tag;
    private static ArrayList<Integer> begins = new ArrayList<>();
    private static ArrayList<Integer> ends = new ArrayList<>();
    private static ArrayList<Integer> beginTags = new ArrayList<>();
    private static ArrayList<Integer> endTags = new ArrayList<>();

    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("haven't program arguments");
            System.exit(-1);
        }
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("file does not exists");
            System.exit(-1);
        }

        StringBuilder builder = new StringBuilder();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        tag = args[0];
        for (int i = 0; i < builder.length(); i++)
        {
            if (builder.charAt(i) == '<'){
                begins.add(i);
            }else if (builder.charAt(i) == '>'){
                ends.add(i);
            }
        }

//        for (int i = 0; i < ends.size(); i++)
//        {
//            if (builder.substring(begins.get(i), ends.get(i)).contains("<" + tag))
//            {
//                beginTags.add(begins.get(i));
//                endTags.add(null);
//            }else if (builder.substring(begins.get(i), ends.get(i)).contains("</" + tag + ">"))
//            {
//                endTags.set(endTags.lastIndexOf(null), ends.get(i));
//            }
//        }

        for (int i = 0; i < ends.size(); i++)
        {
            if (builder.substring(begins.get(i), ends.get(i)).indexOf("<" + tag) == 0)
            {
                beginTags.add(begins.get(i));
                endTags.add(null);
            }else if (builder.substring(begins.get(i), ends.get(i)).indexOf("</" + tag + ">") == 0)
            {
                endTags.set(endTags.lastIndexOf(null), ends.get(i));
            }
        }

        for (Integer beginTag : endTags)
        {
            System.out.println(beginTag);
        }

        for (int i = 0; i < endTags.size(); i++)
        {
            System.out.println(builder.substring(beginTags.get(i), endTags.get(i)) + ">");
        }
    }
}
