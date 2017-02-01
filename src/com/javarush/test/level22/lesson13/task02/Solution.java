package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое
 первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        BufferedInputStream input = new BufferedInputStream(new FileInputStream(args[0]));
        ByteArrayOutputStream outToArr = new ByteArrayOutputStream();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(args[1]));
        byte[] buff = new byte[input.available()];
        while (input.available() > 0){
            input.read(buff);
            outToArr.write(buff);
        }
        outToArr.flush();
        outToArr.close();
        input.close();

        byte[] arr = outToArr.toByteArray();
        String string = new String(arr, utf8);
        arr = string.getBytes(win1251);
        out.write(arr);
        out.flush();
        out.close();
    }
}