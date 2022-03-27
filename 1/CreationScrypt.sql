create table jd2_2022.people
(
    id             int auto_increment
        primary key,
    age            int       not null,
    salary         decimal   null,
    passport       char(10)  null,
    address        char(200) not null,
    dateOfBirthday date      not null,
    dateTimeCreate datetime  not null,
    timeToLunch    timestamp not null,
    letter         text      null,
    constraint people_id_uindex
        unique (id)
);