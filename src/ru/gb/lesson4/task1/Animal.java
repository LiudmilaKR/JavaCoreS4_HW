package ru.gb.lesson4.task1;

public abstract class Animal {
    protected String name;
    public String getName() {
        return  name;
    }
    /**
     * Создает новое животного
     * @param name имя животного
     * @throws AnimalNameException некорректное имя животного
     * пробрасываем исключение для обработки его выше (другими людьми)
     */
    public Animal(String name) throws AnimalNameException {
        if (name == null || name.length() < 3) {
            throw new AnimalNameException ("Имя животного указано некорректно!", name);
            //RuntimeException не является проверяемым для компилятора
//            this.name = "Animal";
        }
        this.name = name;
    }
    public abstract void swim(int distance) throws AnimalSwimExeption;
    public abstract void run(int distance) throws AnimalRunExeption;

    /*
    * когда создаем собственные исключения, можем добавлять свои параметры*/
}
