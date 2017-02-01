package com.javarush.test.level29.lesson05.task02;

/* Особенности автобоксинга
Исправьте ошибку в методе getValueByIndex.
Читайте доп. статью про особенности автобоксинга.
*/
public class Solution {
    private Integer[] array = new Integer[]{1, 2, 3, 4};

    Number getValueByIndex(int index) {
        Number result;
        if (index >= 0 && index < array.length){
            result = array[index];
        }else result = new Double(-1);

        return result;

//        return (index >= 0 && index < array.length) ? new Integer(array[index]) : new Double(-1);

//        Так как тернарный оператор может быть частью сложного выражения, его результатом должен быть
// конкретный тип, определённый на этапе компиляции. Поэтому, скажем, при истинном условии в
// if-форме компилятор приводит valTrue сразу к типу Type, а в форме тернарного оператора сперва
// приводит к общему типу valTrue и valFalse (несмотря на то, что valFalse не вычисляется),
// а затем уже результат приводит к типу Type. Правила приведения оказываются не совсем тривиальными,
// если в выражении участвуют примитивные типы и обёртки над ними (Integer, Double и т. д.)
    }

    public static void main(String[] args) {
        Number value1 = new Solution().getValueByIndex(5); //-1.0, class java.lang.Double expected
        Number value2 = new Solution().getValueByIndex(2); //3, class java.lang.Integer expected

        System.out.println(value1 + ", " + value1.getClass().toString());
        System.out.println(value2 + ", " + value2.getClass().toString());
    }
}
