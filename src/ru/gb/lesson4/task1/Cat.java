package ru.gb.lesson4.task1;

public class Cat extends Animal {
    /**
     * Создает новое животное
     * @param name имя животного
     * @throws AnimalNameException
     * наследник вызывает конструктор базового типа, поэтому здесь, тажке, исключения
     */
    public Cat(String name) throws AnimalNameException {
        super(name);
    }

    @Override
    public void swim(int distance) throws AnimalSwimExeption {
        throw new AnimalSwimExeption("Кот не умеет плавать", name, distance);
    }

    @Override
    public void run(int distance) throws AnimalRunExeption {
        if (distance < 50) {
            //TODO: Выполнение дальнейших инструкций
        } else {
            throw new AnimalRunExeption("Кот не умеет далеко бегать", name, distance);
        }
    }
}
