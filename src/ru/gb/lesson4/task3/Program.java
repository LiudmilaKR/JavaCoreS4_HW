package ru.gb.lesson4.task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Program {
    /**
     * Не знаю, что пыталась тут изобразить... :)
     */

    public static void main(String[] args) {

    }
    public static void loadFile() {
        Map<String, Integer> map = new HashMap<>();
        try (FileReader fileReader = new FileReader("name.txt")){
            char[] buf = new char[256];
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
                map.put(rec[0], Integer.parseInt(rec[1]));
            }
//            fileReader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}
