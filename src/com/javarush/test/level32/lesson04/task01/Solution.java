package com.javarush.test.level32.lesson04.task01;

import java.io.*;

/* Пишем стек-трейс
Реализуйте логику метода getStackTrace, который в виде одной строки должен возвращать
 весь стек-трейс переданного исключения.
Используйте подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) throws IOException {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        throwable.printStackTrace(printWriter);
//        Throwable th = throwable;
//        do {
//            writer.write(th.getMessage());
//
//        }while ((th = throwable.getCause()) != null);
//        writer.close();
        return writer.toString();
    }
}
