package ru.gb.lesson4.task1;

public class AnimalSwimExeption extends AnimalActionException{
    public AnimalSwimExeption(String message, String name, int distance) {
        super(message, name, distance);
    }
}
