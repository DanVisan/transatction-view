create table balances
(
    client_id    varchar(255) primary key,
    balance      double precision not null,
    last_updated varchar(100)     not null
);