package ru.geekbrains.core.homework2.model.player;

public class Player {
    private int id;
    private char dot;
    private String name;
    private final int typeId;


    public Player(int id, char dot, String name, int typeId) {
        this.id = id;
        this.dot = dot;
        this.name = name;
        this.typeId = typeId;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public char getDot() {
        return dot;
    }


    public void setDot(char dot) {
        this.dot = dot;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getTypeId() {
        return typeId;
    }


    @Override
    public String toString() {
        return "Player " + id + " " + name + " Dot: " + dot;
    }
}
