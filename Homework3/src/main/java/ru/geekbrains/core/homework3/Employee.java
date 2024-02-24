package ru.geekbrains.core.homework3;


public abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surName;
    protected int age;
    protected double salary;

    public Employee(String name, String surName, int age, int salary) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(Employee o) {
        int surNameRes = surName.compareTo(o.surName);
        if (surNameRes == 0) {
            return name.compareTo(o.name);
        }
        return surNameRes;
    }

    public abstract double calculateSalary();
}
