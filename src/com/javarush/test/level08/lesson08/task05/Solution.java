package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<MyString, MyString>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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
        map.put("h", "Ding");
        map.put("g", "Ding");
        map.put("i", "Billy");
        map.put("j", "Mat");

        return map;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet()){
            int count = getCountTheSameFirstName(map, pair.getValue());
            if (count > 1)
            removeItemFromMapByValue(map, pair.getValue());
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
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
}
