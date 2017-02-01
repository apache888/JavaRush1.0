package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        String result;
        try
        {
            int first = string.indexOf('\t');
            int second = string.substring(first + 1).indexOf('\t') + string.substring(0, first + 1).length();
            result = string.substring(first + 1, second);
        }catch (Exception e){
            throw new TooShortStringException(e);
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
        TooShortStringException (Throwable t){
            super(t);
        }
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
