--liquibase formatted sql
--changeset Nikita Magonov:1
create table book (
    id uuid not null constraint pk_book primary key,
    title varchar(2048) not null,
    description text null
);

--changeset Nikita Magonov:2
insert into book (id, title)
values
    ('0961ead1-0dc1-4281-a9f5-9fb200619b26', 'Двенадцать стульев'),
    ('7d75628d-5ab0-454b-b93b-5833ad76f3de', 'Незнайка на Луне');
