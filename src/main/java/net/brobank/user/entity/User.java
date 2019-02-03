package net.brobank.user.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class User {
    String username;
    String password;
}
