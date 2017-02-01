package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream,
 в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(random.nextInt(10) + 48);
        }
        for (int i = 0; i < 2; i++) {
            list.add(random.nextInt(26) + 65);
        }
        for (int i = 0; i < 2; i++) {
            list.add(random.nextInt(26) + 97);
        }
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            baos.write(list.get(i));
        }

        return baos;
    }
}
