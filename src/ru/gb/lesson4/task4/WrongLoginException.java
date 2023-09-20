package ru.gb.lesson4.task4;

public class WrongLoginException extends RuntimeException {
    private int currentLength;
    public WrongLoginException(int currentLength) {
        super();
        this.currentLength = currentLength;
    }

    @Override
    public String getMessage() {
//        return super.getMessage();
        return String.format("Your login is of incorrect length, expected < 20, given %d.", currentLength);
    }
}
