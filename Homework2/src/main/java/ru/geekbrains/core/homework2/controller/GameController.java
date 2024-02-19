package ru.geekbrains.core.homework2.controller;

import ru.geekbrains.core.homework2.model.field.Field;
import ru.geekbrains.core.homework2.model.player.Bot;
import ru.geekbrains.core.homework2.model.player.Human;
import ru.geekbrains.core.homework2.model.player.Player;
import ru.geekbrains.core.homework2.view.GameView;

import java.util.Random;
import java.util.Scanner;


public class GameController {
    Player playerOne;
    Player playerTwo;
    Field field;
    int winState;
    GameView view = new GameView();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private int count = 0;

    public GameController() {
    }

    private void createField() {
        int x, y;
        while (true) {
            try {
                view.setSize();
                x = scanner.nextInt();
                y = scanner.nextInt();
                if (x >= 3 && y >= 3 && x <= 9 && y <= 9) {
                    field = new Field(x, y);
                    field.setFieldSizeX(x);
                    field.setFieldSizeY(y);
                    break;
                } else {
                    view.error(1);
                }
            } catch (Exception e) {
                view.error(1);
                scanner.next();
            }
        }
    }


    private Player createPlayer(int id) {
        boolean playerCreated = false;
        char dot;
        if (id == 1) dot = 'X';
        else dot = '0';
        while (!playerCreated) {
            try {
                view.setPlayer(id);
                int playerId = scanner.nextInt();
                if (playerId == 1) {
                    view.setPlayer(3);
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    playerCreated = true;
                    return new Human(id, dot, name);
                }
                if (playerId == 2) {
                    playerCreated = true;
                    return new Bot(id, dot);
                }
            } catch (Exception e) {
                view.error(1);
                scanner.next();
            }
        }
        return null;
    }


    private void setWinState() {
        if (field.getFieldSizeX() == 3 || field.getFieldSizeY() == 3) {
            winState = 3;
        }
        else {
            boolean isSet = false;
            while (!isSet) {
                try {
                    int num = 3;
                    view.winState(1, num);
                    num = scanner.nextInt();
                    if (num > field.getFieldSizeX() || num > field.getFieldSizeY()) {
                        view.error(2);
                    } else if (num < 3) {
                        view.error(3);
                        scanner.nextLine();
                    } else {
                        winState = num;
                        view.winState(3, num);
                        isSet = true;
                    }
                } catch (Exception e) {
                    view.error(1);
                    scanner.next();
                }
            }
        }
    }


    private void move(Player player) {
        if (player.getTypeId() == 1) {
            while (true) {
                try {
                    int x, y;
                    do {
                        view.playerMove(player.getName());
                        x = scanner.nextInt() - 1;
                        y = scanner.nextInt() - 1;
                    }
                    while (!isCellValid(x, y, player.getTypeId()) || !isCellEmpty(x, y, player.getTypeId()));
                    field.getField()[x][y] = player.getDot();
                    count++;
                    view.move(count, player.getId(), player.getName(), x, y);
                    view.printField(field.getField());
                    break;
                } catch (Exception e) {
                    view.error(1);
                    view.printField(field.getField());
                    scanner.nextLine();
                }
            }
        }
        else {
            moveBot(player);
        }
    }


    private void moveBot(Player player) {
        int x, y;
        do{
            x = random.nextInt(field.getFieldSizeX());
            y = random.nextInt(field.getFieldSizeY());
        }
        while (!isCellEmpty(x, y, player.getTypeId()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        field.getField()[x][y] = player.getDot();
        count++;
        view.move(count, player.getId() ,player.getName(), x, y);
        view.printField(field.getField());
    }


    private boolean isCellValid(int x, int y, int id) {
        if (id == 1 && x > field.getFieldSizeX() || y > field.getFieldSizeY() || x < 0 || y < 0)  {
            view.error(4);
            view.printField(field.getField());
        }
        return x >= 0 && x < field.getFieldSizeX() && y >= 0 && y < field.getFieldSizeY();
    }


    private boolean isCellEmpty(int x, int y, int id) {
        if (id == 1 && field.getField()[x][y] != field.getDotEmpty()) {
            view.error(5);
            view.printField(field.getField());
            return field.getField()[x][y] == field.getDotEmpty();
        }
        return field.getField()[x][y] == field.getDotEmpty();
    }


    private boolean checkWin(char dot) {
        for (int x = 0; x < field.getFieldSizeX(); x++) {
            for (int y = 0; y < field.getFieldSizeY(); y++) {
                if (field.getField()[x][y] == dot) {
                    if (checkRight(x, y, dot)) return true;
                    if (checkDown(x, y, dot)) return true;
                    if (checkDiagonalDown(x, y, dot)) return true;
                    if (checkDiagonalUp(x, y, dot)) return true;
                }
            }
        }
        return false;
    }


    private boolean checkRight(int x, int y, char dot) {
        int win = 0;
        for (; y < field.getFieldSizeY(); y++) {
            if (field.getField()[x][y] == dot) {
                win++;
                if (win == winState) {
                    return true;
                }
            }
            else return false;
        }
        return false;
    }


    private boolean checkDown(int x, int y, char dot) {
        int win = 0;
        for (; x < field.getFieldSizeX(); x++) {
            if (field.getField()[x][y] == dot) {
                win++;
                if (win == winState) return true;
            }
            else return false;
        }
        return false;
    }


    private boolean checkDiagonalDown(int x, int y, char dot) {
        int win = 0;
        for (; x < field.getFieldSizeX() && y < field.getFieldSizeY(); x++, y++) {
                if (field.getField()[x][y] == dot) {
                    win++;
                    if (win == winState) return true;
                }
                else return false;
        }
        return false;
    }


    private boolean checkDiagonalUp(int x, int y, char dot) {
        int win = 0;
        for (;x >= 0 && y < field.getFieldSizeY(); x--, y++) {
            if (field.getField()[x][y] == dot) {
                win++;
                if (win == winState) return true;
            }
            else return false;
        }
        return false;
    }


    private boolean checkDraw() {
        for (int x = 0; x < field.getFieldSizeX(); x++) {
            for (int y = 0; y < field.getFieldSizeY(); y++) {
                if (isCellEmpty(x, y, 0)) return false;
            }
        }
        return true;
    }


    private boolean checkState(Player player) {
        if (checkWin(player.getDot())) {
            view.win(player.getName());
            return true;
        }
        else if (checkDraw()) {
            view.draw();
            return true;
        }
        return false;
    }


    public void start() {
        do {
            createField();
            playerOne = createPlayer(1);
            playerTwo = createPlayer(2);
            setWinState();
            view.printField(field.getField());
            while (true) {
                move(playerOne);
                if (checkState(playerOne)) break;
                move(playerTwo);
                if (checkState(playerTwo)) break;
            }
            view.repeat();
        } while (scanner.next().equalsIgnoreCase("Y"));
    }
}
