package ru.geekbrains.core.homework2.model.player;

public class Human extends Player {
    private static final int typeId = 1;


    public Human(int id, char dot, String name) {
        super(id, dot, name, typeId);

    }


    @Override
    public String toString() {
        return getId() + " Игрок " + getName();
    }
}
