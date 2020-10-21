create table users
(
    id       bigint       not null auto_increment,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
) engine=InnoDB;


alter table users
    add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);


create table items
(
    id      bigint       not null auto_increment,
    name    varchar(255) not null,
    user_id bigint,
    primary key (id)
) engine=InnoDB;


alter table items
    add constraint FKtpkopyby8qwu1noj4n4t3yuig
        foreign key (user_id)
            references users (id);


insert into users (id, password, username)
values (1, '12', '1'),
       (2, '$2a$12$4Y.tuJ3zmy4Nol9LJsEdk.xaM9DGZQ095ZHAzwuVxAFKw0f.9MOyW', '2');


insert into items (id, name, user_id)
values (1, 'as12', 2),
       (2, 'asds22', 2);
