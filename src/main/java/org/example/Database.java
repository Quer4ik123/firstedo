package org.example;

import org.example.entity.User;
import org.example.mappers.UserMapper;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private String basePath = "C:/Users/r2d2/IdeaProjects/edo/src/main/resources/files";

    public void createTable(String title, String... columns) throws IOException {
        var table = Path.of(basePath + title + ".txt").toFile();

        String firstRow = String.join(",", columns);

        if (table.exists()) throw new FileAlreadyExistsException("Такой файл уже есть");
        table.createNewFile();

        insertIntoTable(title, firstRow);
    }

    public void insertIntoTable(String table, String data) {
        try {

            FileOutputStream fileOut = new FileOutputStream(Path.of(basePath, table + ".csv").toString());
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(data);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
