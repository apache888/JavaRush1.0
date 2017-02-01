package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        try {
            String code = ConsoleHelper.askCurrencyCode();
            String[] denominationAndCount = ConsoleHelper.getValidTwoDigits(code);
            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code)
                    .addAmount(Integer.parseInt(denominationAndCount[0]),
                            Integer.parseInt(denominationAndCount[1]));
            ConsoleHelper.writeMessage(res.getString("success.format"));
        }catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
