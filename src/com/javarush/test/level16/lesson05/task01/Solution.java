package com.javarush.test.level16.lesson05.task01;

import java.util.ArrayList;
import java.util.List;

/* join
Подумайте, в каком месте и для какого объекта нужно вызвать метод join,
 чтобы результат выводился по-порядку
сначала для firstThread, а потом для secondThread.
Вызовите метод join в нужном месте.
Пример вывода:
firstThread : MyString 1
firstThread : MyString 2
...
firstThread : MyString 19
firstThread : MyString 20
secondThread : MyString 1
...
secondThread : MyString 20
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        PrintListThread firstThread = new PrintListThread("firstThread");
        PrintListThread secondThread = new PrintListThread("secondThread");
        firstThread.start();
        firstThread.join();
        secondThread.start();
    }

    public static class PrintListThread extends Thread {
        public PrintListThread(String name) {
            super(name);
        }

        public void run() {
            printList(getList(20), getName());
        }
    }

    public static void printList(List<String> list, String threadName) {
        for (String item : list) {
            System.out.println(String.format("%s : %s", threadName, item));
        }
    }

    public static List<String> getList(int n) {
        List<String> result = new ArrayList<String>();
        if (n < 1) return result;

        for (int i = 0; i < n; i++) {
            result.add(String.format("MyString %d", (i + 1)));
        }
        return result;
    }
}
