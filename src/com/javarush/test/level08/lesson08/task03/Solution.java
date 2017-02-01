package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<MyString, MyString>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a", "Peter");
        map.put("b", "Liza");
        map.put("c", "Robert");
        map.put("d", "Hook");
        map.put("e", "Hook");
        map.put("f", "Ding");
        map.put("h", "Dong");
        map.put("g", "Dung");
        map.put("i", "Billy");
        map.put("j", "Mat");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;
        for (Map.Entry<String, String> ent : map.entrySet()){
            if (name.equals(ent.getValue())){
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count = 0;

        for (String key : map.keySet())
        {
            if(lastName.equals(key))
            {
                count++;
            }
        }
        return count;
    }
}
