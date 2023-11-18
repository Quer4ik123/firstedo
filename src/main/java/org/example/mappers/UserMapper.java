package org.example.mappers;

import org.example.entity.User;
import org.example.enums.Role;

import java.util.UUID;

public class UserMapper {
    public static User convertStringToUser(String string) {
        String[] split = string.split(",");
        if (split.length != 4) {
            throw new IllegalArgumentException("неверное кол-во данных");
        }
        //uuid,name,password,role
        return User.builder()
                .uuid(UUID.fromString(split[0]))
                .name(split[1])
                .password(split[2])
                .role(Role.valueOf(split[3]))
                .build();
    }
}
