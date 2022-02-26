create table students
(
    id bigserial
        constraint students_pk
            primary key,
    first_name varchar(30),
    last_name varchar(30),
    personal_number varchar(11),
    email varchar(30),
    birth_date date,
    group_id bigint
);

alter table students owner to postgres;

create table teachers
(
    id bigserial
        constraint teachers_pk
            primary key,
    first_name varchar(30),
    last_name varchar(30),
    personal_number varchar(11),
    email varchar(30),
    birth_date date
);

alter table teachers owner to postgres;

create table groups
(
    id bigserial
        constraint groups_pk
            primary key,
    title varchar(40),
    group_no integer
);

alter table groups owner to postgres;

