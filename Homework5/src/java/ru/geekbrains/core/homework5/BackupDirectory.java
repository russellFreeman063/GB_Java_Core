package ru.geekbrains.core.homework5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class BackupDirectory {

    private File backupDir;

    public void create(String userDirectory, String backupDirectory) throws IOException {

        File userDir = new File(userDirectory);
        backupDir = new File(backupDirectory);

        if (userDir.exists()) {
            if (!backupDir.exists()) {
                backupDir.mkdir();
            }
            String date = new SimpleDateFormat("yy.MM.dd HH.mm.ss").format(new Date());
            File dateDir = new File(backupDir, date);

            backup(userDir, dateDir);
        }
        else throw new IOException("Директория не существует: " + userDir);

    }

    public void backup(File userDir, File backupDir) throws IOException {

        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        for (String f : Objects.requireNonNull(userDir.list())) {
            directoryCopy(new File(userDir, f), new File(backupDir, f));
        }

    }

    public void directoryCopy(File userDir, File backupDir) throws IOException {

        if (!userDir.getPath().equals(this.backupDir.getPath())) {
            if (userDir.isDirectory()) {
                backup(userDir, backupDir);
            } else {
                fileCopy(userDir, backupDir);
            }
        }

    }

    private void fileCopy(File userDir, File backupDir) throws IOException {

        try (InputStream in = new FileInputStream(userDir);
             OutputStream out = new FileOutputStream(backupDir)) {
            byte[] buf = new byte[1024];
            int length;
            while ((length = in.read(buf)) > 0) {
                out.write(buf, 0, length);
            }
        }
    }

}


