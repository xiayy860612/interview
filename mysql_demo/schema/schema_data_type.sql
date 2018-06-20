-- create table

drop database if exists mysql_improve_study;

create database mysql_improve_study default charset=utf8mb4;

use mysql_improve_study;

create table if not exists schema_test (
id int primary key not null auto_increment,
name varchar(255) not null,
create_time datetime not null default current_timestamp(),
uid binary(16) not null,
comment text not null
) engine=InnoDB;

-- show create table schema_test;

insert into schema_test (
name, create_time, uid, comment)
values
('test', current_timestamp(), unhex(replace(uuid(), '-', '')), '');

select id, name, create_time, hex(uid), comment from schema_test;

-- uuid

select hex(unhex('C53735F572C611E8B7B10800273063AB')) as uuid;

-- ip to number

select inet_aton('192.168.0.1');

select inet_ntoa(3232235521);

-- 汇总表

create table if not exists msg (
id int unsigned primary key not null auto_increment,
create_time datetime not null,
key msg_ct (create_time desc)
) engine=InnoDB default charset=utf8mb4;

insert into msg (create_time) values (now() - interval 15 minute);
insert into msg (create_time) values (now() - interval 30 minute);
insert into msg (create_time) values (now() - interval 45 minute);
insert into msg (create_time) values (now() - interval 1 hour);
insert into msg (create_time) values (now() - interval 75 minute);

insert into msg (create_time) values (now() - interval 2 hour);
insert into msg (create_time) values (now() - interval 3 hour);

create table if not exists msg_per_hr (
hr datetime primary key not null, 
cnt int unsigned not null
) engine=InnoDB default charset=utf8mb4;

-- 定时更新

insert into mysql_improve_study.msg_per_hr (hr, cnt)
select * from (select concat(left(now(), 14), '00:00'), count(*) as cnt
from mysql_improve_study.msg
where create_time between concat(left(now(), 14), '00:00') and concat(left(now(), 14), '59:59')) as tb
on duplicate key update cnt = tb.cnt;

insert into mysql_improve_study.msg_per_hr (hr, cnt)
select * from (select concat(left(now(), 14), '00:00') - interval 1 hour, count(*) as cnt
from mysql_improve_study.msg
where create_time between (concat(left(now(), 14), '00:00') - interval 1 hour) and (concat(left(now(), 14), '59:59') - interval 1 hour)) as tb
on duplicate key update cnt = tb.cnt;

insert into mysql_improve_study.msg_per_hr (hr, cnt)
select * from (select concat(left(now(), 14), '00:00') - interval 2 hour, count(*) as cnt
from mysql_improve_study.msg
where create_time between (concat(left(now(), 14), '00:00') - interval 2 hour) and (concat(left(now(), 14), '59:59') - interval 2 hour)) as tb
on duplicate key update cnt = tb.cnt;

-- 查询最近3小时实时数据, 通过小范围查询来填满间隙的严格计数

select sum(cnt)
from mysql_improve_study.msg_per_hr
where hr between concat(left(now(), 14), '00:00') - interval 2 hour and concat(left(now(), 14), '00:00') - interval 1 hour;

select count(*)
from msg
where create_time >= now() - interval 3 hour and create_time < concat(left(now(), 14), '00:00') - interval 2 hour;

select count(*)
from msg
where create_time >= concat(left(now(), 14), '00:00');

-- 上面3个查询的值相加, total = pre + sum + post

-- 多slot的计数表

create table if not exists counter_tb (
slot tinyint unsigned not null primary key, 
cnt int unsigned not null
) engine=InnoDB default charset=utf8mb4;

-- 更新时随机slot更新
insert into counter_tb (slot, cnt)
values (rand() * 10, 1)
on duplicate key update cnt = cnt + 1;

-- 查询时汇总

select * from counter_tb;

select sum(cnt)
from counter_tb;

