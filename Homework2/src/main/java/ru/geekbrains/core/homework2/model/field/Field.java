package ru.geekbrains.core.homework2.model.field;

public class Field {
    private static char[][] field;
    private static final char DOT_EMPTY = '*';
    private static int fieldSizeX;
    private static int fieldSizeY;


    public Field(int fieldSizeX, int fieldSizeY) {
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }


    public char[][] getField() {
        return field;
    }


    public void setField(char[][] field) {
        Field.field = field;
    }


    public char getDotEmpty() {
        return DOT_EMPTY;
    }


    public int getFieldSizeX() {
        return fieldSizeX;
    }


    public void setFieldSizeX(int fieldSizeX) {
        Field.fieldSizeX = fieldSizeX;
    }


    public int getFieldSizeY() {
        return fieldSizeY;
    }


    public void setFieldSizeY(int fieldSizeY) {
        Field.fieldSizeY = fieldSizeY;
    }
}
