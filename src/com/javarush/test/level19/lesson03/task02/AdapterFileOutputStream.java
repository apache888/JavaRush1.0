package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream
 к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    FileOutputStream dst;

    public AdapterFileOutputStream(FileOutputStream dst)
    {
        this.dst = dst;
    }

    @Override
    public void flush() throws IOException
    {
        dst.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        byte[] buff = s.getBytes("UTF-8");
        dst.write(buff);
    }

    @Override
    public void close() throws IOException
    {
        dst.close();
    }
}

