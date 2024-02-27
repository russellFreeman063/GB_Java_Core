package ru.geekbrains.core.homework4;


public class Program {

    public static void main(String[] args) {

        AccountService account = new AccountService();
        try {
            account.create(-200000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.create(200000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.deposit(-100000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.deposit(100000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.withdraw(-100000);
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        try {
            account.withdraw(150000);
        } catch (IllegalArgumentException | InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

    }

}
