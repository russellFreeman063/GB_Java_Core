package ru.geekbrains.core.homework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Program {

    private static final Random random = new Random();


    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            employees.add(generateEmployee());
        }
        employees.sort(new AgeComparator());
        System.out.println("Сортировка по возрасту:");
        printEmployees(employees);
        employees.sort(new SalaryComparator());
        System.out.println("\nСортировка по професcии и заработной плате:");
        printEmployees(employees);
    }

    public static Employee generateEmployee() {
        String[] names = new String[]{"Андрей", "Иван", "Кирилл", "Олег", "Сергей",
                "Владимир", "Константин", "Павел", "Роман", "Геннадий"};
        String[] surNames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов",
                "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов", "Букин"};
        int salaryHour = random.nextInt(100, 300);
        int salary = random.nextInt(30000, 60000);
        int age = random.nextInt(30, 50);

        if (random.nextBoolean()) {
            return new Freelancer(names[random.nextInt(names.length)],
                    surNames[random.nextInt(surNames.length)], age, salaryHour);
        } else {
            return new Worker(names[random.nextInt(names.length)],
                    surNames[random.nextInt(surNames.length)], age, salary);
        }
    }

    public static void printEmployees(List <Employee> employees) {
        for (Object worker : employees) {
            System.out.println(worker);
        }
    }
}
