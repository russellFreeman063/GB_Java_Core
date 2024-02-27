package ru.geekbrains.core.homework4;

public class AccountService {

    private Account account = null;


    public void create(double startBalance) throws IllegalArgumentException {
        if (startBalance < 0) {
            throw new IllegalArgumentException("Нельзя создать счет с отрицательным начальным балансом: " + startBalance);
        }
        else {
            account = new Account(startBalance);
            System.out.println("Аккаунт успешно создан, начальный баланс: " + startBalance);
        }
    }

    public void deposit(double deposit) throws IllegalArgumentException {
        if (deposit < 0) {
            throw new IllegalArgumentException("Нельзя внести депозит с отрицательной суммой: " + deposit);
        }
        else {
            account.setBalance(account.getBalance() + deposit);
            System.out.println("Депозит успешно проведен, ваш баланс: " + account.getBalance());
        }
    }

    public void withdraw(double withdraw) throws IllegalArgumentException, InsufficientFundsException {
        if (withdraw < 0) {
            throw new IllegalArgumentException("Нельзя снять средства с отрицательной суммой: " + withdraw);
        }
        if (account.getBalance() < withdraw) {
            throw new InsufficientFundsException("Нельзя снять средства, сумма которых превышает текущий баланс: "
                    + account.getBalance() + " снятие: " + withdraw);
        }
        else {
            account.setBalance(account.getBalance() - withdraw);
            System.out.println("Снятие средств успешно проведен, ваш баланс: " + account.getBalance());
        }
    }

}
