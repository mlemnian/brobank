package net.brobank.transaction.entity;

import lombok.Data;
import net.brobank.user.entity.User;

import javax.persistence.Entity;

@Entity
@Data
public class Transaction {
    User from;
    User to;
    Long amount;
}
