create table `brobank-admin`.User
(
  id int auto_increment,
  title text null,
  unread text null,
  username text not null,
  encryptedPassword text not null,
  email text null,
  token text null,
  created datetime not null,
  lastUpdate datetime not null,
  constraint user_pk
    primary key (id)
);

create index transaction_id_index
  on `brobank-admin`.User (id);
