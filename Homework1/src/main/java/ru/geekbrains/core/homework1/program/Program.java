package ru.geekbrains.core.homework1.program;

import ru.geekbrains.core.homework1.services.Calc;
import ru.geekbrains.core.homework1.utils.Decorator;

public class Program {
    public static void main(String[] args) {

        int result = Calc.plus(5, 5);
        System.out.println(Decorator.decorate(result));
        result = Calc.minus(30, 10);
        System.out.println(Decorator.decorate(result));
        result = Calc.multiply(10, 3);
        System.out.println(Decorator.decorate(result));
        result = Calc.divide(80, 2);
        System.out.println(Decorator.decorate(result));

    }
}
