-- create database todo_list;

drop table if exists missions;
create table if not exists missions(
	id int auto_increment primary key,
    name varchar(50) not null,
    description varchar(255),
    completed boolean default false not null,
    created_time timestamp not null,
    last_completed_time timestamp,
    hidden boolean default false not null,
    created_by varchar(50) not null,
    last_modified_by varchar(50) not null
);

drop table if exists revinfo;
create table if not exists revinfo(
	rev int primary key,
    revtimestamp bigint
);

select * from todo_list.missions;