package com.javarush.test.level20.lesson10.home04;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Исправить ошибку
После десериализации объекта класса SolutionDraft обнаружили, что данных в словаре [m] нет :(
Исправить 1 ошибку.
Метод main в тестировании не участвует.
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("your.file.name.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        outputStream.flush();
        fileOutput.close();
        outputStream.close();

        for (Map.Entry<String,String> pair: solution.getMap().entrySet()){
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }

        //loading
        FileInputStream fiStream = new FileInputStream("your.file.name.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }



    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }
    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public int size() {
        return m.size();
    }
}
