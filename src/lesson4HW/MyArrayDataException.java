package lesson4HW;

public class MyArrayDataException extends Exception {
    String element;
    int numStr;
    int numCol;
    public MyArrayDataException(String message, String element, int numStr, int numCol) {
        super(message);
        this.element = element;
        this.numStr = numStr;
        this.numCol = numCol;
    }
}
