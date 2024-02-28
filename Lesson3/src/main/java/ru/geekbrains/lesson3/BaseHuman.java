package ru.geekbrains.lesson3;

public abstract class BaseHuman {

    protected String name;

    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        updateName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        updateAge(age);
    }

    private BaseHuman(){
        this("name", 18);
    }


    private BaseHuman(int age){
        this("name", age);
    }

    private BaseHuman(String name){
        this(name, 18);
    }

    protected BaseHuman(String name, int age){
        this.name = name;
        this.age = age;
    }

    private void updateAge(int age) {
        if (age < 18){
            throw new RuntimeException("Некорректный возраст человека.");
        }
        this.age = age;
    }

    private void updateName(String name) {
        if (name == null || name.length() < 3){
            throw new RuntimeException("Некорректное имя человека.");
        }
        this.name = name;
    }

    public abstract void printInfo();



    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
