package net.brobank.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @Column
    @Size(max = 255)
    String title;

    @Column
    @Size(max = 65535)
    String unread;

    @Column
    @Size(max = 255)
    @NotNull
    String username;

    @Column
    @Size(max = 255)
    @NotNull
    String encryptedPassword;

    @Column
    @Size(max = 255)
    String email;

    @Column
    @Size(max = 255)
    String token;

    @Column
    @NotNull
    Timestamp created;

    @Column
    @NotNull
    Timestamp lastUpdate;
}
