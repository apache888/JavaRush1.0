package com.javarush.test.level19.lesson03.task04;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
 Метод read() должен читать данные одного человека.
*/

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        Scanner src;

        public PersonScannerAdapter(Scanner src)
        {
            this.src = src;
        }

        @Override
        public Person read() throws IOException
        {
            String[] dataParts = src.nextLine().split(" ");
            int month = Integer.parseInt(dataParts[4]);
            Calendar birthDate = new GregorianCalendar(Integer.parseInt(dataParts[5]),
                   --month , Integer.parseInt(dataParts[3]));
            return new Person(dataParts[1], dataParts[2], dataParts[0],
                    birthDate.getTime());
        }

        @Override
        public void close() throws IOException
        {
            src.close();
        }
    }
}
