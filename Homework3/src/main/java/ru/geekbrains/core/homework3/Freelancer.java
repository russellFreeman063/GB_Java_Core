package ru.geekbrains.core.homework3;

public class Freelancer extends Employee {

    public Freelancer(String name, String surName, int age, int salary) {
        super(name, surName, age, salary);
        this.salary = calculateSalary();
    }

    @Override
    public double calculateSalary() {
        return 20.8 * 8 * salary;
    }

    public String toString() {
        return String.format("%s %s; Фрилансер, cреднемесячная заработная плата: %.2f; Возраст %d",
                surName, name, salary, age);
    }
}
