package ru.gb.lesson4.task1;

public class AnimalNameException extends Exception {
    private String name;
    public String getName() {
        return name;
    }

    public AnimalNameException(String message, String name) {
        super(message);
        this.name = name;
    }
}
