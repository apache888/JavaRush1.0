package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру
Примеры:
+380501234567 - true
+38(050)1234567 - true
    +38(050)123-45-67 - from me
+38050123-45-67 - true
050123-4567 - true
    050123-45-67 - from me
    0501234567 - from me

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
//Pattern pattern1 = Pattern.compile("^\\+\\d{12}$");
//Pattern pattern2 = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
//Pattern pattern3 = Pattern.compile("^\\+\\d{8}-\\d{2}-\\d{2}$");
//Pattern pattern4 = Pattern.compile("^\\d{6}-\\d{4}$");

public class Solution {
//    public static boolean checkTelNumber(String telNumber) {
//        Pattern pattern1 = Pattern.compile("^\\+\\d{12}$");
//        Pattern pattern2 = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
//        Pattern pattern3 = Pattern.compile("^\\+\\d{2}\\(\\d{3}\\)\\d{7}$");
//        Pattern pattern4 = Pattern.compile("^\\+\\d{8}-\\d{2}-\\d{2}$");
//
//        Pattern pattern5 = Pattern.compile("^\\d{6}-\\d{4}$");
//        Pattern pattern6 = Pattern.compile("^\\d{10}$");
//        Pattern pattern7 = Pattern.compile("^\\d{6}-\\d{2}-\\d{2}$");
//
//        Pattern pattern8 = Pattern.compile("^\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$");
//        Pattern pattern9 = Pattern.compile("^\\(\\d{3}\\)\\d{5}-\\d{2}$");
//        Pattern pattern10 = Pattern.compile("^\\(\\d{3}\\)\\d{3}-\\d{4}$");
//        Pattern pattern11 = Pattern.compile("^\\(\\d{3}\\)\\d{7}$");
//
//        if(telNumber.charAt(0) == '+'){
//            Matcher m1 = pattern1.matcher(telNumber);
//            Matcher m2 = pattern2.matcher(telNumber);
//            Matcher m3 = pattern3.matcher(telNumber);
//            Matcher m4 = pattern4.matcher(telNumber);
//            if(m1.matches()) return true;
//            else if(m2.matches()) return true;
//            else if(m3.matches()) return true;
//            else if(m4.matches()) return true;
//        }else if(telNumber.charAt(0) == '('){
//            Matcher m1 = pattern8.matcher(telNumber);
//            Matcher m2 = pattern9.matcher(telNumber);
//            Matcher m3 = pattern10.matcher(telNumber);
//            Matcher m4 = pattern11.matcher(telNumber);
//            if(m1.matches()) return true;
//            else if(m2.matches()) return true;
//            else if(m3.matches()) return true;
//            else if(m4.matches()) return true;
//        }else if(Character.isDigit(telNumber.charAt(0))){
//            Matcher m1 = pattern5.matcher(telNumber);
//            Matcher m2 = pattern6.matcher(telNumber);
//            Matcher m3 = pattern7.matcher(telNumber);
//            if(m1.matches()) return true;
//            else if(m2.matches()) return true;
//            else if(m3.matches()) return true;
//        }
//
//        return false;
//    }
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber.charAt(0) == '+') {
        boolean bRightDigitsCount = (telNumber.length() - 12) == telNumber.replaceAll("\\d", "").length();
        //System.out.println("digit count: " + bRightDigitsCount);
        return bRightDigitsCount
                && telNumber.matches("\\+(\\d{12}|\\d{1,2}\\(\\d{3}\\)(\\d{7,8}|\\d+-\\d+|\\d+-\\d+-\\d+))");
    }
    else {
        boolean bRightDigitsCount = (telNumber.length() - 10) == telNumber.replaceAll("\\d", "").length();
        return bRightDigitsCount
                && telNumber.matches("(\\d{10}|\\(\\d{3}\\)(\\d{7}|\\d+-\\d+|\\d+-\\d+-\\d+))");
    }
}
    public static void main(String[] args)
    {
//        System.out.println("+380501234567 - " + checkTelNumber("+380501234567"));
//        System.out.println("+38(050)1234567 - " + checkTelNumber("+38(050)1234567"));
//        System.out.println("+38(050)123-45-67 - " + checkTelNumber("+38(050)123-45-67"));
//        System.out.println("+38050123-45-67 - " + checkTelNumber("+38050123-45-67"));
//        System.out.println("***********************");
//        System.out.println("050123-4567 - " + checkTelNumber("050123-4567"));
//        System.out.println("050123-45-67 - " + checkTelNumber("050123-45-67"));
//        System.out.println("0501234567 - " + checkTelNumber("0501234567"));
//        System.out.println("(0)501234567 - " + checkTelNumber("(0)501234567"));
//        System.out.println("p(0)501234567 - " + checkTelNumber("p(0)501234567"));
        System.out.println("+38051202(345)7 - " + checkTelNumber("+38051202(345)7"));
    }
}
