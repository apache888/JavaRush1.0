package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Составить цепочку слов (hard *****  перебор или рекурсия)
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн
ab ca bd db bc ba
бг бв аб бд гб дб

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        //...
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();
        List<String> words = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));)
        {
            words = new ArrayList<String>();
            String string;
            while ((string = reader.readLine()) != null) {
                words.addAll(Arrays.asList(string.split(" ")));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String[] arr = new String[words.size()];
        arr =  words.toArray(arr);

        StringBuilder result = getLine(arr);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        if(words == null || words.length == 0){
            return sb;
        }
        if(words[0].equals("") || words.length == 1){
            return sb.append(words[0]);
        }
        while (true){
            int count = 0;
            for (int i = 0; i < words.length - 1; i++)
            {
                String wordA = words[i].toLowerCase();
                char lastLetter = wordA.charAt(wordA.length() - 1);
                String wordB = words[i + 1].toLowerCase();
                char firstLatter = wordB.charAt(0);
                if (lastLetter == firstLatter) count++;
            }
            if (count >= (words.length - 1)) break;
            List tmp = Arrays.asList(words);
            Collections.shuffle(tmp);
            words = (String[]) tmp.toArray();
        }
        for (String s : words)
        {
            sb.append(s).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
          return sb;
    }
}
