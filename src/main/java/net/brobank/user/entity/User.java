package net.brobank.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "User")
@NamedQueries(
        @NamedQuery(name=User.FIND_ALL, query="select u from User u")
)
public class User {

    public static final String FIND_ALL = "findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    OffsetDateTime created;

    @Column
    @NotNull
    OffsetDateTime lastUpdate;
}
