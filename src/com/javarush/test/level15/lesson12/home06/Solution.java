package com.javarush.test.level15.lesson12.home06;

/* Порядок загрузки переменных
Разобраться, что в какой последовательности инициализируется.
Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
non-static block
static void printAllFields
0
null
Solution2 constructor
static void printAllFields
6
First name
*/

public class Solution {
    static {
        init();
    }
    static {
        System.out.println("Static block");
    }
    public static int i;
    public static String name;
    public static void main(String[] args) {
        System.out.println("public static void main");
        {
            System.out.println("non-static block");

        }
        Solution s = null;
        printAllFields(s);
        i = 6;
        name = "First name";
        s = new Solution();


    }

    public Solution() {
        System.out.println("Solution2 constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);
    }
}
