package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ?
 и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(MyString value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14

javarush.ru/alpha/index.html?lvl=15&??view&&&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&&?oobj=3
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        if(!string.startsWith("http://")){
            string = "http://" + string;
        }
        URL url = new URL(string);
//        System.out.println(url.getQuery());
        String str = "";
        String[] arr = url.getQuery().split("&");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("=")) {
                str += (arr[i].substring(0, arr[i].indexOf("="))).replace("?","");
            } else if(!arr[i].equals("")) {
                str += arr[i].replace("?","");
            }
            if(arr[i] != arr[arr.length-1] && !arr[i].equals("")){
                str += " ";
            }
        }
        System.out.println(str);
        for (int j = 0; j < arr.length; j++) {
            if (arr[j].startsWith("obj=")){
                try {
                    alert(Double.parseDouble(arr[j].substring(arr[j].indexOf("=")).replace("=", "")));
                } catch (Exception e) {
                    alert(arr[j].substring(arr[j].indexOf("=")).replace("=", ""));
                }
            }
        }

        }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("MyString " + value);
    }
}
