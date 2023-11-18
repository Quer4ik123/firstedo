package org.example.entity;

import org.example.mappers.UserMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private final String basePath = "C:/Users/r2d2/IdeaProjects/edo/src/main/resources/files";

    public void createDoc(String title) throws IOException {
        var doc = Path.of(basePath + title + ".csv").toFile();
        if (doc.exists()) {
            throw new FileAlreadyExistsException("Файл уже существует");
        } doc.createNewFile();
    }
    public List<User> readUsers(String filename) {
        List<User> res = new ArrayList<>();
        String line;
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            br.readLine();
            while ((line = br.readLine()) != null) {
                res.add(UserMapper.convertStringToUser(line));
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException("Файл не существует, либо ошибка чтения", e);
        }
        return res;
    }


}
