--liquibase formatted sql
--changeset Nikita Magonov:1
create table book_author (
    book_id uuid not null constraint fk_book_author_book references book (id),
    author_id uuid not null constraint fk_book_author_author references author (id),
    constraint uq_book_author_book_id_author_id unique (book_id, author_id)
);

--changeset Nikita Magonov:2
insert into book_author (book_id, author_id)
values
    ('7d75628d-5ab0-454b-b93b-5833ad76f3de', 'df076108-1959-4554-a1de-a54532fa125f'),
    ('0961ead1-0dc1-4281-a9f5-9fb200619b26', 'd57fce79-cde1-48e6-a433-342b726af674'),
    ('0961ead1-0dc1-4281-a9f5-9fb200619b26', '7d8f89f6-2e3b-4fc9-819a-d07721b300a0');
