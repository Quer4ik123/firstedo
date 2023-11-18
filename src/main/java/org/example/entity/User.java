package org.example.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.enums.Role;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)

public class User {
    UUID uuid;
    String password;
    String name;
    Role role;
}
