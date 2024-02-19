package ru.geekbrains.core.homework2.model.player;

import java.util.Random;

public class Bot extends Player{

    private static final String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    private static final Random random = new Random();
    private static final int typeId = 2;


    public Bot(int id, char dot) {
        super(id, dot, names[random.nextInt(names.length)], typeId);
    }


    @Override
    public String toString() {
        return getId() + " Бот " + getName();
    }
}
