package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        while (reader.ready())
        {
            String[] dataParts = reader.readLine().split(" ");
            GregorianCalendar birthDate = new GregorianCalendar(
                    Integer.parseInt(dataParts[dataParts.length - 1]),
                    Integer.parseInt(dataParts[dataParts.length - 2]) - 1,
                    Integer.parseInt(dataParts[dataParts.length - 3]));
            String name = "";
            if(dataParts.length == 4){
                name = dataParts[0];
            }else {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < dataParts.length - 3; i++)
                {
                    builder.append(dataParts[i]);
                    builder.append(" ");
                }
                name = builder.toString().trim();
            }
            PEOPLE.add(new Person(name, birthDate.getTime()));

        }
        reader.close();
//        for (Person person: PEOPLE)
//        {
//            System.out.println(person.getName()+ " " + simpleDate.format(person.getBirthday()));
//        }
    }

}
