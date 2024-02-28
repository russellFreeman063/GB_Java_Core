package ru.geekbrains.core.homework5;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {

        BackupDirectory backup = new BackupDirectory();

        String userDirectory = ".";
        String backupDirectory = "./backup";

        try {
            backup.create(userDirectory, backupDirectory);
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка при создании резервной копии: " + e.getMessage());
        }

    }
}
