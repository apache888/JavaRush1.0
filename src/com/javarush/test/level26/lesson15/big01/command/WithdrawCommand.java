package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

class WithdrawCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException{
        ConsoleHelper.writeMessage(res.getString("before"));
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        boolean success = false;
        int amount = 0;
        do{
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try{
                amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0) {
                    throw new NumberFormatException();
                }
            }catch (NumberFormatException e){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
            try{
                if (!manipulator.isAmountAvailable(amount)){
                    throw new NotEnoughMoneyException();
                }
            }
            catch (NotEnoughMoneyException e){
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
            try {
                TreeMap<Integer, Integer> map = new TreeMap<>(manipulator.withdrawAmount(amount));
                for (Map.Entry<Integer, Integer> pair : map.descendingMap().entrySet()) {
                    ConsoleHelper.writeMessage("    " + pair.getKey() + " - " + pair.getValue());
                }
                success = true;
                ConsoleHelper.writeMessage(res.getString("success.format"));
            }
            catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
        }while (!success);
    }
}
