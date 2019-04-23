package net.brobank.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Transaction")
@NamedQueries(
        @NamedQuery(name= Transaction.FIND_ALL, query="select t from Transaction t")
)
public class Transaction {

    public static final String FIND_ALL = "findAll";

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
    OffsetDateTime created;

    @Column
    @NotNull
    OffsetDateTime lastUpdate;
}
