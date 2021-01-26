create user test;
alter user test with encrypted password '123456';

create database jpatest;
grant all privileges on database jpatest to test;

create SCHEMA jpatest;
set SEARCH_PATH to jpatest;

create table users(
  userid BIGSERIAL NOT NULL PRIMARY KEY ,
  username VARCHAR(150) not null,
  password VARCHAR(50) not null,
  fullname VARCHAR(125) not null,
  role VARCHAR(50) not null,
  createddate TIMESTAMP not null,

  UNIQUE (username)
);
 -- password: 123456
insert into users(username, password, fullname, role, createddate) VALUES ('user', '$2a$10$RwH0Cl.OoPkmvoM6xUyKj.yswYCinwc7QFEXsYBoNzTxt0J8/krOu', 'Khang Nguyen', 'USER', now());
insert into users(username, password, fullname, role, createddate) VALUES ('admin', '$2a$10$RwH0Cl.OoPkmvoM6xUyKj.yswYCinwc7QFEXsYBoNzTxt0J8/krOu', 'Administrator', 'ADMIN', now());