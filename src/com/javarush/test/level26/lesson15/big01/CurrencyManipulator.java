package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>(); //Map<номинал, количество>

    public CurrencyManipulator(String currencyCode){
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode(){
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        }else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount(){
        int amount = 0;
        for (Map.Entry<Integer, Integer> money : denominations.entrySet()) {
            amount += money.getKey() * money.getValue();
        }
        return amount;
    }

    public boolean hasMoney(){
        if (denominations.isEmpty()){
            return false;
        }else {
            int count = 0;
            for (Map.Entry<Integer, Integer> map : denominations.entrySet()) {
                if (map.getValue() == 0) {
                    count++;
                }
            }
            if (count == denominations.size()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAmountAvailable(int expectedAmount){
        int total = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()){
            total += pair.getKey() * pair.getValue();
        }
        if (expectedAmount <= total){
            return true;
        }
        return false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException{
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        ArrayList<Integer> currentDenominations = new ArrayList<>(denominations.keySet());
        Collections.sort(currentDenominations, Collections.reverseOrder());
        Map<Integer, Integer> copyDenominations = new TreeMap<>(denominations);

        int amount = expectedAmount;

        for (int i = 0; i < currentDenominations.size(); i++) {
            int denomination = currentDenominations.get(i);
            if (amount >= denomination) {
                int count = amount / denomination;
                if (denominations.get(denomination) > count) {
                    map.put(denomination, count);
                    copyDenominations.put(denomination, copyDenominations.get(denomination) - count);
                    amount -= denomination * count;
                }else {
                    map.put(denomination, copyDenominations.get(denomination));
                    amount -= denomination * copyDenominations.get(denomination);
                    copyDenominations.remove(denomination);
                }
            }
        }
        if (amount != 0){
            throw new NotEnoughMoneyException();
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            denominations.put(pair.getKey(), denominations.get(pair.getKey()) - pair.getValue());
        }
//        ConsoleHelper.writeMessage("Transaction is successful");
        return map;
    }
}
