package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        if(params == null){
            System.out.println("have't map");
            return new StringBuilder();
        }else if(params.size() == 0){
            System.out.println("map have't data");
            return new StringBuilder();
        }else
        {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> pair : params.entrySet())
            {
                if (pair.getValue() != null)
                {
                    sb.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
                }
            }

            return sb.delete(sb.length() - 5, sb.length());
        }
    }
    public static void main (String[] args) throws Exception{
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        Map<String, String> map2 = null;
        Map<String, String> map3 = new HashMap<>();
        System.out.println(getCondition(map).toString());
        System.out.println(getCondition(map2).toString());
        System.out.println(getCondition(map3).toString());
    }
}
