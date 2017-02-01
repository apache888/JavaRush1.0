package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> words = new ArrayList<>();
        String string;
        while ((string = reader.readLine()) != null) {
            words.addAll(Arrays.asList(string.split(" ")));
        }
        reader.close();

        for (int i = 0; i < words.size() ; i++) {
            String str = words.get(i);
            String reverse = new StringBuffer(str).reverse().toString();
            if (words.indexOf(reverse) != -1 && !str.equals("") && !str.equals(reverse)) {
                Pair pair = new Pair();
                pair.first = str;
                pair.second = reverse;
                result.add(pair);
                words.remove(str);
                words.remove(reverse);
            }
        }

        for(Pair pair: result){
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
