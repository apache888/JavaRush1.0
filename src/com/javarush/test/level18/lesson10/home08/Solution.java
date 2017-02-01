package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
 и добавить его в словарь resultMap,
где параметр MyString - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while (!(fileName = reader.readLine()).toLowerCase().equals("exit")){
            new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        BufferedInputStream inputStream;
        String fileName;
        public ReadThread(String fileName) throws IOException
        {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run(){
            try{
                inputStream = new BufferedInputStream(new FileInputStream(fileName));
                int data;
                Integer maxByte;
                int[] bytesCount = new int[256];
                while ((data = inputStream.read()) != -1){
                    bytesCount[data]++;
                }
                maxByte = max(bytesCount);
                synchronized (resultMap)
                {
                    resultMap.put(fileName, maxByte);
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            finally{
                if (inputStream != null){
                    try{
                        inputStream.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        int max(int[] array){
            int max = array[0];
            int index = 0;
            for (int i = 0; i < array.length; i++){
                if(array[i] > max){
                    max = array[i];
                    index = i;
                }
            }
            return index;
        }

    }
}