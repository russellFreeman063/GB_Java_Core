package ru.geekbrains.core.homework2;

import ru.geekbrains.core.homework2.controller.GameController;


public class Program {
    private static final GameController game = new GameController();

    public static void main(String[] args) {

        game.start();

    }
}