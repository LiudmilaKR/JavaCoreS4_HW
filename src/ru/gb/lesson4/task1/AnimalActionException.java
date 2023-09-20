package ru.gb.lesson4.task1;

public abstract class AnimalActionException extends AnimalNameException {
//    наследуем от AnimalNameException, чтобы у животного было имя
    private final int distance;

    public int getDistance() {
        return distance;
    }

    public AnimalActionException(String message, String name, int distance) {
        super(message, name);
        this.distance = distance;
    }
}
