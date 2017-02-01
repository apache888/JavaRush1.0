package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(MyString), пол(boolean),возраст(int), отец(Human), мать(Human).
 Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
 Вывести объекты на экран.
Примечание:
Если написать свой метод MyString toString() в классе Human, то именно он будет использоваться
при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        /*Human grandpaF = Human.input();
        Human grandpaM = Human.input();
        Human grandmaF = Human.input();
        Human grandmaM = Human.input();
        Human papa = Human.inputExt(grandpaF, grandmaF);
        Human mama = Human.inputExt(grandpaM, grandmaM);
        Human son1 = Human.inputExt(papa, mama);
        Human son2 = Human.inputExt(papa, mama);
        Human son3 = Human.inputExt(papa, mama);*/
        Human grandpaF = new Human("dedF", true, 90);
        Human grandpaM = new Human("dedM", true, 85);
        Human grandmaF = new Human("granF", false, 85);
        Human grandmaM = new Human("granM", false, 80);
        Human papa = new Human("papa", true, 56, grandpaF, grandmaF);
        Human mama = new Human("mama", false, 50, grandpaM, grandmaM);
        Human son1 = new Human("son1", true, 30, papa, mama);
        Human son2 = new Human("son2", true, 20, papa, mama);
        Human son3 = new Human("son3", true, 15, papa, mama);

        System.out.println(grandpaF);
        System.out.println(grandpaM);
        System.out.println(grandmaF);
        System.out.println(grandmaM);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);
    }

    public static class Human
    {
        private  String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }

       /* public static Human input() throws IOException{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("name");
            MyString name = reader.readLine();
            System.out.println("sex (male/female)");
            MyString sexStr = reader.readLine();
            boolean sex;
            if (sexStr.equals("male")) {
                sex = true;
            }else sex = false;
            System.out.println("age");
            int age = Integer.parseInt(reader.readLine());

            return new Human(name, sex, age);
        }
        public static Human inputExt(Human father, Human mother) throws IOException{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("name");
            MyString name = reader.readLine();
            System.out.println("sex (male/female)");
            MyString sexStr = reader.readLine();
            boolean sex;
            if (sexStr.equals("male")) {
                sex = true;
            }else sex = false;
            System.out.println("age");
            int age = Integer.parseInt(reader.readLine());

            return new Human(name, sex, age, father, mother);
        }*/
    }

}
