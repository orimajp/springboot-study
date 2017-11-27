create schema if not exists "public";

create table process_status (
id int primary key auto_increment,
complete boolean default false
);
