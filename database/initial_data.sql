create user test;
alter user test with encrypted password '123456';

create database jpatest;
grant all privileges on database jpatest to test;

create SCHEMA jpatest;
set SEARCH_PATH to jpatest;

create table users(
  userid BIGSERIAL NOT NULL PRIMARY KEY ,
  username VARCHAR(50) not null,
  password VARCHAR(50) not null,
  fullname VARCHAR(125) not null,
  createddate TIMESTAMP not null,

  UNIQUE (username)
);

insert into users(username, password, fullname, createddate) VALUES ('khang', '123456', 'Khang Nguyen', now());