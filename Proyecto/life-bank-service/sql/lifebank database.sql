DROP SCHEMA if exists lifebank_products CASCADE;

CREATE SCHEMA lifebank_products;

set search_path to lifebank_products;

drop  table if exists lb_users;

create table lb_users(
    id serial not null,
    username varchar(20) not null,
    password varchar(256) not null,
    token varchar(255),
    constraint lb_users_pk primary key(id)
);
