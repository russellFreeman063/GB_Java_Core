package ru.geekbrains.core.lesson1.task1;

import ru.geekbrains.core.lesson1.services.Calculator;
import ru.geekbrains.core.lesson1.utils.Decorator;

/*

javac -sourcepath ./java -d out java/ru/geekbrains/core/lesson1/task1/Program.java
java -classpath ./out ru.geekbrains.core.lesson1.task1.Program
javadoc -encoding utf8 -d docs -sourcepath ./java -cp ./out -subpackages ru

https://www.docker.com/products/docker-desktop/
https://hub.docker.com/
 */

/**
 * Основной класс приложения. Здесь мы можем описать
 * его основное назначение и способы взаимодействия с ним.
 */
public class Program {


    public static void main(String[] args) {

        int result = Calculator.add(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calculator.sub(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calculator.mul(2, 2);
        System.out.println(Decorator.decorate(result));
        result = Calculator.div(2, 2);
        System.out.println(Decorator.decorate(result));
    }

}
