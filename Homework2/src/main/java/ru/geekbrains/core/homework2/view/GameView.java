package ru.geekbrains.core.homework2.view;

public class GameView {

    public GameView() {
    }


    public void printField(char[][] field){
        System.out.print("+");
        for (int i = 0; i < field[0].length; i++){
            System.out.print(" " + (i + 1));
        }
        System.out.println(" ");

        for (int x = 0; x < field[0].length; x++){
            System.out.print(x + 1 + "|");
            for (int y = 0; y < field[1].length; y++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < field[0].length * 2 + 2; i++){
            System.out.print("^");
        }
        System.out.println();
    }


    public void setSize() {
        System.out.println("Через пробел введите ширину и " +
                "высоту игрового поля (от 3 до 9): ");
    }


    public void error(int id) {
        if (id == 1) System.out.println("Неправильно введенные данные");
        if (id == 2) System.out.println("Введенно слишком большое число (больше чем одна из сторон)");
        if (id == 3) System.out.println("Введенно слишком маленькое число (меньше чем 3)");
        if (id == 4) System.out.println("Неправильно введенные координаты ");
        if (id == 5) System.out.println("Данные координаты уже заняты");
    }


    public void setPlayer(int playerId) {
        if (playerId == 1) System.out.println("Выберите первого игрока: 1 = Человек, 2 = Бот");
        if (playerId == 2) System.out.println("Выберите второго игрока: 1 = Человек, 2 = Бот");
        if (playerId == 3) System.out.println("Введите имя игрока");
    }


    public void winState(int id, int num) {
        if (id == 1) System.out.println("Введите количество фишек для победы (по умолчанию 3)");
        if (id == 2) System.out.println("Введенно слишком большое число (больше чем одна из сторон)");
        if (id == 3) System.out.println("Количество фишек для победы: " + num);
    }


    public void playerMove(String name) {
        System.out.println("Игрок " + name + " введите координаты хода X и Y через пробел");
    }


    public void move(int count, int id, String name, int x, int y) {
        System.out.println("Ход № " + count + " Игрок " + id + " "
                + name + " ходит по координатам " + ++x + ", " + ++y );
    }


    public void win(String name) {
        System.out.println("Игрок " + name + " победил");
    }


    public void draw() {
        System.out.println("Ничья");
    }


    public void repeat() {
        System.out.println("Желаете сыграть еще раз? (Y - да): ");
    }
}

