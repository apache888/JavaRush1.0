package com.javarush.test.level33.lesson10.home01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/* Создание класса по строке xml
Восстановите класс по переданной строке xml.
Класс должен быть в отдельном файле.
Метод getClassName должен возвращать восстановленный класс.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws JAXBException {
        String xmlData =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<shop>\n" +
                        "    <goods>\n" +
                        "        <names>S1</names>\n" +
                        "        <names>S2</names>\n" +
                        "    </goods>\n" +
                        "    <count>12</count>\n" +
                        "    <profit>123.4</profit>\n" +
                        "    <secretData>String1</secretData>\n" +
                        "    <secretData>String2</secretData>\n" +
                        "    <secretData>String3</secretData>\n" +
                        "    <secretData>String4</secretData>\n" +
                        "    <secretData>String5</secretData>\n" +
                        "</shop>";

        StringReader reader = new StringReader(xmlData);

        JAXBContext context = JAXBContext.newInstance(getClassName());
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Object o = unmarshaller.unmarshal(reader);

        System.out.println(o.toString());

        //проверка Shop to xml
//        Shop shop = new Shop();
//        shop.names.add("S1");
//        shop.names.add("S2");
//        shop.count = 21;
//        shop.profit = 234.5;
//        shop.secretData.add("secret1");
//        shop.secretData.add("secret2");
//        shop.secretData.add("secret3");
//        shop.secretData.add("secret4");
//        StringWriter writer = new StringWriter();
//        String result;
////        BufferedWriter bufferedWriter = null;
////        try {
////            bufferedWriter = new BufferedWriter(new FileWriter("G:\\IdeaProjects\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level33\\lesson10\\home01\\shop.xml"));
////        }
////        catch (IOException e) {
////            e.printStackTrace();
////        }
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.marshal(shop, writer);
//        result = writer.toString();
//        BufferedReader bufferedReader = new BufferedReader(new StringReader(result));
//        try {
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("G:\\IdeaProjects\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level33\\lesson10\\home01\\shop.xml"));
//            while (bufferedReader.ready()) {
//                bufferedWriter.write(bufferedReader.readLine());
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static Class getClassName() {
        return Shop.class;  //your class name
    }
}
