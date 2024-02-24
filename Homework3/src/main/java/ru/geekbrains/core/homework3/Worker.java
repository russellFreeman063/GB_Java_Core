package ru.geekbrains.core.homework3;

public class Worker extends Employee {

    public Worker(String name, String surName, int age, int salary) {
        super(name, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    public String toString() {
        return String.format("%s %s; Рабочий, cреднемесячная заработная плата: %.2f; Возраст %d",
                surName, name, salary, age);
    }
}
