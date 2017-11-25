create schema if not exists "public";
create table greeting (
id int primary key auto_increment,
message varchar(256) not null
);
