--liquibase formatted sql
--changeset Nikita Magonov:1
create table author (
    id uuid not null constraint pk_author primary key,
    first_name varchar(1024) not null,
    last_name varchar(1024) not null
);

--changeset Nikita Magonov:2
insert into author (id, first_name, last_name)
values
    ('df076108-1959-4554-a1de-a54532fa125f', 'Николай', 'Носов'),
    ('d57fce79-cde1-48e6-a433-342b726af674', 'Илья', 'Ильф'),
    ('7d8f89f6-2e3b-4fc9-819a-d07721b300a0', 'Евгений', 'Петров');
