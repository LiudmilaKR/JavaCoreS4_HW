package ru.gb.lesson4.task1;

public class AnimalRunExeption extends AnimalActionException{
    public AnimalRunExeption(String message, String name, int distance) {
        super(message, name, distance);
    }
}
