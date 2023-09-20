package lesson4HW;

import java.util.Random;

public class Program {
    /**
     * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в
     * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
     * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     * 3 В методе main() вызвать полученный метод, обработать возможные исключения
     * MyArraySizeException и MyArrayDataException и вывести результат расчета.
     */
    private static Random random = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.printf("Создание массива %d =>\n", i);
            String[][] mas = createArray();
            try {
                checkSizeArray(mas);
                checkDataArray(mas);
            } catch (MyArraySizeException e) {
                System.out.printf("Ошибка при создании массива => %s", e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.printf("Ошибка в данных => %s Элемент '%s' на позиции [%d][%d] не число!",
                        e.getMessage(), e.element, e.numStr, e.numCol);
            } finally {
                System.out.println();
            }
        }
    }
    /**
     * Проверка данных массива
     * @param array двумерный строковый массив
     * @throws MyArrayDataException исключения, если в каком-то элементе массива преобразование в int не удалось
     */
    private static void checkDataArray(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (Character.isDigit(array[i][j].charAt(0))) sum += Integer.parseInt(array[i][j]);
                else throw new MyArrayDataException("Массив не числовой!", array[i][j], i, j);
            }
        }
        System.out.println("Сумма элементов массива равна " + sum);
    }
    /**
     * Проверка размерности массива
     * @param array двумерный строковый массив
     * @throws MyArraySizeException исключение, если размерность массива не 4x4
     */
    private static void checkSizeArray(String[][] array) throws MyArraySizeException {
        if (array.length == 4 && array[0].length == 4) printArray(array);
        else throw new MyArraySizeException("Размер массива не 4x4!");
    }

    /**
     * Создание строкового двумерного массива символов
     * @return двумерный строковый массив
     */
    private static String[][] createArray() {
        int m = random.nextInt(3,5);
        int n = random.nextInt(3,5);
        String[][] array = new String[m][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Character.toString(random.nextInt(47,58));
            }
        }
        return  array;
    }

    /**
     * Печать двумерного массива
     * @param array двумерный строковый массив
     */
    private static void printArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
