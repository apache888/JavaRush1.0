package examples.tasks;

import java.util.Date;

public class Polindrome {
    public static void main(String[] args) {
        long startTime = new Date().getTime();
        int result = 0;
        int num1 = 0;
        int num2 = 0;
        for(int i = 999; i >= 100; i--) {
            for(int j = i; j >= 100; j--) {
                int value = i*j;
                if(value < result) {
                    break;
                }
                if(isPalindrome(value)) {
                    result = value;
                    num1 = i;
                    num2 = j;
                    break;
                }
            }
        }
        System.out.println("Result: " + result + " = " + num1 + "x" + num2);
        System.out.println("Time: " + (new Date().getTime() - startTime) + "ms");
    }

    public static boolean isPalindrome(int value) {
        int a = value % 10;
        int b = (value % 100) / 10;
        int c = (value % 1000) / 100;
        if (value/1000 == a*100 + b*10 + c)
            return true;
        return false;
    }
}
