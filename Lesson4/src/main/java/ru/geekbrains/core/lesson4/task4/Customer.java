package ru.geekbrains.core.lesson4.task4;

/**
 * "Покупатель"
 */
public class Customer {

    String name;
    int age;
    String phone;

    public Customer(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[" +
                "Имя: '" + name + '\'' +
                ", Возраст: " + age +
                ", Телефон: '" + phone + '\'' +
                ']';
    }


}
