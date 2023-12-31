package ru.gb.lesson4.task2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//import java.util.Random;
// 1-07-28
public class Program {
    /**
     * Запишите в файл следующие строки:
     * <p>
     * Анна=4
     * Елена=5
     * Марина=6
     * Владимир=?
     * Константин=?
     * Иван=4
     * <p>
     * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
     * студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
     * значение ?, заменить его на соответствующее число. Если на каком-то месте встречается символ, отличный от
     * числа или ?, бросить подходящее исключение.
     */
//    private static final Random rand = new Random();
    public static void main(String[] args) {
        prepareFile();
        loadFile();
    }
    /**
    private static void doProcess() throws Exception {
        if (rand.nextInt(2) == 0) throw new Exception("ERROR!");
    }*/
    private static void prepareFile() {
//        FileWriter fileWriter = null;
//        try-with-resources работает только с closeable классами
        try (FileWriter fileWriter = new FileWriter("name.txt", false)){
//            fileWriter = new FileWriter("name.txt", false);
            fileWriter.write("Anna=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");
//            doProcess();
            fileWriter.write("Владимир=?\n");
            fileWriter.write("Константин=?\n");
            fileWriter.write("Иван=4\n");
            fileWriter.flush();
            // используется, чтобы принудительно записать в целевой поток данные,
            // которые могут кэшироваться в текущем потоке. Актуально при использовании буферизации
            // и/или нескольких объектах потоков, организованных в цепочку.
//            fileWriter.close();
        } catch (IOException e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        /*catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }*/
    }
    private static int parseInt(String key, String value) throws IncorrectSymbolException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            if (!value.equals("?")) throw new IncorrectSymbolException("Некорректный символ");
            return key.length();
        }
    }
    private static void loadFile() {
        Map<String, Integer> map = new HashMap<>();
        try (FileReader fileReader = new FileReader("name.txt")) {
            char[] buf = new char[256]; //считываем символы в буфер блоками
            int c;
            StringBuilder stringBuilder = new StringBuilder();
            while ((c = fileReader.read(buf)) > 0) {
                for (int i = 0; i < c; i++) {
                    stringBuilder.append(buf[i]);
                }
            }
            String[] parts = stringBuilder.toString().split("\n");
            for (String part : parts) {
                String[] rec = part.split("=");
                map.put(rec[0], parseInt(rec[0], rec[1]));
            }
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                System.out.printf("%s = %d\n", e.getKey(), e.getValue());
            }
//            fileReader.read();
//        } catch (IncorrectSymbolException e) {
//            e.printStackTrace();
        } catch (IncorrectSymbolException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class IncorrectSymbolException extends Exception {
    public IncorrectSymbolException(String message) {
        super(message);
    }
}
