package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<String,Double> pairMap = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready())
        {
            String[] pairData = reader.readLine().split(" ");
            if(pairMap.containsKey(pairData[0])){
                Double newValue = pairMap.get(pairData[0]) + Double.parseDouble(pairData[1]);
                pairMap.remove(pairData[0]);
                pairMap.put(pairData[0], newValue);
            }else {
                pairMap.put(pairData[0], Double.parseDouble(pairData[1]));
            }
        }
        reader.close();
        String reacher = "";
        double max = 0;
        for(Map.Entry<String , Double> pair:pairMap.entrySet()){
            String key = pair.getKey();
            double value = pair.getValue();
            if(value > max){
                max = value;
                reacher = key;
            }

        }
        System.out.println(reacher);
    }
}
