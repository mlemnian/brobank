create table `brobank-admin`.transaction
(
  id int auto_increment,
  `from` long not null,
  `to` long not null,
  amount int not null,
  created datetime not null,
  lastUpdate datetime not null,
  constraint transaction_pk
    primary key (id)
);

create index transaction_id_index
  on `brobank-admin`.transaction (id);
