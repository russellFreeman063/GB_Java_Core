package ru.geekbrains.core.homework3;

import java.util.Comparator;
public class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee1, Employee employee2) {
        int age1 = employee1.getAge();
        int age2 = employee2.getAge();
        return Integer.compare(age1, age2);
    }
}
