
create table if not exists user4(
    id  integer primary key auto_increment,
    username    varchar(32),
    regTime     varchar(32),
    password    varchar(64) character set utf8
);

create table if not exists person(
    id integer primary key auto_increment,
    interest varchar(64)
)