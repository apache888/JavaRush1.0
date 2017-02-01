package com.javarush.test.level16.lesson13.bonus03;

/* Отдебажим все на свете
Разобраться, что делает програма.
Почитать про UncaughtExceptionHandler - это важно.
Еще раз внимательно посмотреть программу.
Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
Исправить ошибку, т.е. все должно работать. :)

Ожидаемый результат в произвольном порядке:
Нить 1: My exception message
Нить 2: My exception message
*/

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread.setDefaultUncaughtExceptionHandler(handler);
        //Класс TestedThread, который представляет собой поток, создаётся уже запущенным
        // (start() вызывается в конструкторе). Кроме того, в данном потоке установлен обработчик
        // необработанных исключений.
        //Т.о. переменная commonThread ссылается на уже запущенный поток.
        //При создании новых потоков threadA и threadB мы используем конструктор
        // public Thread(Runnable target, MyString name). В качестве первого параметра мы передаем
        // запущенный поток. Но фактически мы просто используем метод run() класса TestedThread.
        // При создании потоков threadA и threadB конструктор TestedThread не используется,
        // обработчики необработанных исключений для данных потоков не установлены
        // (имеется в виду вариант задачи по умолчанию).
        // Поэтому RuntimeException в последних двух потоках и не обрабатываются как мы того хотим.

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException x) {
                throw new RuntimeException("My exception message");

            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
