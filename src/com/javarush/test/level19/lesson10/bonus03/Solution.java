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
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution
{
    private static String tag;
    private static String beginTag;
    private static String endTag;
    public static void main(String[] args) throws IOException{
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
        tag = args[0];
        beginTag = "<" + tag;
        endTag = "</" + tag + ">";

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

        TreeMap<Integer, Integer> indexMap = (TreeMap)separateTags(getOpenCloseIndexes(builder.toString()));
        for (Map.Entry<Integer, Integer> entry : indexMap.entrySet()) {
            System.out.println(builder.substring(entry.getKey(), entry.getValue()));
        }
    }

    //fill list of tag positions (String indexes)
    public static ArrayList<Pair<Boolean, Integer>> getOpenCloseIndexes(String str) {
        ArrayList<Pair<Boolean, Integer>> openCloseIndexes = new ArrayList<>();
        int seekPos = 0;
        while (str.indexOf(tag, seekPos) != -1) {
            int nextTagBeginPos = str.indexOf(beginTag, seekPos);
            int nextTagEndPos = str.indexOf(endTag, seekPos);
            if (nextTagEndPos == -1) break;
            if (nextTagBeginPos < nextTagEndPos && nextTagBeginPos != -1) {
                openCloseIndexes.add(new Pair(true, nextTagBeginPos));
                seekPos = nextTagBeginPos + beginTag.length();
            }
            else {
                openCloseIndexes.add(new Pair(false, nextTagEndPos + endTag.length()));
                seekPos = nextTagEndPos + endTag.length();
            }
        }
        return openCloseIndexes;
    }

    //Find pairs
    public static Map<Integer, Integer> separateTags(ArrayList<Pair<Boolean, Integer>> openCloseIndexes) {
        Map<Integer, Integer> indexMap = new TreeMap<Integer, Integer>();
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        int current = 0;
        while (current < openCloseIndexes.size()) {
            if (openCloseIndexes.get(current).getKey() == true) {
                stack.push(current);
                current++;
                continue;
            }
            indexMap.put(openCloseIndexes.get(stack.pop()).getValue(), openCloseIndexes.get(current).getValue());
            current++;
        }
        return indexMap;
    }

    public static class Pair<K, V> {
        private K key;
        private V value;

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public Pair(K var1, V var2) {
            this.key = var1;
            this.value = var2;
        }
    }
}
