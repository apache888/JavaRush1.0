package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде,
 в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, MyString
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));

        String str = "";
        StringBuilder sb = new StringBuilder();
        while ((str = reader.readLine()) != null)
        {
            String[] strs = str.split(" ");
            if(strs[0].equals(args[0])){
                    for (int i = 0; i < strs.length; i++){
                        sb.append(strs[i]);
                        sb.append(" ");
                    }
                str = sb.toString().trim();
                System.out.println(str);
                break;
                }
        }
        bufferedReader.close();
        reader.close();
    }
}
