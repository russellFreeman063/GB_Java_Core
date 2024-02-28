package ru.geekbrains.core.lesson4.task1;

public class Program {

    /**
     Задача 1
     ========
     1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     3. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
     MyArrayDataException и вывести результат расчета.
     */

    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();
        for (int i = 0; i < 10; i++){
            System.out.printf("\n***** Итерация #%d *****\n", i + 1);
            processArray(arrayUtils);
        }
    }
    static void processArray(ArrayUtils arrayUtils){
        try {
            System.out.printf("Сумма всех элементов массива: %d\n", arrayUtils.processArray(arrayUtils.generateArray()));
        }
        catch (MyArrayDataException e){
            System.out.printf("%s по индексу [%d][%d]\n", e.getMessage(), e.getX(), e.getY());

        }
        catch (MyArraySizeException e){
            System.out.printf("%s Требовалось 4x4, получили %dx%d\n", e.getMessage(), e.getX(), e.getY());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
