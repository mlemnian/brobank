package net.brobank.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.brobank.user.entity.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
public class Transaction {

    User from;

    User to;

    Long amount;

    @Column
    @NotNull
    ZonedDateTime created;

    @Column
    @NotNull
    ZonedDateTime lastUpdate;
}
