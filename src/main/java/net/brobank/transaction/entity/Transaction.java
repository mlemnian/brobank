package net.brobank.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @Column
    @NotNull
    Long from;

    @Column
    @NotNull
    Long to;

    @Column
    @NotNull
    Long amount;

    @Column
    @NotNull
    Timestamp created;

    @Column
    @NotNull
    Timestamp lastUpdate;
}
