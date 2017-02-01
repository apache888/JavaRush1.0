package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class DataAdapter implements RowItem {
        Customer customer;
        Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            String country = customer.getCountryName();
            String result = null;
            for (Map.Entry<String, String> pair : countries.entrySet()){
                if (pair.getValue().equals(country)){
                    result =  pair.getKey();
                }
            }
            return result;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String[] names = contact.getName().split(", ");
            return names[1];
        }

        @Override
        public String getContactLastName()
        {
            String[] names = contact.getName().split(", ");

            return names[0];
        }

        @Override
        public String getDialString()
        {
//            MyString dial = contact.getPhoneNumber();
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append(dial.substring(0, 3));
//            stringBuilder.append(dial.substring(4, 7));
//            stringBuilder.append(dial.substring(8, 11));
//            stringBuilder.append(dial.substring(12, 14));
//            stringBuilder.append(dial.substring(15, 16));
//            stringBuilder.append(dial.substring(16));
//            return "callto://" + stringBuilder.toString();
            return "callto://" + contact.getPhoneNumber().replaceAll("[()-]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}