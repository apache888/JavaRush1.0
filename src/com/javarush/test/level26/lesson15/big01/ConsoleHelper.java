package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper{
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        String result = null;
        try{
            result = reader.readLine();
            if (result.equalsIgnoreCase("EXIT")){
                ConsoleHelper.writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }
        }catch (IOException e){}
//        finally
//        {
//            try
//            {
//                if (reader != null)
//                {
//                    reader.close();
//                }
//            }
//            catch (IOException e)
//            {
//            }
//        }
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        String result;
        while (true){
            writeMessage(res.getString("choose.currency.code"));
            result = readString();
            if (result.length() == 3){
                break;
            }
            writeMessage(res.getString("invalid.data"));
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        String twoDigits;
        String[] digits;
        while (true){
            writeMessage(res.getString("choose.denomination.and.count.format"));
            twoDigits = readString();
            digits = twoDigits.split(" ");
            try {
                if (digits.length == 2 && Integer.parseInt(digits[0]) >= 0 && Integer.parseInt(digits[1]) >= 0) {
                    return digits;
                } else writeMessage(res.getString("invalid.data"));
            }
            catch (NumberFormatException e) {
                writeMessage(res.getString("invalid.data"));
            }
        }

    }

    public static Operation askOperation() throws InterruptOperationException{
        while (true){
//            ConsoleHelper.writeMessage("Choose operation: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            ConsoleHelper.writeMessage(res.getString("choose.operation"));
            try{
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            }catch (IllegalArgumentException e){}

            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }

    public static void printExitMessage(){
        ConsoleHelper.writeMessage("Goodbye!");
    }
}
