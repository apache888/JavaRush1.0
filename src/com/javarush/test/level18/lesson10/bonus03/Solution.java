package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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

    public static void main(String[] args) {
        if (args.length != 5 && args.length != 2){
            return;
        }
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            priceName = reader.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally{
            if (reader != null){
                try{
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        if (args[0].equals("-u")){
            updatePrice(priceName, args[1], args[2], args[3], args[4]);
        }else if(args[0].equals("-d")){
            deleteProduct(priceName, args[1]);
        }
//        String id = args[1];
//        String productName = args[2];
//        String price = args[3];
//        String quantity = args[4];
    }

    private static void deleteProduct(String name, String id){

            BufferedReader reader = null;
            StringWriter writer = null;
            FileWriter out = null;
            try{
                reader = new BufferedReader (new FileReader(name));
                writer = new StringWriter();
//                out = new FileWriter(name);
                String str;
                char[] buff;
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
                    if(!sb.toString().equals(id)){
                        writer.write(str);
                    }
                    writer.flush();
                }
                str = writer.toString();
                reader.close();
                out = new FileWriter(name);
                out.write(str);
            }catch (IOException e){
                e.printStackTrace();
            }finally{
                try{
                    reader.close();
                    writer.close();
                    out.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
    }

    private static void updatePrice(String name, String id, String prName, String price, String quantity){
        BufferedReader reader = null;
        StringWriter writer = null;
        FileWriter out = null;
        try{
            reader = new BufferedReader (new FileReader(name));
            writer = new StringWriter();
//            out = new FileWriter(name);
            String str;
            char[] buff;
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
                if(sb.toString().equals(id)){
                    sb.delete(0, sb.length());
                    sb.append(addSpaces(id, 8)).append(addSpaces(prName, 30))
                            .append(addSpaces(price, 8)).append(addSpaces(quantity, 4));
                    str = sb.toString();
                }
                writer.write(str+"\n");
                writer.flush();
            }
            str = writer.toString();
            reader.close();
            out = new FileWriter(name);
            out.write(str);
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                reader.close();
                writer.close();
                out.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
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
}
