create table client
(
    id    int auto_increment primary key,
    nome  varchar(60)  not null,
    email varchar(255) not null,
    phone varchar(20)  not null
);