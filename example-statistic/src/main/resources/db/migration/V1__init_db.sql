
--create database if not exists statistic_test default charset=utf8mb4;

create table if not exists orig_data (
    name varchar(255) not null,
    cnt bigint(20) not null default 0,
    create_time datetime not null default current_timestamp
);

create table if not exists sum_per_min (
    create_time datetime not null,
    name varchar(255) not null,
    amount bigint(20) not null default 0,
    update_time datetime null,
    primary key (create_time, name)
);
