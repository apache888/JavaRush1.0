package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {   // принято, но логика не выполняет ограничения
        int[] result = null;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int temp = i;
            int deg = String.valueOf(i).length();
            long sum = 0;
            while (temp != 0) {
                int digit = temp % 10;
                sum = sum + power(digit, deg);
                temp = temp / 10;
            }
            if (sum == i) {
                list.add(i);
            }
        }
        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static long power(int digit, int deg) {
        long pw = 1;
        for (int i = 0; i < deg; i++) {
            pw *=digit;
        }
        return pw;
    }

//    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        int[] arr = getNumbers(2_000_000_000);
//        long finish = System.currentTimeMillis() - start;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        System.out.println(finish / 1000 + " sec");
//        System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024d) + " Mb.");
//    }
}
