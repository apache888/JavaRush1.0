package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
 инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static String priceName;
    public static void main(String[] args) throws Exception {
        if (!args[0].equals("-c") || args.length != 4){
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        priceName = reader.readLine();
        reader.close();

        String id = String.valueOf(getMaxId() +1);
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];

        String product = addSpaces(id, 8) + addSpaces(productName, 30) + addSpaces(price, 8)
                + addSpaces(quantity, 4);

//        FileOutputStream outStream = new FileOutputStream(priceName, true);
//        byte[]buff = product.getBytes();
//        outStream.write(13);
//        outStream.write(buff);
//        outStream.close();
        FileWriter out = new FileWriter(priceName, true);
        out.write(product);
        out.close();
    }
// adds spaces to end of items of price string
    private static String addSpaces(String string, int amount){
        String result;

        StringBuilder sb = new StringBuilder(string);
        for (int i = string.length(); i < amount; i++)
        {
            sb.append(" ");
        }
        result = sb.toString();
        return result;
    }

//    looking for max ID of product into price file
    private static int getMaxId() throws IOException
    {
        BufferedReader reader = new BufferedReader (new FileReader(priceName));
        char[] buff;
        String str;
        int maxId = 0;
        while (reader.ready()){
            str = reader.readLine();
            buff = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++)
            {
                if (buff[i] != ' '){
                    sb.append(buff[i]);
                }
            }
            int id = Integer.parseInt(sb.toString());
            if(id > maxId) maxId = id;
        }
        reader.close();
        return maxId;
    }
}
