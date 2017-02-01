package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {

        List<String> list = new ArrayList<>();
        StringTokenizer tokenizer =
                new StringTokenizer(query,delimiter);
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            list.add(token);
        }
        String[] result = new String[list.size()];
        result = list.toArray(result);
        return result;
    }

    public static void main(String[] args)
    {
        String[] arr = getTokens("level22.lesson13.task01", ".");
//        for(String str: arr){
//            System.out.println(str);
//        }
        System.out.println(Arrays.toString(arr));
    }
}
