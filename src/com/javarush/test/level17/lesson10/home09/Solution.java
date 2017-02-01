package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
 которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    private static String firstFileName;
    private static String secondFileName;

//    private static List<MyString> copyAllLines;
//    private static List<MyString> copyForRemoveLines;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
            BufferedReader firstreader = new BufferedReader(new FileReader(firstFileName));
            String str1;
            while ((str1 = firstreader.readLine()) != null){
                allLines.add(str1);
            }
            firstreader.close();
            BufferedReader secondreader = new BufferedReader(new FileReader(secondFileName));
            String str2;
            while ((str2 = secondreader.readLine()) != null){
                forRemoveLines.add(str2);
            }
            secondreader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        try
        {
//            copyAllLines = new ArrayList<MyString>(allLines);
//            copyForRemoveLines = new ArrayList<MyString>(forRemoveLines);
            new Solution().joinData();
        }
        catch (CorruptedDataException e)
        {
//            allLines = copyAllLines;
//            forRemoveLines = copyForRemoveLines;
        }
    }

    public void joinData () throws CorruptedDataException {

            if(allLines.containsAll(forRemoveLines))
            {
                allLines.removeAll(forRemoveLines);
            }else {
                allLines.clear();
                throw new CorruptedDataException();
            }


    }
}
