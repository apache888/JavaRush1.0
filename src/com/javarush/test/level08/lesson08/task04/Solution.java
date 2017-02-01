package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<MyString, Date>) и занести в него десять записей по принципу:
«фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Arni", new Date("JULY 4 1980"));
        map.put("Dom", new Date("MARCH 4 1980"));
        map.put("Peter", new Date("MAY 4 1980"));
        map.put("Mat", new Date("SEPTEMBER 4 1980"));
        map.put("Kyle", new Date("OCTOBER 4 1980"));
        map.put("Anna", new Date("AUGUST 4 1980"));
        map.put("olga", new Date("NOVEMBER 4 1980"));
        map.put("Anton", new Date("DECEMBER 4 1980"));
        map.put("Sofia", new Date("APRIL 4 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        HashMap<String, Date> copy = new HashMap<String, Date>(map);
        for (Map.Entry<String, Date> ent : copy.entrySet()){
            if (ent.getValue().getMonth() > 4 && ent.getValue().getMonth() < 8){
                map.remove(ent.getKey());
            }
        }
    }
}
